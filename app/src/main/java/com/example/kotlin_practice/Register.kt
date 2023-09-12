package com.example.kotlin_practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Register : AppCompatActivity() {
    private lateinit var  auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = Firebase.auth
    }

    fun goToLogin(view: View) {
        val intent= Intent(this, Login::class.java)
        startActivity(intent)
    }

    fun register(view: View) {
        val email = findViewById<EditText>(R.id.editTextEmailAddress).text.toString().trim()
        val password = findViewById<EditText>(R.id.editTextPassword).text.toString().trim()

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if(task.isSuccessful) {
                val intent= Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()
        }
    }
}