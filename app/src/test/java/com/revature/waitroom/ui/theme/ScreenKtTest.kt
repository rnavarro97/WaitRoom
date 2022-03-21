package com.revature.waitroom.ui.theme

import junit.framework.TestCase

class ScreenKtTest : TestCase()
{
   fun test_signup()
   {
       var result= is_long_enough("Jon","rockband")
       assertTrue(result)
       var result1= is_long_enough("Jon","rock")
       assertFalse(result1)
       var result2= is_long_enough("","rockband")
       assertFalse(result2)
   }
    fun test_login()
    {
        var result= is_this("Jon","1234")
        assertTrue(result)
        var result1= is_long_enough("Jon","rock")
        assertFalse(result1)
        var result2= is_long_enough("Jonathan","1234")
        assertFalse(result2)
    }
}