package com.jw.test

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jw.test.databinding.ActivityMainBinding
import java.net.URL

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener() {
            if (binding.edtViewChat.text.toString()
                    .equals("dotanphu") && binding.edtPassword.text.toString().equals("123456")
            ) {
                intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Sai tài khoản or mật khẩu", Toast.LENGTH_LONG).show()
            }
        }

        binding.imgGoogle.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://play.google.com/store/apps/details?id=com.example.android")
                setPackage("com.android.vending")
            }
            startActivity(intent)
        }
    }
}

