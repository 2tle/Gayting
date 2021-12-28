package io.twotle.gayting.presentation.auth

import android.app.Application
import android.content.Intent
import android.text.Editable
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginViewModel(application: Application): AndroidViewModel(application) {
    private val _intentEvent = SingleLiveEvent<Void>()
    val intentEvent: LiveData<Void> = _intentEvent;
    val email = MutableLiveData<String>()
    val pw = MutableLiveData<String>()
    fun login() {
        Log.d(">","DSafadsfadsfadsfcadsfadsefaergtwhs")
        Firebase.auth.signInWithEmailAndPassword(email.value!!,pw.value!!).addOnCompleteListener {
            if(it.isSuccessful) {
                _intentEvent.call()
            }
        }
    }
}