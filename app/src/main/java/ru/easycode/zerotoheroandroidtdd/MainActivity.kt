package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val linearLayout = LinearLayout(this)
        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.id = R.id.rootLayout

        val textView = TextView(this)
        textView.id = R.id.titleTextView
        textView.text = "Hello World!"
        linearLayout.addView(textView)

        val button = Button(this)
        button.id = R.id.changeButton
        button.text = "change"
        button.setOnClickListener {
            textView.text = "I am an Android Developer!"
        }
        linearLayout.addView(button)

        setContentView(linearLayout)
//        val button = findViewById<Button>(R.id.changeButton)
//        val textView = findViewById<TextView>(R.id.titleTextView)
//        button.setOnClickListener {
//            textView.text = "I am an Android Developer!"
//        }
//        button.setOnClickListener(object: View.OnClickListener {
//            override fun onClick(v: View?) {
//                textView.text = "I am an Android Developer!"
//            }
//        })
    }
}