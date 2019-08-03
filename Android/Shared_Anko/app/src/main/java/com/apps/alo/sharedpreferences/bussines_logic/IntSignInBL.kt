package com.apps.alo.sharedpreferences.bussines_logic

import com.apps.alo.sharedpreferences.sign_in.model.AuthCredentials

/**
 * Created by Severiano Valdez on 01/08/17.
 */
interface IntSignInBL {

    fun checkUserCredentials(credentials: AuthCredentials):Boolean

}