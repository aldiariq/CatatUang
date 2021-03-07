package com.example.catatuang

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.catatuang.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.registerBtnRegister.setOnClickListener {
            var nama: String
            var email: String
            var password1: String
            var password2: String

            nama = binding.registerEtNama.text.toString()
            email = binding.registerEtEmail.text.toString()
            password1 = binding.registerEtPassword1.text.toString()
            password2 = binding.registerEtPassword2.text.toString()

            if (nama.equals("") || email.equals("") || password1.equals("") || password2.equals("")){
                Toast.makeText(this, "Pastikan Inputan Terisi", Toast.LENGTH_SHORT).show()
            }else {
                if (password1.equals(password2)){
                    fungsiRegister(nama, email, password1)
                }else {
                    Toast.makeText(this, "Pastikan Password Sama", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.registerTvLogin.setOnClickListener {
            this.finish()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun fungsiRegister(namaPengguna: String, emailPengguna: String, passwordPengguna: String){
        Toast.makeText(this, namaPengguna+emailPengguna+passwordPengguna, Toast.LENGTH_SHORT).show()
    }
}