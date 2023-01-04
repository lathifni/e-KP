package id.ac.unand.e_kp.TugasBesarPribadi.response

import com.google.gson.annotations.SerializedName

data class ListInstansiResponse (
    @SerializedName("status"    ) var status    : String?              = null,
    @SerializedName("count"     ) var count     : Int?                 = null,
    @SerializedName("companies" ) var companies : ArrayList<Companies> = arrayListOf()
){
    data class Companies (
        @SerializedName("id"         ) var id        : Int?    = null,
        @SerializedName("name"       ) var name      : String? = null,
        @SerializedName("address"    ) var address   : String? = null,
        @SerializedName("status"     ) var status    : Int?    = null,
        @SerializedName("created_at" ) var createdAt : String? = null,
        @SerializedName("updated_at" ) var updatedAt : String? = null
    )
}