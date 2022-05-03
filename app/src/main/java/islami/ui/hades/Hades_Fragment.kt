package islami.ui.hades

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.islami.R
import islami.model.Constants
import islami.ui.hades.details.DetailsHadesActivity
import java.util.*
import kotlin.collections.ArrayList

class Hades_Fragment  : Fragment(){
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: HadesAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hades, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showHadesItems()
    }
    val chapernamber= listOf<String>(
        "الحديث رقم 1",
        "الحديث رقم 2",
        "الحديث رقم 3",
        "الحديث رقم 4",
        "الحديث رقم 5",
        "الحديث رقم 6",
        "الحديث رقم 7",
        "الحديث رقم 8",
        "الحديث رقم 9",
        "الحديث رقم 10",
        "الحديث رقم 11",
        "الحديث رقم 12",
        "الحديث رقم 13",
        "الحديث رقم 14",
        "الحديث رقم 15",
        "الحديث رقم 16",
        "الحديث رقم 17",
        "الحديث رقم 18",
        "الحديث رقم 19",
        "الحديث رقم 20",
        "الحديث رقم 21",
        "الحديث رقم 22",
        "الحديث رقم 23",
        "الحديث رقم 24",
        "الحديث رقم 25",
        "الحديث رقم 26",
        "الحديث رقم 27",
        "الحديث رقم 28",
        "الحديث رقم 29",
        "الحديث رقم 30",
        "الحديث رقم 31",
        "الحديث رقم 32",
        "الحديث رقم 33",
        "الحديث رقم 34",
        "الحديث رقم 35",
        "الحديث رقم 36",
        "الحديث رقم 37",
        "الحديث رقم 38",
        "الحديث رقم 39",
        "الحديث رقم 40",
        "الحديث رقم 41",
        "الحديث رقم 42",
        "الحديث رقم 43",
        "الحديث رقم 44",
        "الحديث رقم 45",
        "الحديث رقم 46",
        "الحديث رقم 47",
        "الحديث رقم 48",
        "الحديث رقم 49",
        "الحديث رقم 50",

    )
    private fun showHadesItems() {
       // make findviewById about recycleView
        recyclerView = requireActivity().findViewById(R.id.recyle_view_Hades)
        //... set data in adapter and take object
        adapter = HadesAdapter(chapernamber)
        adapter.onItemClickListener = object :HadesAdapter.onItemClikLintener{
            override fun onItemClike(position: Int, name: String) {
                intentHadesDetails(position,name)
            }

        }
        // ... set adapter in recycleView
        recyclerView.adapter=adapter
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL ,false)
    }

    private fun intentHadesDetails(position: Int, name: String) {
    val intent = Intent(requireContext(),DetailsHadesActivity::class.java)
        intent.putExtra(Constants.EXTRA_SURA_NAME,name)
        intent.putExtra(Constants.EXTRA_SURA_POSTION,position)
        startActivity(intent)
    }
}