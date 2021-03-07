package com.example.catatuang

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.catatuang.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.loginBtnLogin.setOnClickListener {
            var email: String
            var password: String

            email = binding.loginEtEmail.text.toString()
            password = binding.loginEtPassword.text.toString()

            if (email.equals("") || password.equals("")){
                Toast.makeText(this, "Pastikan Inputan Terisi", Toast.LENGTH_SHORT).show()
            }else {
                fungsiLogin(email, password)
            }

            this.finish()
            startActivity(Intent(this, DashboardActivity::class.java))
        }

        binding.loginTvRegister.setOnClickListener {
            this.finish()
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.loginTvResetpassword.setOnClickListener {
            this.finish()
            startActivity(Intent(this, ResetpasswordActivity::class.java))
        }
    }

    private fun fungsiLogin(emailPengguna: String, passwordPengguna: String){
        Toast.makeText(this, emailPengguna+passwordPengguna, Toast.LENGTH_SHORT).show()
    }
}