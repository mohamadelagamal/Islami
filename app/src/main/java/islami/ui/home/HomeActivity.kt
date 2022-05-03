package islami.ui.home
import android.os.Bundle
import android.view.Display
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.islami.R
import com.islami.databinding.ActivityHomeBinding
import islami.ui.base.BaseActivity
class HomeActivity : BaseActivity<ActivityHomeBinding , HomeViewModel>() , Navigator{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_SplashAPIGFG)
        viewDataBinding.vmHome=viewModel
        viewModel.navigation=this
        itemNavigation()
        }
    override fun getLayoutID(): Int {
        return R.layout.activity_home
    }
    override fun makeViewModelProvider(): HomeViewModel {
      return ViewModelProvider(this).get(HomeViewModel::class.java)
    }
    override fun itemNavigation() {
      makeItemNavigation()
    }

}