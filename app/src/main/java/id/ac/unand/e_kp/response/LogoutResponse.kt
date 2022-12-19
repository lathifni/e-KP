package id.ac.unand.e_kp.response

import com.google.gson.annotations.SerializedName

data class LogoutResponse(

	@field:SerializedName("message")
	val message: String? = null
)
