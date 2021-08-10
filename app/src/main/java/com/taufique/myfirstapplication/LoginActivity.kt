package com.taufique.myfirstapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity(){

    lateinit var etusername:EditText
    lateinit var etpassword:EditText
    lateinit var btnlogin:Button
    lateinit var forgetpassword:TextView
    lateinit var registeryourself:TextView
    val etusername1 = "12345678"
    val etpassword1 = arrayOf("tony","steve","thor","bruce","widow","panther")
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.prefrence_file_name), Context.MODE_PRIVATE)
        val isLogin = sharedPreferences.getBoolean("isLogin",false)
        setContentView(R.layout.activity_login)
        title = "Log In"
        if(isLogin){
            val intent = Intent (this@LoginActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }


        etusername = findViewById(R.id.etusername)
        etpassword = findViewById(R.id.etpassword)
        btnlogin = findViewById(R.id.btnlogin)
        forgetpassword = findViewById(R.id.txtforgot)
        registeryourself = findViewById(R.id.txtregister)

        btnlogin.setOnClickListener{
           val username = etusername.text.toString()
            val password = etpassword.text.toString()
            val intent = Intent(this@LoginActivity,MainActivity::class.java)
            var nameOfAvenger = "avenger"
            if(username==etusername1){
                if(password==etpassword1[0]){
                    nameOfAvenger = "Tony Stark"
                    savePrefrences(nameOfAvenger)
                    startActivity(intent)
                }else if(password==etpassword1[1]){
                    nameOfAvenger = "Captain America"
                    savePrefrences(nameOfAvenger)
                    startActivity(intent)
                }else if(password==etpassword1[2]){
                    nameOfAvenger = "Thor"
                    savePrefrences(nameOfAvenger)
                    startActivity(intent)
                }else if(password==etpassword1[3]){
                    nameOfAvenger = "Hulk"
                    savePrefrences(nameOfAvenger)
                    startActivity(intent)
                }else if (password==etpassword1[4]){
                    nameOfAvenger = "Black widow"
                    savePrefrences(nameOfAvenger)
                    startActivity(intent)
                }else if (password==etpassword1[5]) {
                    nameOfAvenger = "Panther"
                    savePrefrences(nameOfAvenger)
                    startActivity(intent)
                }

                } else{
                        Toast.makeText(this@LoginActivity,
                        "incorrect credential",
                                Toast.LENGTH_LONG
                        ).show()
            }

        }

        forgetpassword.setOnClickListener {
            Toast.makeText(this@LoginActivity,
                    "clicked on forgot password",
                    Toast.LENGTH_LONG
            ).show()
        }

        registeryourself.setOnClickListener {
            Toast.makeText(this@LoginActivity,
                    "clicked on Register yourself",
                    Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savePrefrences(title : String){

        sharedPreferences.edit().putBoolean("isLogin",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()

    }




}