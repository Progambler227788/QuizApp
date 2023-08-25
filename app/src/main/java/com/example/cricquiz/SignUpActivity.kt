package com.example.cricquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.cricquiz.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {


            btnSignUp.setOnClickListener {
                val email = binding.emailTextS.text.toString()
                val pass = binding.passTextS.text.toString()
                val name = binding.faceTextS.text.toString()

                signUp(name,pass, email) }
        }





    }

    private fun signUp(name: String, pass: String, email: String) {

        if(email.isEmpty()) {

            Toast.makeText(this,"Email is Empty!!",Toast.LENGTH_SHORT).show()
        }
        if(pass.isEmpty()) {

            Toast.makeText(this,"Password is Empty!!",Toast.LENGTH_SHORT).show()
        }
        if(name.isEmpty()) {

            Toast.makeText(this,"Full name is Empty!!",Toast.LENGTH_SHORT).show()
        }
        else{
            val auth = FirebaseAuth.getInstance()
            auth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        val profileUpdates = UserProfileChangeRequest.Builder()
                            .setDisplayName(name)
                            .build()
                        user?.updateProfile(profileUpdates)
                    } else {
                        // Handle signup failure
                        Log.d("TAG", "Error: ${task.exception?.message}")
                        Toast.makeText(this,"${task.exception?.message}",Toast.LENGTH_SHORT).show()

                    }
                }
        }

    }


}