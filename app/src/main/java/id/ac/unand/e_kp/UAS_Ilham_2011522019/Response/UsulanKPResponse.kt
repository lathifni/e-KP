package id.ac.unand.e_kp.UAS_Ilham_2011522019.Response

import com.google.gson.annotations.SerializedName

data class UsulanKPResponse(

    @SerializedName("status") var status : String?              = null,
    @SerializedName("count") var count : Int?                 = null,
    @SerializedName("proposals") var proposals : ArrayList<Proposals> = arrayListOf()
){
    data class Proposals (
        @SerializedName("id") var id : Int?    = null,
        @SerializedName("name") var name : String? = null,
        @SerializedName("start_at") var start_at : String? = null,
        @SerializedName("end_at") var end_at : String?    = null,
        @SerializedName("num") var num : Int? = null,
    )
}