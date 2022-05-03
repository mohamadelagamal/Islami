package islami.ui.sebha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.islami.R

class Sebha_Fragment : Fragment() {

    lateinit var textCounter:TextView
    lateinit var buttonSebha:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sebha_, container, false)
    }
    lateinit var imageViewSebha : ImageView
    lateinit var animation : Animation
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textCounter = requireActivity().findViewById(R.id.sebha_counter)
        buttonSebha = requireActivity().findViewById(R.id.sebha_text)
        imageViewSebha = requireActivity().findViewById(R.id.body_OF_sebha)
        var item  =1

        buttonSebha.setOnClickListener {
            animation = AnimationUtils.loadAnimation(context,R.anim.rotate_animation)
            imageViewSebha.startAnimation(animation)
            when (item) {
                33 -> {
                item=0
                    buttonSebha.setText("الحمد لله")
                }

            }
            textCounter.setText("${item}")
            item++
    }

     fun itemsSum() {
         var counter : Int =1
        for (i in counter until 33 step  1 ){
            textCounter.setText("${counter}")
            counter+1
        }
     }



}}