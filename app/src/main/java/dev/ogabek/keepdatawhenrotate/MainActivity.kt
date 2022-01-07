package dev.ogabek.keepdatawhenrotate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var et_fullName: EditText
    private lateinit var et_email: EditText
    private lateinit var et_password: EditText
    private lateinit var btn_signUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        ifRotate(savedInstanceState)

    }

    private fun initViews() {
        et_fullName = findViewById(R.id.et_fullName)
        et_email = findViewById(R.id.et_email)
        et_password = findViewById(R.id.et_password)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("fullName", et_fullName.text.toString())
        outState.putString("email", et_email.text.toString())
        outState.putString("password", et_password.text.toString())

    }

    private fun ifRotate(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            et_fullName.setText(savedInstanceState.getString("fullName").toString())
            et_email.setText(savedInstanceState.getString("email").toString())
            et_password.setText(savedInstanceState.getString("password").toString())
        }
    }

}