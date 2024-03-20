package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import java.security.Key

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById<Button>(R.id.incrementButton)
        textView = findViewById<TextView>(R.id.countTextView)
        button.setOnClickListener() {
            textView.text = if (textView.text.toString().toInt() < 4) (textView.text.toString().toInt() + 2).toString() else textView.text.toString()
            if (textView.text.toString().toInt() >= 4) button.isEnabled = false
        }
    }

    override fun onSaveInstanceState(
        outState: Bundle,
    ) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(BTN_KEY, button.isEnabled)
        outState.putString(TEXT_KEY, textView.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textView.text = savedInstanceState.getString(TEXT_KEY)
        button.isEnabled = savedInstanceState.getBoolean(BTN_KEY)
    }

    companion object {
        private const val TEXT_KEY = "textCount"
        private const val BTN_KEY = "incrementBtn"
    }
}