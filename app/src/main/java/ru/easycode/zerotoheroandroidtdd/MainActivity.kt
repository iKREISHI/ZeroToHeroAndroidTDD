package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.incrementButton)
        textView = findViewById<TextView>(R.id.countTextView)

        savedInstanceState?.let {
            textView.text = savedInstanceState.getString("increment")
        }

        button.setOnClickListener() {
            textView.text = (textView.text.toString().toInt() + 2).toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("increment", textView.text.toString())
    }
}