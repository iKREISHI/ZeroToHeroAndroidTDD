package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val linearLayout = findViewById<LinearLayout>(R.id.rootLayout)
        val button = findViewById<Button>(R.id.removeButton)
        val textView = findViewById<TextView>(R.id.titleTextView)
        button.setOnClickListener {
            linearLayout.removeView(textView)
//            textView.visibility = View.GONE
        }

    }

}