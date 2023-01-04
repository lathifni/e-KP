package id.ac.unand.e_kp.TugasBesarPribadi.response

import com.google.gson.annotations.SerializedName

data class LogbookHarianResponse(

    @SerializedName("status"   ) var status   : String?             = null,
    @SerializedName("count"    ) var count    : Int?                = null,
    @SerializedName("logbooks" ) var logbooks : ArrayList<Logbooks> = arrayListOf()
){
    data class Logbooks (

        @SerializedName("name"       ) var name       : String? = null,
        @SerializedName("nim"        ) var nim        : String? = null,
        @SerializedName("start_at"   ) var startAt    : String? = null,
        @SerializedName("end_at"     ) var endAt      : String? = null,
        @SerializedName("activities" ) var activities : String? = null

    )
}
