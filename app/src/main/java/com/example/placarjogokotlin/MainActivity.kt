package com.example.placarjogokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.placarjogokotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        binding.localPlusButton.setOnClickListener {
//            viewModel.incremetaUmLocal()
//        }

        botoes()

        viewModel.valorLocal.observe(this, Observer {

            binding.localScoreText.text = it.toString()

        })

        viewModel.valorVisitante.observe(this, Observer {

            binding.visitorScoreText.text = it.toString()

        })




    }
    fun botoes(){
        binding.localPlusButton.setOnClickListener {
            viewModel.incremetaUmLocal()
        }

        binding.localTwoPointsButton.setOnClickListener {
            viewModel.incremetaDoisLocal()
        }

        binding.localMinusButton.setOnClickListener {
            viewModel.decrementaLocal()
        }

        binding.visitorPlusButton.setOnClickListener {
            viewModel.incremetaUmVisitante()
        }

        binding.visitorTwoPointsButton.setOnClickListener {
            viewModel.incremetaDoisVisitante()
        }

        binding.visitorMinusButton.setOnClickListener {
            viewModel.decrementaVisitante()
        }
    }
}