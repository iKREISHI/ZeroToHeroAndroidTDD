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
        val count: Count = Count.Base(step = 2)
        savedInstanceState?.let {
            textView.text = savedInstanceState.getString(TEXT_KEY)
        }

        button.setOnClickListener() {
            textView.text = count.increment(textView.text.toString())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(TEXT_KEY, textView.text.toString())
    }

    companion object {
        private const val TEXT_KEY = "increment"
    }
}