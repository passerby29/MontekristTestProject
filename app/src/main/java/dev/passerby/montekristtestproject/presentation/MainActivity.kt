package dev.passerby.montekristtestproject.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.passerby.montekristtestproject.R
import dev.passerby.montekristtestproject.presentation.fragments.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.mainContainer, MainFragment())
            .commit()
    }
}