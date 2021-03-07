package com.example.catatuang

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.catatuang.databinding.*
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var teksPencarian: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        binding.dashboardEtPencarian.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                teksPencarian = binding.dashboardEtPencarian.text.toString()
            }

        })

        binding.dashboardFabTransaksi.setOnClickListener {
            val bindingdialog: LayoutTransaksiBinding
            bindingdialog = LayoutTransaksiBinding.inflate(layoutInflater)

            MaterialAlertDialogBuilder(this)
                .setView(bindingdialog.root)
                .setNegativeButton("Batal") { dialog, which ->
                    dialog.dismiss()
                }
                .setPositiveButton("Simpan") { dialog, which ->
                    dialog.dismiss()
                    var jumlahCatatan = ""
                    var jenisCatatan = ""

                    jumlahCatatan = bindingdialog.dialogtransaksiEtJumlah.text.toString()
                    if (bindingdialog.dialogtransaksiRbPemasukan.isChecked){
                        jenisCatatan = "PEMASUKAN"
                    }else if (bindingdialog.dialogtransaksiRbPengeluaran.isChecked){
                        jenisCatatan = "PENGELUARAN"
                    }

                    if (jumlahCatatan.equals("") || jenisCatatan.equals("")){
                        Toast.makeText(this, "Pastikan Inputan Terisi", Toast.LENGTH_SHORT).show()
                    }else {
                        fungsiSimpancatatan(jumlahCatatan, jenisCatatan)

                    }
                }
                .show()
        }

        binding.dashboardIvResetcatatan.setOnClickListener {
            val bindingdialog: LayoutResetBinding
            bindingdialog = LayoutResetBinding.inflate(layoutInflater)

            MaterialAlertDialogBuilder(this)
                    .setView(bindingdialog.root)
                    .setNegativeButton("Tidak") { dialog, which ->
                        dialog.dismiss()
                    }
                    .setPositiveButton("Ya") { dialog, which ->
                        dialog.dismiss()
                        fungsiresetCatatan()
                    }
                    .show()
        }

        binding.dashboardIvGantipassword.setOnClickListener {
            val bindingdialog: LayoutGantipasswordBinding
            bindingdialog = LayoutGantipasswordBinding.inflate(layoutInflater)

            MaterialAlertDialogBuilder(this)
                .setView(bindingdialog.root)
                .setNegativeButton("Batal") { dialog, which ->
                    dialog.dismiss()
                }
                .setPositiveButton("Simpan") { dialog, which ->
                    dialog.dismiss()
                    var passwordLama: String
                    var passwordBaru1: String
                    var passwordBaru2: String

                    passwordLama = bindingdialog.dialoggantipasswordEtPasswordlama.text.toString()
                    passwordBaru1 = bindingdialog.dialoggantipasswordEtPasswordbaru1.text.toString()
                    passwordBaru2 = bindingdialog.dialoggantipasswordEtPasswordbaru2.text.toString()

                    if (passwordLama.equals("") || passwordBaru1.equals("") || passwordBaru2.equals("")){
                        Toast.makeText(this, "Pastikan Inputan Terisi", Toast.LENGTH_SHORT).show()
                    }else {
                        if (passwordBaru1.equals(passwordBaru2)){
                            fungsiGantipassword(passwordLama, passwordBaru1, passwordBaru2)
                        }else {
                            Toast.makeText(this, "Password Tidak Sama", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                .show()
        }

        binding.dashboardIvLogout.setOnClickListener {
            val bindingdialog: LayoutKeluarBinding
            bindingdialog = LayoutKeluarBinding.inflate(layoutInflater)

            MaterialAlertDialogBuilder(this)
                .setView(bindingdialog.root)
                .setNegativeButton("Tidak") { dialog, which ->
                    dialog.dismiss()
                }
                .setPositiveButton("Ya") { dialog, which ->
                    dialog.dismiss()
                    fungsiLogout()
                }
                .show()
        }
    }

    private fun fungsiLogout(){
        this.finish()
        startActivity(Intent(this, LoginActivity::class.java))
    }

    private fun fungsiGantipassword(passwordLama: String, passwordBaru1: String, passwordBaru2: String){
        Toast.makeText(this, passwordLama+passwordBaru1+passwordBaru2, Toast.LENGTH_SHORT).show()
        fungsiLogout()
    }

    private fun fungsiSimpancatatan(jumlahCatatan: String, jenisCatatan:String){
        Toast.makeText(this, jumlahCatatan+jenisCatatan, Toast.LENGTH_SHORT).show()
    }

    private fun fungsiresetCatatan(){

    }
}