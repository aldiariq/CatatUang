package com.example.catatuang

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.catatuang.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Thread(Runnable {
            while (i < 100) {
                i += 1
                try {
                    Thread.sleep(50)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
            this.finish()
            startActivity(Intent(this, LoginActivity::class.java))
        }).start()
    }
}