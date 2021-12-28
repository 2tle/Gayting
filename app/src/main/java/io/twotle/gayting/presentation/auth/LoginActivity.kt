package io.twotle.gayting.presentation.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import io.twotle.gayting.R
import io.twotle.gayting.databinding.ActivityLoginBinding
import io.twotle.gayting.presentation.main.MainActivity

class LoginActivity : AppCompatActivity() {
    lateinit var binding:  ActivityLoginBinding;
    private lateinit var  viewModel : LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.loginVm = viewModel
        viewModel.intentEvent.observe(this, Observer{
            startActivity(Intent(this,MainActivity::class.java))
        })
    }
}

