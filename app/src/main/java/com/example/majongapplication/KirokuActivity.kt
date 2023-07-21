package com.example.majongapplication

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.majongapplication.databinding.ActivityKirokuBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


private lateinit var binding: ActivityKirokuBinding

class KirokuActivity : AppCompatActivity() {

    suspend fun saveresult() = withContext(Dispatchers.IO) {
        // Create a new user with a first and last name
        val result = hashMapOf(
            "date" to binding.editText2.text,
            "number" to binding.editText1.text,
        )

// Add a new document with a generated ID
        db.collection("result")
            .add(result)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKirokuBinding.inflate(layoutInflater).apply { setContentView(this.root) }



        val etsuranIntent: Intent = Intent(this, EtsuranActivity::class.java)
        val mainIntent: Intent = Intent(this, MainActivity::class.java)

        binding.transKirokuButton2.setOnClickListener {

            startActivity(etsuranIntent)
        }

        binding.transHomeButton2.setOnClickListener {

            startActivity(mainIntent)
        }

        binding.kakuteiButton.setOnClickListener {

            GlobalScope.launch {
                saveresult()
            }

        }
    }
}