package com.rkqnt.oauth2test

import android.app.Application
import android.util.Log
import com.amplifyframework.AmplifyException
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin
import com.amplifyframework.core.Amplify

class OAuth2App : Application() {
    override fun onCreate() {
        super.onCreate()

        try {
            Amplify.addPlugin(AWSCognitoAuthPlugin())
            Amplify.configure(applicationContext)
            Log.i("OAuth2App", "Initialized Amplify")
        } catch (error: AmplifyException) {
            Log.e("OAuth2App", "Could not initialize Amplify", error)
        }
    }
}