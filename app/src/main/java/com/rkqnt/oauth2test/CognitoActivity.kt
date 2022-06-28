package com.rkqnt.oauth2test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.auth.options.AuthSignUpOptions
import com.amplifyframework.core.Amplify
import com.rkqnt.oauth2test.databinding.ActivityCognitoBinding

class CognitoActivity : AppCompatActivity() {
    lateinit var binding :ActivityCognitoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCognitoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 인증 세션 확인 : 로그인 되어있지 않을 경우 Auth session - isSignedIn = false

        /*CoroutineScope(Dispatchers.IO).launch {
            Amplify.Auth.fetchAuthSession(
                { Log.i("AmplifyQuickstart", "Auth session = $it") },
                { error -> Log.e("AmplifyQuickstart", "Failed to fetch auth session", error) }
            )
        }*/

        // 회원가입
        binding.btnSignup.setOnClickListener {
            val id = binding.editTextId.text.toString()
            val password = binding.editTextPassword.text.toString()
            val email = binding.editTextEmail.text.toString()


            val options = AuthSignUpOptions.builder()
                .userAttribute(AuthUserAttributeKey.email(), email)
                .build()

            Amplify.Auth.signUp(id , password, options,
                { Log.i("AuthQuickStart", "Sign up succeeded: $it") },
                { Log.e ("AuthQuickStart", "Sign up failed", it) }
            )
        }

        // 코드 확인
        binding.btnCodeConfirm.setOnClickListener {
            val id = binding.editTextId.text.toString()
            val code = binding.editTextConfirm.text.toString()

            Amplify.Auth.confirmSignUp(id, code,
                { result ->
                    if (result.isSignUpComplete) {
                        Log.i("AuthQuickstart", "Confirm signUp succeeded")
                    } else {
                        Log.i("AuthQuickstart","Confirm sign up not complete")
                    }
                },
                { Log.e("AuthQuickstart", "Failed to confirm sign up", it) }
            )
        }

        // 로그인
        binding.btnSignin.setOnClickListener {
            val id = binding.editTextId.text.toString()
            val password = binding.editTextPassword.text.toString()

            Amplify.Auth.signIn(id, password,
                { result ->
                    if (result.isSignInComplete) {
                        Log.i("AuthQuickstart", "Sign in succeeded")
                    } else {
                        Log.i("AuthQuickstart", "Sign in not complete")
                    }
                },
                { Log.e("AuthQuickstart", "Failed to sign in", it) }
            )
        }

        // 로그아웃
        binding.btnLogout.setOnClickListener {


        }
    }
}