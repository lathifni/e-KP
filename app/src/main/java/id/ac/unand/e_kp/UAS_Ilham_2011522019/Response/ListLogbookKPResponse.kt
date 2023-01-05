package id.ac.unand.e_kp.UAS_Ilham_2011522019.Response

import com.google.gson.annotations.SerializedName

data class ListLogbookKPResponse(
    @SerializedName("id") var id: Int?  = null,
    @SerializedName("status") var status: Int? = null,
    @SerializedName("logbooks") var logbooks : ArrayList<Logbooks> = arrayListOf()
){
    data class Logbooks (
        @SerializedName("id") var id  : Int? = null,
        @SerializedName("internship_id") var internship_id  : Int? = null,
        @SerializedName("date") var date  : String? = null,
        @SerializedName("activities") var activities  : String? = null,
        @SerializedName("note") var note : String? = null,
        @SerializedName("status") var status : Int? = null,
        @SerializedName("created_at") var created_at : String? = null,
        @SerializedName("updated_at") var updated_at : String? = null,
    )
}