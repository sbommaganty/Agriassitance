package com.example.agriassitance

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.card_item.view.*

class dises : Fragment() {
    lateinit var cycler: RecyclerView

    var images: ArrayList<Int> = ArrayList()
    var countries: ArrayList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.activity_dises, container, false)
        cycler = rootView.findViewById(R.id.cycler) as RecyclerView
        loadData()


        cycler.layoutManager = LinearLayoutManager(activity)
        cycler.adapter = CountryAdapter(countries,activity,images)


        return rootView
    }
    companion object{
        var mp: MediaPlayer = MediaPlayer()
    }

    class CountryAdapter(items: List<String>, ctx: FragmentActivity?, img:List<Int>) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {
        var list = items
        var context = ctx
        var jun = img

        private lateinit var mediaPlayer: MediaPlayer
        var srclick:String=""
        val isd:Boolean = true
        val TAG="MainActivity"
        var istrue = true

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

            if (isd == true) {

            }

            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_item, p0, false))

        }

        override fun getItemCount(): Int {

            return list.size

        }

        override fun onBindViewHolder(p0: ViewHolder, position: Int) {

            val mediaPlayer = MediaPlayer()
            p0.name.text = list.get(position)
            Glide.with(p0.itemView.context).load(jun.get(position)).into(p0.rela)
            /* when(p0.adapterPosition){
                 0->{
                     p0.rela.setBackgroundResource(R.drawable.bpnh)
                 }
                 1->{
                     p0.rela.setBackgroundResource(R.drawable.bui)
                 }
                 2->{
                     p0.rela.setBackgroundResource(R.drawable.play)
                 }
                 3->{
                     p0.rela.setBackgroundResource(R.drawable.you)
                 }
                 4->{
                     p0.rela.setBackgroundResource(R.drawable.ojj)
                 }
             }*/

            p0.bu.setOnClickListener {
                if (istrue) {
                    istrue = false

                    mediaPlayer.pause()


                } else {
                    istrue = true
                    mediaPlayer.start()


                }
            }
            //tel
            p0.telugu.setOnClickListener {
                if (position == 0) {
                    if(mediaPlayer.isPlaying)
                    {
                        mediaPlayer.reset()
                        mediaPlayer.stop()
                    }



                    val storage = FirebaseStorage.getInstance()
                    storage.reference.child("TBlackspotDisease.mp3").downloadUrl.addOnSuccessListener({
                        Handler().postDelayed({
                            mediaPlayer.setDataSource(it.toString())
                            mediaPlayer.setOnPreparedListener { player ->
                                player.start()
                            }
                            mediaPlayer.prepareAsync()
                        },2000)

                    })
                    //  mediaPlayer = MediaPlayer.create(context,R.raw.onr)
                    //   mediaPlayer.start()
                    //https://www.javatpoint.com/kotlin-android-media-player
                }
                if (position == 1) {
                    if(mediaPlayer.isPlaying)
                    {
                        mediaPlayer.reset()
                        mediaPlayer.stop()
                    }



                    val storage = FirebaseStorage.getInstance()
                    storage.reference.child("TBotrytisBlight.mp3").downloadUrl.addOnSuccessListener({
                        Handler().postDelayed({
                            mediaPlayer.setDataSource(it.toString())
                            mediaPlayer.setOnPreparedListener { player ->
                                player.start()
                            }
                            mediaPlayer.prepareAsync()
                        },2000)

                    })
                }
                if (position == 2) {
                    if(mediaPlayer.isPlaying)
                    {
                        mediaPlayer.reset()
                        mediaPlayer.stop()
                    }


                    val storage = FirebaseStorage.getInstance()
                    storage.reference.child("Tleafspot.mp3").downloadUrl.addOnSuccessListener({
                        Handler().postDelayed({
                            mediaPlayer.setDataSource(it.toString())
                            mediaPlayer.setOnPreparedListener { player ->
                                player.start()
                            }
                            mediaPlayer.prepareAsync()
                        },2000)

                    })
                }
                if (position == 3) {
                    if(mediaPlayer.isPlaying)
                    {
                        mediaPlayer.reset()
                        mediaPlayer.stop()
                    }


                    val storage = FirebaseStorage.getInstance()
                    storage.reference.child("TPowderMildew.mp3").downloadUrl.addOnSuccessListener({
                        Handler().postDelayed({
                            mediaPlayer.setDataSource(it.toString())
                            mediaPlayer.setOnPreparedListener { player ->
                                player.start()
                            }
                            mediaPlayer.prepareAsync()
                        },2000)

                    })
                }
                if(position == 4){
                    if(mediaPlayer.isPlaying)
                    {
                        mediaPlayer.reset()
                        mediaPlayer.stop()
                    }


                    val storage = FirebaseStorage.getInstance()
                    storage.reference.child("TRust.mp3").downloadUrl.addOnSuccessListener({
                        Handler().postDelayed({
                            mediaPlayer.setDataSource(it.toString())
                            mediaPlayer.setOnPreparedListener { player ->
                                player.start()
                            }
                            mediaPlayer.prepareAsync()
                        },2000)

                    })
                }

                if(position == 5){
                    if(mediaPlayer.isPlaying)
                    {
                        mediaPlayer.reset()
                        mediaPlayer.stop()
                    }


                    val storage = FirebaseStorage.getInstance()
                    storage.reference.child("gtt.mpeg").downloadUrl.addOnSuccessListener({
                        Handler().postDelayed({
                            mediaPlayer.setDataSource(it.toString())
                            mediaPlayer.setOnPreparedListener { player ->
                                player.start()
                            }
                            mediaPlayer.prepareAsync()
                        },2000)

                    })
                }
            }
            //tell
            //hindi
            p0.hindi.setOnClickListener {
                if (position == 0) {
                    if(mediaPlayer.isPlaying)
                    {
                        mediaPlayer.reset()
                        mediaPlayer.stop()

                    }



                    val storage = FirebaseStorage.getInstance()
                    storage.reference.child("HBlackspotDisease.mp3").downloadUrl.addOnSuccessListener({
                        Handler().postDelayed(Runnable {
                            mediaPlayer.setDataSource(it.toString())
                            mediaPlayer.setOnPreparedListener { player ->
                                player.start()
                            }
                            mediaPlayer.prepareAsync()
                        }, 2000)

                    })
                }
                if (position == 1) {
                    if(mediaPlayer.isPlaying)
                    {
                        mediaPlayer.reset()
                        mediaPlayer.stop()
                    }


                    val storage = FirebaseStorage.getInstance()
                    storage.reference.child("HBotrytisBlight.mp3").downloadUrl.addOnSuccessListener({
                        Handler().postDelayed({
                            mediaPlayer.setDataSource(it.toString())
                            mediaPlayer.setOnPreparedListener { player ->
                                player.start()
                            }
                            mediaPlayer.prepareAsync()
                        },2000)

                    })
                }
                if (position == 2) {
                    if(mediaPlayer.isPlaying)
                    {
                        mediaPlayer.reset()
                        mediaPlayer.stop()
                    }


                    val storage = FirebaseStorage.getInstance()
                    storage.reference.child("Hleafspot.mp3").downloadUrl.addOnSuccessListener({
                        Handler().postDelayed({
                            mediaPlayer.setDataSource(it.toString())
                            mediaPlayer.setOnPreparedListener { player ->
                                player.start()
                            }
                            mediaPlayer.prepareAsync()
                        },2000)

                    })
                }
                if(position == 3){
                    if(mediaPlayer.isPlaying)
                    {
                        mediaPlayer.reset()
                        mediaPlayer.stop()
                    }


                    val storage = FirebaseStorage.getInstance()
                    storage.reference.child("HPowderMildew.mp3").downloadUrl.addOnSuccessListener({
                        Handler().postDelayed({
                            mediaPlayer.setDataSource(it.toString())
                            mediaPlayer.setOnPreparedListener { player ->
                                player.start()
                            }
                            mediaPlayer.prepareAsync()
                        },2000)

                    })
                }
                if(position == 4){
                    if(mediaPlayer.isPlaying)
                    {
                        mediaPlayer.reset()
                        mediaPlayer.stop()
                    }


                    val storage = FirebaseStorage.getInstance()
                    storage.reference.child("HRust.mp3").downloadUrl.addOnSuccessListener({
                        Handler().postDelayed({
                            mediaPlayer.setDataSource(it.toString())
                            mediaPlayer.setOnPreparedListener { player ->
                                player.start()
                            }
                            mediaPlayer.prepareAsync()
                        },2000)

                    })
                }
                if(position == 5){
                    if(mediaPlayer.isPlaying)
                    {
                        mediaPlayer.reset()
                        mediaPlayer.stop()
                    }


                    val storage = FirebaseStorage.getInstance()
                    storage.reference.child("gttt.mpeg").downloadUrl.addOnSuccessListener({
                        Handler().postDelayed({
                            mediaPlayer.setDataSource(it.toString())
                            mediaPlayer.setOnPreparedListener { player ->
                                player.start()
                            }
                            mediaPlayer.prepareAsync()
                        },2000)

                    })
                }

            }
            //hindi
            //eng
            p0.su.setOnClickListener {
                if (position == 0) {
                    if(mediaPlayer.isPlaying)
                    {
                        mediaPlayer.reset()
                        mediaPlayer.stop()

                    }


                    val storage = FirebaseStorage.getInstance()
                    storage.reference.child("EBlackspotDisease.mp3").downloadUrl.addOnSuccessListener({
                        Handler().postDelayed({
                            mediaPlayer.setDataSource(it.toString())
                            mediaPlayer.setOnPreparedListener { player ->
                                player.start()
                            }
                            mediaPlayer.prepareAsync()
                        },2000)

                    })



                    //  mediaPlayer = MediaPlayer.create(context,R.raw.onr)
                    //   mediaPlayer.start()
                    //https://www.javatpoint.com/kotlin-android-media-player
                }
                if (position == 1) {
                    if(mediaPlayer.isPlaying)
                    {   mediaPlayer.reset()
                        mediaPlayer.stop()

                    }


                    val storage = FirebaseStorage.getInstance()
                    storage.reference.child("EBotrytisBlight.mp3").downloadUrl.addOnSuccessListener({

                        Handler().postDelayed({
                            mediaPlayer.setDataSource(it.toString())
                            mediaPlayer.setOnPreparedListener { player ->
                                player.start()
                            }
                            mediaPlayer.prepareAsync()
                        },2000)

                    })
                }
                if (position == 2) {
                    if(mediaPlayer.isPlaying)
                    {
                        mediaPlayer.reset()
                        mediaPlayer.stop()

                    }

                    val storage = FirebaseStorage.getInstance()
                    storage.reference.child("Eleafspot.mp3").downloadUrl.addOnSuccessListener({

                        Handler().postDelayed({
                            mediaPlayer.setDataSource(it.toString())
                            mediaPlayer.setOnPreparedListener { player ->
                                player.start()
                            }
                            mediaPlayer.prepareAsync()
                        },2000)

                    })
                }
                if (position == 3) {
                    if(mediaPlayer.isPlaying)
                    {
                        mediaPlayer.reset()
                        mediaPlayer.stop()
                    }


                    val storage = FirebaseStorage.getInstance()
                    storage.reference.child("EPowderMildew.mp3").downloadUrl.addOnSuccessListener({
                        Handler().postDelayed({
                            mediaPlayer.setDataSource(it.toString())
                            mediaPlayer.setOnPreparedListener { player ->
                                player.start()
                            }
                            mediaPlayer.prepareAsync()
                        },2000)

                    })
                }
                if(position == 4){
                    if(mediaPlayer.isPlaying)
                    {
                        mediaPlayer.reset()
                        mediaPlayer.stop()
                    }


                    val storage = FirebaseStorage.getInstance()
                    storage.reference.child("ERust.mp3").downloadUrl.addOnSuccessListener({
                        Handler().postDelayed({
                            mediaPlayer.setDataSource(it.toString())
                            mediaPlayer.setOnPreparedListener { player ->
                                player.start()
                            }
                            mediaPlayer.prepareAsync()
                        },2000)

                    })
                }
                if(position == 5){
                    if(mediaPlayer.isPlaying)
                    {
                        mediaPlayer.reset()
                        mediaPlayer.stop()
                    }


                    val storage = FirebaseStorage.getInstance()
                    storage.reference.child("gtt.mpeg").downloadUrl.addOnSuccessListener({
                        Handler().postDelayed({
                            mediaPlayer.setDataSource(it.toString())
                            mediaPlayer.setOnPreparedListener { player ->
                                player.start()
                            }
                            mediaPlayer.prepareAsync()
                        },2000)

                    })
                }
            }
            //eng
            p0.itemView.setOnClickListener {

                when(p0.adapterPosition)
                {
                    0->{


                        val intent = Intent(p0.itemView.context,Scro::class.java)
                        intent.putExtra("k",context?.getString(R.string.BlackSpot))
                        p0.itemView.context.startActivity(intent)
                    }
                    1->{
                        val intent = Intent(p0.itemView.context,Scro::class.java)
                        intent.putExtra("k",context?.getString(R.string.Botrytisblight))
                        p0.itemView.context.startActivity(intent)
                    }
                    2->{
                        val intent = Intent(p0.itemView.context,Scro::class.java)
                        intent.putExtra("k",context?.getString(R.string.LeafSpot))
                        p0.itemView.context.startActivity(intent)
                    }
                    3->{
                        val intent = Intent(p0.itemView.context,Scro::class.java)
                        intent.putExtra("k",context?.getString(R.string.PowderyMildew))
                        p0.itemView.context.startActivity(intent)
                    }
                    4->{
                        val intent = Intent(p0.itemView.context,Scro::class.java)
                        intent.putExtra("k",context?.getString(R.string.Rust))
                        p0.itemView.context.startActivity(intent)
                    }
                    5->{
                        val intent = Intent(p0.itemView.context,Scro::class.java)
                        intent.putExtra("k",context?.getString(R.string.Germs))
                        p0.itemView.context.startActivity(intent)
                    }
                }




            }
            p0.you.setOnClickListener {
                when(p0.adapterPosition){
                    0->{
                        val webIntent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.youtube.com/watch?v=tsWPyH74rLM")
                        )
                        p0.itemView.context.startActivity(webIntent)
                    }
                    1->{
                        val webIntent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(" https://www.youtube.com/watch?v=zkAPwu3tJPk")
                        )
                        p0.itemView.context.startActivity(webIntent)
                    }
                    2->{
                        val webIntent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.youtube.com/watch?v=AE7VgG5db0s" )
                        )
                        p0.itemView.context.startActivity(webIntent)
                    }
                    3->{
                        val webIntent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.youtube.com/watch?v=UVMS-4h5rPk")
                        )
                        p0.itemView.context.startActivity(webIntent)
                    }
                    4->{
                        val webIntent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse( "https://www.youtube.com/watch?v=AKY_pelBZek")
                        )
                        p0.itemView.context.startActivity(webIntent)
                    }
                    5->{
                        val webIntent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse( "https://www.youtube.com/watch?v=-dhdUoK7s2s")
                        )
                        p0.itemView.context.startActivity(webIntent)
                    }
                }
            }

        }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {



            val name = itemView.txtTitle
            val rela = itemView.findViewById<ImageView>(R.id.thumbnail)
            var bu = itemView.findViewById<Button>(R.id.play)
            var you = itemView.findViewById<Button>(R.id.you)

            var su = itemView.findViewById<Button>(R.id.english)
            var telugu = itemView.findViewById<Button>(R.id.telugu)
            var hindi = itemView.findViewById<Button>(R.id.hindi)


        }


    }


    fun loadData() {
        countries.add("Black spot")
        countries.add("Botrytis blight")
        countries.add("Leaf Spot")
        countries.add("Powdery Mildew")
        countries.add("Rust")
        countries.add("Germs")
        images.add(R.drawable.poi)
        images.add(R.drawable.poie)
        images.add(R.drawable.led)
        images.add(R.drawable.lok)
        images.add(R.drawable.images)
        images.add(R.drawable.images)

    }

}
