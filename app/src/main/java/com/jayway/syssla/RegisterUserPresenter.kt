package com.jayway.syssla


class RegisterUserPresenter {

    fun isUsernameValid(username: String, setErrorMsg: (errorMsg: String) -> Unit): Boolean {
        var valid = true

        when {
            username.isEmpty() -> {
                setErrorMsg("Användarnamnet får ej vara tomt")
                valid = false
            }
        }
        return valid
    }
}