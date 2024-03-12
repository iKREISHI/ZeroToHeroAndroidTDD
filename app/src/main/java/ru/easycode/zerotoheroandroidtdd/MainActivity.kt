package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.removeButton)
        val textView = findViewById<TextView>(R.id.titleTextView)
        val rootLayout = findViewById<LinearLayout>(R.id.rootLayout)
        button.setOnClickListener() {
            rootLayout.removeView(textView)
            button.isEnabled = false
        }
        savedInstanceState?.let {
            if (!savedInstanceState.getBoolean(R.id.titleTextView.toString())) {
                rootLayout.removeView(textView)
            }
            if (!savedInstanceState.getBoolean(R.id.removeButton.toString())) {
                button.isEnabled = false
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(R.id.titleTextView.toString(), false)
        outState.putBoolean(R.id.removeButton.toString(), false)
    }
}