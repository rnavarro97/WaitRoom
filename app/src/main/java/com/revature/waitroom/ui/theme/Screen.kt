package com.revature.waitroom.ui.theme


fun is_long_enough(username:String,password:String):Boolean
{
    if(username.length>0&&password.length>5)
    {
        return true
    }
    return false
}

fun is_this(username:String,password:String):Boolean
{
    if (username.equals("Jon")&&password.equals("1234"))
    {
        return true
    }
    return false
}