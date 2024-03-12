package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById<TextView>(R.id.titleTextView)
        savedInstanceState?.let {
            textView.isVisible = savedInstanceState.getBoolean("isVisible")
        }
        val button = findViewById<Button>(R.id.hideButton)
        button.setOnClickListener(View.OnClickListener {
            textView.isVisible = false
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("isVisible", textView.isVisible)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}