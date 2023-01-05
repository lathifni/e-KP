package id.ac.unand.e_kp.TugasBesarDzul.Response

import com.google.gson.annotations.SerializedName

data class UsulanResponse (

    @SerializedName("status"      ) var status    : String?              = null,
    @SerializedName("count"       ) var count     : Int?                 = null,
    @SerializedName("proposals"   ) var proposals : ArrayList<Proposals> = arrayListOf()
){
    data class Proposals (

        @SerializedName("id"           ) var id              : Int?    = null,
        @SerializedName("name"         ) var name            : String? = null,
        @SerializedName("start_at"     ) var startAt         : String? = null,
        @SerializedName("end_at"       ) var endAt           : String? = null,
        @SerializedName("num"          ) var num             : Int?    = null,
    )
}