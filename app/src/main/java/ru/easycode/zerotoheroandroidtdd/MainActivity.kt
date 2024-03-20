package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var button: Button
    private val count = Count.Base(2, 4)
    private var uiState: UiState = UiState.Base("0")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById<Button>(R.id.incrementButton)
        textView = findViewById<TextView>(R.id.countTextView)
        button.setOnClickListener() {
            uiState = count.increment(textView.text.toString())
            uiState.apply(textView, button)
        }
    }

    override fun onSaveInstanceState(
        outState: Bundle,
    ) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, uiState)
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        uiState = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            savedInstanceState.getSerializable(KEY, UiState::class.java) as UiState
        } else {
            savedInstanceState.getSerializable(KEY) as UiState
        }
        uiState.apply(textView, button)
    }

    companion object {
        private const val KEY = "textCount"
    }
}