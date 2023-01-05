package id.ac.unand.e_kp.UAS_Ilham_2011522019.Response

import com.google.gson.annotations.SerializedName

data class PembimbingKpResponse(
    @SerializedName("status") var status: String?  = null,
    @SerializedName("message") var message: String? = null,
)
