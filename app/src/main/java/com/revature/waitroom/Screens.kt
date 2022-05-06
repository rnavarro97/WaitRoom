package com.revature.waitroom

sealed class Screens(val route:String)
{
    object Welcome: Screens("welcomeScreen")
    object Login: Screens("loginScreen")
    object Signup: Screens("SignupScreen")
}
