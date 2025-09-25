package com.bruno.firstproject.business

class UserBusiness {


    fun checkCredentials(name: String, password: String): Boolean{
        return name.isNotEmpty() || password.isNotEmpty()
    }

}