package com.example.majongapplication

import android.content.Intent
import android.os.Build.VERSION_CODES.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.majongapplication.databinding.ActivityEtsuranBinding

private lateinit var binding: ActivityEtsuranBinding

class EtsuranActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEtsuranBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val kirokuIntent: Intent = Intent(this, KirokuActivity::class.java)
        val mainIntent: Intent = Intent(this, MainActivity::class.java)

        binding.transHomeButton.setOnClickListener {

            startActivity(mainIntent)
        }

        binding.transKirokuButton.setOnClickListener {

            startActivity(kirokuIntent)
        }

    }
}