package com.example.filmler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class FilmlerAdapter(private val mContext: Context, private val filmller_listesi: List<Filmler>) :
    RecyclerView.Adapter<FilmlerAdapter.FilmCardHolder>() {

    class FilmCardHolder(view: View) : RecyclerView.ViewHolder(view) {

        var imageView_askimemnu: ImageView
        var textView_film_isim: TextView
        var textView_film_fiyat: TextView
        var button_sepete_ekle: Button

        init {
            imageView_askimemnu = view.findViewById(R.id.imageView_askimemnu)
            textView_film_isim = view.findViewById(R.id.textView_film_isim)
            textView_film_fiyat = view.findViewById(R.id.textView_film_fiyat)
            button_sepete_ekle = view.findViewById(R.id.button_sepete_ekle)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmCardHolder {
        val tasarim =
            LayoutInflater.from(mContext).inflate(R.layout.card_film_tasarim, parent, false)
        return FilmCardHolder(tasarim)
    }

    override fun onBindViewHolder(holder: FilmCardHolder, position: Int) {
        val film = filmller_listesi[position]
        holder.textView_film_isim.text = film.film_ad
        holder.textView_film_fiyat.text = "${film.film_fiyat} TL"

        holder.imageView_askimemnu.setImageResource(
            mContext.resources.getIdentifier(
                film.film_resim_ad,
                "drawable",mContext.packageName
            )
        )


        holder.button_sepete_ekle.setOnClickListener {
            Toast.makeText(mContext,"${film.film_ad} sepete eklendi",Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return filmller_listesi.size
    }
}