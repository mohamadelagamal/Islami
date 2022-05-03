package islami.ui.quran.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.islami.R
import islami.model.Constants

class DetailsActivity : AppCompatActivity() {
    lateinit var suraName:TextView
    lateinit var recyclerView: RecyclerView
    lateinit var adapter : AdapterDetailsActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_quran)
        setSupportActionBar(findViewById(R.id.toolBare))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        suraName=findViewById(R.id.nameSura)
        val suraname:String=  intent.getStringExtra(Constants.EXTRA_SURA_NAME) as String
        val suraPosation:Int=  intent.getIntExtra(Constants.EXTRA_SURA_POSTION,-1)
        suraName.setText(suraname)
        iniRecyleView()
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)

        /*
                 readSuraFile((suraPosation+1)+".text")

              val suraname:String=  intent.getStringExtra(Constants.EXTRA_SuRA_NAME)!!
         */
        readSuraFile("${suraPosation+1}.txt")
    }
    private fun readSuraFile(fileName:String) {
        val fileContent:String=
            assets.open(fileName).bufferedReader().use{it.readText()}
        val verses:List<String> = fileContent.lines()
        adapter.changeData(verses)
    }

    private fun iniRecyleView() {
        recyclerView=findViewById(R.id.recycleDetails)
        adapter= AdapterDetailsActivity()
        recyclerView.adapter=adapter
    }


}