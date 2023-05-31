package ru.nota.notes.presentation.main

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle

import ru.nota.notes.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Устанавливаем разметку
        setContentView(R.layout.activity_main)
    }
}