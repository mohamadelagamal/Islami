package islami.ui.hades.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.islami.R

class HadesAdapterContent : RecyclerView.Adapter<HadesAdapterContent.viewHolder>() {

    var items:List<String> ?=null

    class viewHolder(view:View):RecyclerView.ViewHolder(view){
        // .... make findView
        val title : TextView= view.findViewById(R.id.contentHades)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hades,parent,false)
        return viewHolder(view)
    }
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
    holder.title.setText(items?.get(position))   }
    fun changeData(verses: List<String>){
        this.items = verses
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
       return items?.size ?:0
    }
}