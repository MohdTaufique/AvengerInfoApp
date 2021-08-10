package com.taufique.myfirstapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var titleName: String? = "Avengers"
    lateinit var logout : Button
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(getString(R.string.prefrence_file_name),Context.MODE_PRIVATE)
        setContentView(R.layout.activity_scroll_view)
        titleName = sharedPreferences.getString("Title","Avengers")

        title = titleName

        logout = findViewById(R.id.btnlogout)

        logout.setOnClickListener {
            savePrefrences()
            val intent = Intent(this@MainActivity,LoginActivity::class.java)
            startActivity(intent)
            finish()

        }





    }

    fun savePrefrences() {

        sharedPreferences.edit().putBoolean("isLogin", false).apply()

    }
}