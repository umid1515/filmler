package com.example.filmler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.filmler.databinding.CardFilmTasarimBinding

class FilmlerAdapter2 : RecyclerView.Adapter<FilmlerAdapter2.FilmlerHolder>() {

    private val filmlerList = arrayListOf<Filmler>()

    class FilmlerHolder(private val cardFilmTasarimBinding: CardFilmTasarimBinding) :
        RecyclerView.ViewHolder(cardFilmTasarimBinding.root) {
        fun find(film: Filmler) {
            with(cardFilmTasarimBinding) {
                textViewFilmIsim.text = film.film_ad
                textViewFilmFiyat.text = film.film_fiyat.toString()
                imageViewAskimemnu.setImageResource(
                    root.context.resources.getIdentifier(
                        film.film_resim_ad,
                        "drawable", root.context.packageName
                    )
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmlerHolder {
        val layout =
            CardFilmTasarimBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmlerHolder(layout)
    }

    override fun onBindViewHolder(holder: FilmlerHolder, position: Int) {
        val film = filmlerList[position]
        holder.find(film)
    }

    override fun getItemCount(): Int {
        return filmlerList.size
    }

    fun updateList(list:List<Filmler>){
        filmlerList.clear()
        filmlerList.addAll(list)
        notifyDataSetChanged()
    }
}