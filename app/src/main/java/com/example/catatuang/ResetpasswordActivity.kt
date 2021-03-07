package com.example.catatuang

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.catatuang.databinding.ActivityResetpasswordBinding

class ResetpasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResetpasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResetpasswordBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.resetpasswordBtnReset.setOnClickListener {
            var email: String

            email = binding.resetpasswordEtEmail.text.toString()

            if (email.equals("")){
                Toast.makeText(this, "Pastikan Inputan Terisi", Toast.LENGTH_SHORT).show()
            }else {
                fungsiresetPassword(email)
            }

            this.finish()
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.resetpasswordTvLogin.setOnClickListener {
            this.finish()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun fungsiresetPassword(emailPengguna: String){
        Toast.makeText(this, emailPengguna, Toast.LENGTH_SHORT).show()
    }


}