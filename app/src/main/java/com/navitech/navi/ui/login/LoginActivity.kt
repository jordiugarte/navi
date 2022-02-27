package com.navitech.navi.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.navitech.navi.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.navitech.navi.data.model.LoginModel
import com.navitech.navi.R
import com.navitech.navi.data.model.BaseResponse
import com.navitech.navi.data.network.LoginService
import com.navitech.navi.utils.Router


class LoginActivity : AppCompatActivity() {

    private val context = this
    private val TAG = "Login"

    lateinit var userField: EditText
    lateinit var passwordField: EditText

    private lateinit var binding: ActivityLoginBinding

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = Firebase.auth
        initViews()
    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            //reload();
        }
    }

    fun initViews() {
        userField = findViewById(R.id.login_user_field)
        passwordField = findViewById(R.id.login_password_field)
    }

    fun login(view: View) {
        LoginService.login(LoginModel(userField.text.toString(), passwordField.text.toString()),
            object : ParsedRequestListener<BaseResponse> {
                override fun onResponse(response: BaseResponse) {
                    if (response.isSuccess()) {
                        Router.toHome(context)
                    }
                }

                override fun onError(anError: ANError) {
                    //onError(ErrorRepository.anErrorFromCustomError(CustomError.LOGIN));
                }
            })
    }

    private fun googleLogin(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    //updateUI(null)
                }
            }
    }
}