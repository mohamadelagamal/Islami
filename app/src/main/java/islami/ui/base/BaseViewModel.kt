package islami.ui.base

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.google.android.material.navigation.NavigationView

open class BaseViewModel <N>: ViewModel() {

    @SuppressLint("StaticFieldLeak")
    var item_navigation :NavigationView?=null
    var navigation : N?=null
}