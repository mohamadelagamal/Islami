package islami.ui.hades

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.islami.R

class HadesAdapter(val items: List<String?>?): RecyclerView.Adapter<HadesAdapter.viewHolder>() {

    class viewHolder(view:View): RecyclerView.ViewHolder(view) {
        val name : TextView = view.findViewById(R.id.textHades)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hades_main,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        var hadesName = items?.get(position)
        holder.name.setText(hadesName)

        when {
            onItemClickListener!=null -> {
            holder.itemView.setOnClickListener {
                hadesName?.let { it1 -> onItemClickListener?.onItemClike(position, it1) }
            }
            }
        }
    }

    //... to make onClike .... make interface
    var onItemClickListener :onItemClikLintener?=null
    interface onItemClikLintener {
        fun onItemClike(position: Int,name: String)
    }
    override fun getItemCount(): Int {
       return items?.size ?: 0
    }
}