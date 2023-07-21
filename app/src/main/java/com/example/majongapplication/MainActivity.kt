package com.example.majongapplication

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.majongapplication.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

val db = Firebase.firestore

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user = hashMapOf(
            "first" to "Haruto",
            "last" to "Yamanaka",
            "born" to 2007,
        )

        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }


        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root)}

        val kirokuIntent: Intent = Intent(this, KirokuActivity::class.java)

        val etsuranIntent: Intent = Intent(this, EtsuranActivity::class.java)

        binding.kirokuButton.setOnClickListener {

            startActivity(kirokuIntent)

        }


        binding.eturanButton.setOnClickListener {

            startActivity(etsuranIntent)
        }
    }
}