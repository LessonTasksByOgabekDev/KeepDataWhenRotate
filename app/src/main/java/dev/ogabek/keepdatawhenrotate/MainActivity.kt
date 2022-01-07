package dev.ogabek.keepdatawhenrotate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var et_count: EditText
    private lateinit var tv_count: TextView
    private lateinit var btn_count: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        ifRotate(savedInstanceState)

    }

    private fun initViews() {
        et_count = findViewById(R.id.et_count)
        tv_count = findViewById(R.id.tv_count)
        btn_count = findViewById(R.id.btn_count)

        btn_count.setOnClickListener {
            setCount()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("tv_count", tv_count.text.toString())
        outState.putString("btn_count", btn_count.text.toString())

    }

    private fun ifRotate(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            tv_count.text = savedInstanceState.getString("tv_count").toString()
            btn_count.setText(savedInstanceState.getString("btn_count").toString())
        }
    }

    private fun setCount() {
        val count = tv_count.text.toString().toInt() + 1
        tv_count.text = count.toString()
        et_count.setText(count.toString())
    }

}