package com.apps.alo.sharedpreferences.sign_in

import android.graphics.Color
import android.os.Build
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.widget.EditText
import com.apps.alo.sharedpreferences.LoginActivity
import com.apps.alo.sharedpreferences.MainActivity
import com.apps.alo.sharedpreferences.R
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by Severiano Valdez on 01/08/17.
 */
class SigninView : AnkoComponent<SignInActivity> {

    //What I did is that I store ui: AnkoContext<SignInActivity>
    // as the global variable to have access from others functions in
    // the SignInView class
    private lateinit var ankoContext: AnkoContext<SignInActivity>

    override fun createView(ui: AnkoContext<SignInActivity>) = with(ui) {
        ankoContext = ui
        // CAMBIOS
        verticalLayout {
            this.gravity = Gravity.CENTER
            //Para dispositivos pequeños
            scrollView {

                verticalLayout {

                    verticalLayout {
                        id = R.id.formLogin
                        gravity = Gravity.CENTER
                        padding = dip(20)

                        lparams(width = dip(300), height = matchParent) {
                            this.gravity = Gravity.CENTER
                            // API >= 16
                            //the view setbackground requiere api 16 >=  | Requerimiento
                            doFromSdk(version = Build.VERSION_CODES.JELLY_BEAN) {
                                background = ContextCompat.getDrawable(ctx, android.R.color.white)
                            }
                            clipToPadding = false
                            bottomMargin = dip(16)
                        }

                        toolbar {
                            id = R.id.toolBar
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                setTitleTextColor(Color.WHITE)

                            }
                        }.lparams(width = matchParent, height = wrapContent)

                        val username = editText {
                            id = R.id.editTextUsuario
                            hintResource = R.string.signin_username
                        }.lparams(width = matchParent, height = wrapContent)

                        val password = editText {
                            id = R.id.editTextPassword
                            hintResource = R.string.signin_password
                        }.lparams(width = matchParent, height = wrapContent)

                        switch {
                            id = R.id.switchAnko
                            if (isChecked) {

                            }
                        }

                        button {
                            id = R.id.btn_login
                            textResource = R.string.signin_button

                            onClick {
                                if (handleOnSignInButtonPressed(
                                        username = username.text.toString(),
                                        password = password.text.toString())) {
                                    //startActivity<MainActivity>()
                                }

                            }
                        }.lparams(width = matchParent, height = wrapContent)
                        // *** AÑADIR AHORA
                        //Anko has a useful extension function to apply parameters to view
                        // and to all of its children recursively:
                    }.applyRecursively { view ->
                        when (view) {
                            is EditText -> view.textSize = 24f
                        }
                    }

                }.lparams(width = matchParent, height = matchParent)
            }.lparams(width = matchParent, height = matchParent)

        }

    }

    private fun handleOnSignInButtonPressed(username: String, password: String): Boolean {
        with(ankoContext) {
            if (username.isBlank() || password.isBlank()) {
                alert(title = R.string.signin_alert_invalid_title,
                        message = R.string.signin_alert_invalid_message) {
                    positiveButton(R.string.dialog_btn_close) {}
                }.show()
                return false
            } else {
                owner.authorizeUser(username, password)
                return true
            }
        }
    }

    fun showAccesDeniedAlertDialog() {
        with(ankoContext) {
            alert(title = R.string.signin_alert_access_denied_title,
                    message = R.string.signin_alert_access_denied_msg)
        }
    }
}