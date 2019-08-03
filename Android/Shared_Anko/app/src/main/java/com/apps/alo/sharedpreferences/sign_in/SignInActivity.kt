package com.apps.alo.sharedpreferences.sign_in

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.apps.alo.sharedpreferences.MainActivity
import com.apps.alo.sharedpreferences.bussines_logic.IntSignInBL
import com.apps.alo.sharedpreferences.bussines_logic.SignInBL
import com.apps.alo.sharedpreferences.sign_in.model.AuthCredentials
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class SignInActivity : AppCompatActivity() {

    private val signInBL : IntSignInBL = SignInBL()
    //What I did is that I store ui: AnkoContext<SignInActivity>
    // as the global variable to have access from others functions in
    // the SignInView class
    private lateinit var view: SigninView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = SigninView()
        view.setContentView(this)

    }
    //In our SignInActivity, we need to check if the user who is trying to sign in
    // with our app have correct credentials. In a real application,
    // we can have user’s credentials stored in the database but in our case
    // to make it simple we have this hard coded in our business logic.
    // This call to check credentials we will do on the background thread
    // (async way) and result we will handle on the ui thread.
    fun authorizeUser(username: String, password: String) {
        doAsync {
            val authorized = signInBL.checkUserCredentials(AuthCredentials(username = username, password = password))

            activityUiThread {
                if (authorized) toast("Signed!!!") else view.showAccesDeniedAlertDialog()
            }
        }//In a code snippet above, we check user’s credentials on background
        // thread (in async way) and result has been delivered back to the UI
        // thread where toast will be show in case of correct credentials otherwise,
        // the Access Denied Alert dialog will be showing
    }
}
