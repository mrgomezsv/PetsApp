package com.pets.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class activity_login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        goHome()
        goRegister()
    }

    private fun goHome(){
        val buttonLogin: Button = findViewById(R.id.buttonLogin)
        buttonLogin.setOnClickListener {
            val intent = Intent(this, activity_home::class.java)
            startActivity(intent)
        }
    }

    private fun goRegister() {
        val buttonRegister: Button = findViewById(R.id.buttonRegisterLogin)
        buttonRegister.setOnClickListener {
            val intent = Intent(this, activity_register::class.java)
            startActivity(intent)
        }
    }
}