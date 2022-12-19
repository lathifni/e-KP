package id.ac.unand.e_kp.retrofit

import id.ac.unand.e_kp.response.LoginResponse
import id.ac.unand.e_kp.response.LogoutResponse
import retrofit2.Call
import retrofit2.http.*

interface Api {
    @FormUrlEncoded
    @POST("api/login")
    fun login (
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @POST("api/logout")
    fun logout(@Header("Authorization") token: String) : Call<LogoutResponse>
}