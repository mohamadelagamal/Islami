package islami.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.islami.R
import islami.ui.hades.Hades_Fragment
import islami.ui.quran.Quran_Fragment
import islami.ui.radio.Radio_Fragment
import islami.ui.sebha.Sebha_Fragment

abstract class BaseActivity < DB : ViewDataBinding , VM : BaseViewModel<*>>: AppCompatActivity() {

    lateinit var item_navigation : BottomNavigationView
    lateinit var viewDataBinding: DB
    lateinit var viewModel  : VM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this,getLayoutID())
        viewModel = makeViewModelProvider()
        item_navigation = findViewById(R.id.Bottom_Navigation)

    }
    abstract fun getLayoutID():Int
    abstract fun makeViewModelProvider():VM
    abstract fun itemNavigation()
    fun makeItemNavigation(){
        item_navigation.setOnItemSelectedListener OnItemSelectedListener@{
            when (it.itemId) {
                R.id.quran -> {
                    pushfragment(Quran_Fragment())
                }
                R.id.hades -> {
                    pushfragment(Hades_Fragment())
                }
                R.id.radio_id -> {
                    pushfragment(Radio_Fragment())
                }
                R.id.sebha_id -> {
                    pushfragment(Sebha_Fragment())
                }
            }
            return@OnItemSelectedListener true
        }
        item_navigation.selectedItemId=R.id.quran
    }
    private fun pushfragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.Quran_Fragment , fragment).commit()
    }

}