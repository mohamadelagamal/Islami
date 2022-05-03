package islami.ui.quran

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class QuranData(
    var id : String?=null,
    var name :String ?=null,
    var numberSura:String?=null
): Parcelable{
    companion object{
        val EXTRA_SuRA_NAME:String="sura_name"
    }
}
