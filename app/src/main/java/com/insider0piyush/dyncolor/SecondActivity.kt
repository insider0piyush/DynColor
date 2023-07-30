package com.insider0piyush.dyncolor

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.insider0piyush.dyncolor.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity(){
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadSetting()

        binding.switch1.setOnCheckedChangeListener{ switch , enable  ->
            if( switch.isChecked && enable){
                saveSetting()
                showToast("ON")
            }else{
                saveSetting()
                showToast("OFF")
            }
        }
    }
    private fun saveSetting() {
        val sharedPreferences = getSharedPreferences("SharedPreferenceDemo",MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply{
            putBoolean("DynamicColor",binding.switch1.isChecked)
        }.apply()
    }

    private fun loadSetting() {
        val sharedPreferences = getSharedPreferences("SharedPreferenceDemo",MODE_PRIVATE)
        binding.switch1.isChecked = sharedPreferences.getBoolean("DynamicColor",false)
    }

    private fun showToast(string: String){
        Toast.makeText(applicationContext,string,Toast.LENGTH_SHORT).show()
    }
}