package islami.ui.radio

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.islami.R
import islami.model.ApiManager
import islami.model.RadiosItem
import islami.model.Response
import retrofit2.Call
import retrofit2.Callback

class Radio_Fragment : Fragment() {
    lateinit var channelName:TextView
    lateinit var playButton: ImageView
    lateinit var rightButton: ImageView
    lateinit var leftButton:ImageView
    lateinit var mediaPlayer: MediaPlayer
    lateinit var progress:ProgressBar
        // you can use pogo to  findView
    //.. sorting data from api in array list
    lateinit var itemList:ArrayList<RadiosItem>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_radio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        //...get data from api
        getDataApi()
    }

    private fun getDataApi() {
        //... get instance about retrofit to get interface
        ApiManager.getApi().getRadiosDataFromApi().enqueue(object :Callback<Response>{
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                Log.e("onResponse",response.body().toString())
                //... use cast
                itemList = response.body()?.radios as ArrayList<RadiosItem>
                channelName.setText(itemList.get(0).name)
                //..to use audio and use media player
            }

            override fun onFailure(call: Call<Response>,exception: Throwable) {
                Log.e("onFailure",exception.message.toString())
                Toast.makeText(requireContext(),"sorry,check access internet",Toast.LENGTH_LONG).show()
            }

        })
    }
    private fun playSound(counter: Int) {
        val url = itemList.get(counter).uRL // your URL here
         mediaPlayer = MediaPlayer().apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            setDataSource(url)
            // in main thread take time you should use progress par
            prepareAsync() // might take long! (for buffering, etc)
        }
        mediaPlayer.setOnPreparedListener {
            progress.isVisible = false
            mediaPlayer.start()
        }
    }
    var position =0
    private fun initView() {
        channelName = requireActivity().findViewById(R.id.channel_Name)
        playButton = requireActivity().findViewById(R.id.playButton)
        rightButton = requireActivity().findViewById(R.id.forwardButton)
        leftButton = requireActivity().findViewById(R.id.previous)
        progress = requireActivity().findViewById(R.id.progress_circular)
        var isPlaying :Boolean ?= false

        playButton.setOnClickListener {

            when (isPlaying){
                false->{
                    isPlaying == true
                    Log.e("isplaying is false",isPlaying.toString())
                    playButton.setImageResource(R.drawable.puse)
                    playSound(position)
                }
                true->{
                    Log.e("isplaying is ","true")
                    isPlaying=false
                    //..stop media player
                    playButton.setImageResource(R.drawable.icon_play)
                    mediaPlayer.stop()
                }
            }
        }

        rightButton .setOnClickListener {
            position++
            if (mediaPlayer.isPlaying){
                mediaPlayer.stop()
            }
            channelName.setText(itemList.get(position).name)
            playSound(position)
        }
        leftButton .setOnClickListener {
            if (mediaPlayer.isPlaying){
                mediaPlayer.stop()
            }
            channelName.setText(itemList.get(position).name)
            if (position>0){
                position--
                playSound(position)
            }
        }


    }
    fun onClick() {
        if (view?.id == R.id.playButton) {
            if (mediaPlayer.isPlaying()) {
                // is playing
                mediaPlayer.pause()
                playButton.setBackgroundResource(R.drawable.icon_play)
            } else {
                // on pause
                mediaPlayer.start()
                playButton.setBackgroundResource(R.drawable.puse)
            }
        }
    }
}