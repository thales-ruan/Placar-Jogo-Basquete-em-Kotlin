package com.example.placarjogokotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.placarjogokotlin.databinding.ActivityFinalBinding

class ActivityFinal : AppCompatActivity() {

    private lateinit var binding: ActivityFinalBinding

    var vencedor = 0
    var perderdor = 0

    companion object {
        val LOCAL_KEY = "local_valor"
        val VISITANTE_KEY = "local_visitante"
    }



    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFinalBinding.inflate(layoutInflater)
        setContentView(binding.root)


        try {
            val localValor = intent.extras!!.getInt(LOCAL_KEY)
            val visitanteValor = intent.extras!!.getInt(VISITANTE_KEY)
            if (localValor > visitanteValor) {
                binding.whoWonText.setText("Local Venceu!")
                vencedor = localValor
                perderdor = visitanteValor
            } else if (visitanteValor > localValor) {
                binding.whoWonText.setText("Visitante Venceu!")
                vencedor = visitanteValor
                perderdor = localValor
            } else {
                binding.whoWonText.setText("EMPATE!!!!!!")
            }
            binding.scoreText.setText(
                Integer.toString(vencedor) + " X " + Integer.toString(
                    perderdor
                )
            )
        } catch (e: NullPointerException) {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)

        }

    }
}