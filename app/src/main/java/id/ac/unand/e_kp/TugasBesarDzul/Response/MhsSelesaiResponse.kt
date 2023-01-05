package id.ac.unand.e_kp.TugasBesarDzul.Response

import com.google.gson.annotations.SerializedName

data class MhsSelesaiResponse (

    @SerializedName("status"      ) var status    : String?              = null,
    @SerializedName("count"       ) var count     : Int?                 = null,
    @SerializedName("internships" ) var internships : ArrayList<Internships> = arrayListOf()
){
    data class Internships (

        @SerializedName("id"           ) var id              : Int?    = null,
        @SerializedName("name"         ) var name            : String? = null,
        @SerializedName("nim"          ) var nim             : String? = null,
        @SerializedName("agency"       ) var agency          : String? = null,
        @SerializedName("title"        ) var judul           : String? = null,
        @SerializedName("start_at"     ) var startAt         : String? = null,
        @SerializedName("end_at"       ) var endAt           : String? = null,
        @SerializedName("status"       ) var status          : Int?    = null,
        @SerializedName("supervisor_id") var supervisorId    : Int?    = null,
        @SerializedName("supervisor"   ) var supervisor      : String? = null
    )
}