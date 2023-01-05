package id.ac.unand.e_kp.retrofit

import id.ac.unand.e_kp.UAS_Ilham_2011522019.Response.ListLogbookKPResponse
import id.ac.unand.e_kp.UAS_Ilham_2011522019.Response.PembimbingKpResponse
import id.ac.unand.e_kp.UAS_Ilham_2011522019.Response.UsulanKPResponse
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

    @GET("api/internship-proposals/1")
    fun detail_usulan(@Header("Authorization") token: String) :Call<UsulanKPResponse>

    @GET("api/my-internship/2/logbook")
    fun logbook(@Header("Authorization") token: String) :Call<ListLogbookKPResponse>

    @GET("api/internship-supervisors/")
    fun pembimbing(@Header("Authorization") token: String) :Call<PembimbingKpResponse>

}