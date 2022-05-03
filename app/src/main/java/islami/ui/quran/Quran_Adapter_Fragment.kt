package islami.ui.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.islami.R
import com.islami.databinding.ItemQuranMainBinding
import kotlinx.coroutines.NonDisposableHandle
import kotlinx.coroutines.NonDisposableHandle.parent

class Quran_Adapter_Fragment(val itemName:List<String> ,val itemNumber:List<String>):
    RecyclerView.Adapter<Quran_Adapter_Fragment.viewHOlder>() {

    class viewHOlder( itemBinding:View) : RecyclerView.ViewHolder(itemBinding){
        val name:TextView=itemView.findViewById(R.id.textQuran)
        val number:TextView=itemView.findViewById(R.id.numberQuran)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHOlder {
        val view =LayoutInflater.from(parent.context).
        inflate(R.layout.item_quran_main,parent,false)
        return viewHOlder(view)
    }
    var onItemclikListener:onItemClikListener?=null
    interface onItemClikListener{
        fun onItemclike(pos:Int,name:String)
    }
    override fun onBindViewHolder(holder: viewHOlder, position: Int) {
        val suraName=itemName.get(position)
        val numberSura = itemNumber.get(position)
        holder.name.setText(suraName)
        holder.number.setText(numberSura)
        if(onItemclikListener!=null){
            holder.itemView.setOnClickListener{
                onItemclikListener?.onItemclike(position,suraName)
            }
        }
    }

    override fun getItemCount(): Int {
        return itemName.size
    }
}