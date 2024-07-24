/*
 * *
 *  * Copyright (c) $YEAR $USER. All rights reserved.
 *  *
 *  * Created by $USER on $DATE.
 *  * Filename: $NAME
 *
 */

package com.example.rockpaperscissors

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rockpaperscissors.view.RockPapperScissorsFragment

class MainActivity : AppCompatActivity() {
    private final var TAG: String = MainActivity::class.java.toString()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            Log.d(TAG, "onCreate: not equal null")
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, RockPapperScissorsFragment())
                .commit()
        }
    }
}