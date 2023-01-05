package id.ac.unand.e_kp.TugasBesarPribadi.response

import com.google.gson.annotations.SerializedName

data class PatchInstansiResponse(
    @SerializedName("status"  ) var status  : String? = null,
    @SerializedName("message" ) var message : String? = null
)
