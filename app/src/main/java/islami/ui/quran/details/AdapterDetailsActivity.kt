package islami.ui.quran.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.islami.R

class AdapterDetailsActivity : RecyclerView.Adapter<AdapterDetailsActivity.viewHolder>() {
    var items: List<String>?=null
    class viewHolder(view:View): RecyclerView.ViewHolder(view){
        val content : TextView = view.findViewById(R.id.contentDetils)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sura_details,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
    holder.content.setText(items?.get(position))    }

    fun changeData(verses:List<String>){
        this.items =verses
        //.... to make reload
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
     return items?.size ?: 0
    }
}