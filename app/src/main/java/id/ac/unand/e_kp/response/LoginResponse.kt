package id.ac.unand.e_kp.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    val user: User?,
    val authorisation: Authorisation?
){
    data class User (
        @SerializedName("name")
        val nama: String?
    )
    data class Authorisation (
        val token: String?
    )
}
