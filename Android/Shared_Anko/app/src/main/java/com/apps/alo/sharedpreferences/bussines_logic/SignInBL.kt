package com.apps.alo.sharedpreferences.bussines_logic

import com.apps.alo.sharedpreferences.sign_in.model.AuthCredentials

/**
 * Created by Severiano Valdez on 01/08/17.
 */
class SignInBL : IntSignInBL {
    override fun checkUserCredentials(credentials: AuthCredentials): Boolean {
        return (username.equals(credentials.username)) && "snowman".equals(credentials.password)
    }
}