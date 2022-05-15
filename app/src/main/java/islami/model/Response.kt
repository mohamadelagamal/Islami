package islami.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("Radios")
	@Expose
	val radios: List<RadiosItem?>? = null
)

data class RadiosItem(
	@field:SerializedName("URL")
	@Expose
	val uRL: String? = null,
	@field:SerializedName("Name")
	@Expose
	val name: String? = null
)
