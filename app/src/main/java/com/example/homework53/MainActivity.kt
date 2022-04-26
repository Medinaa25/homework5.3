package com.example.homework53

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework53.databinding.ActivityMainBinding

private lateinit var binding : ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnListener()
        onActivityResult(RESULT_OK,0,intent)
        val textValue = intent.getStringExtra("KEY")
        binding.edittext.setText(textValue)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val  text : String = intent.getStringExtra("KEY").toString()
        if (resultCode == RESULT_OK && requestCode == 0){
            binding.edittext.setText(text)
        }
    }


    private fun btnListener() {
        binding.button.setOnClickListener() {
            if (binding.edittext.length() <= 0) {
                Toast.makeText(
                    applicationContext,
                    "EditText не может существовать без текста!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("KEY", binding.edittext.text.toString())
                startActivity(intent)
            }

        }
    }


}