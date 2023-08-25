package com.example.cricquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.cricquiz.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            tvRegister.setOnClickListener {
                startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
            }
            btnLogin.setOnClickListener {
                Toast.makeText(this@LoginActivity,"Hello", Toast.LENGTH_SHORT).show()
                login(emailText.text.toString(),passText.text.toString())
            }
        }



    }

    private fun login(email: String, pass: String) {

        if(email.isEmpty()) {

            Toast.makeText(this,"Email is Empty!!", Toast.LENGTH_SHORT).show()
        }
        if(pass.isEmpty()) {

            Toast.makeText(this,"Password is Empty!!", Toast.LENGTH_SHORT).show()
        }

        else{
            val auth = FirebaseAuth.getInstance()
            auth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this,"Thank You", Toast.LENGTH_SHORT).show()
                    } else {
                        // Handle signup failure
                        Log.d("TAG", "Error: ${task.exception?.message}")
                        Toast.makeText(this,"${task.exception?.message}", Toast.LENGTH_SHORT).show()

                    }
                }
        }

    }

}