package islami.ui.hades.details
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.islami.R
import islami.model.Constants
class DetailsHadesActivity : AppCompatActivity() {
    lateinit var adapter: HadesAdapterContent
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_hades)
        setSupportActionBar(findViewById(R.id.toolBare))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val nameHades :String = intent.getStringExtra(Constants.EXTRA_SURA_NAME) as String
        val position : Int = intent.getIntExtra(Constants.EXTRA_SURA_POSTION,-1)
        val title = findViewById<TextView>(R.id.titleHades)
        title.setText(nameHades)
        initRecycleView()
        readSuraFile("h${position+1}.txt")
    }
    private fun readSuraFile(fileName:String) {
        val fileContent:String=
            assets.open(fileName).bufferedReader().use{it.readText()}
        val verses:List<String> = fileContent.split("\n")
        adapter.changeData(verses)
    }
    private fun initRecycleView() {
        // ....make find View By id
        recyclerView = findViewById(R.id.recycleDetailsHades)
        // set adapter
        adapter = HadesAdapterContent()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }
}