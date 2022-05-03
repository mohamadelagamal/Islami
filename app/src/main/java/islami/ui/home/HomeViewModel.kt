package islami.ui.home
import android.annotation.SuppressLint
import android.view.View
import islami.ui.base.BaseViewModel

class HomeViewModel: BaseViewModel <Navigator>() {

    @SuppressLint("StaticFieldLeak")
    lateinit var view:View
    var itemID :Int ?=null

}

