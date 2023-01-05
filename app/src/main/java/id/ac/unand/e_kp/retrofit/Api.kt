package id.ac.unand.e_kp.retrofit

import id.ac.unand.e_kp.TugasBesarPribadi.response.ListInstansiResponse
import id.ac.unand.e_kp.TugasBesarPribadi.response.LogbookHarianResponse
import id.ac.unand.e_kp.TugasBesarPribadi.response.PatchInstansiResponse
import id.ac.unand.e_kp.response.LoginResponse
import id.ac.unand.e_kp.response.LogoutResponse
import retrofit2.Call
import retrofit2.Callback
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

    @GET("api/daily-logbooks")
//    fun getLogbookHarian(@Header("Authorization") token: String):Call<ArrayList<LogbookHarianResponse.Logbooks>>
    fun getLogbookHarian(@Header("Authorization") token: String): Call<LogbookHarianResponse>

    @GET("api/internship-agencies")
    fun getListInstansi(@Header("Authorization") token: String): Call<ListInstansiResponse>

    @FormUrlEncoded
    @PATCH("api/internship-agencies/{id}")
    fun patchAccRejcInstansi(
        @Header("Authorization") token: String,
        @Path("id") id: Int,
        @Field("status") status: Int) : Call<PatchInstansiResponse>
}