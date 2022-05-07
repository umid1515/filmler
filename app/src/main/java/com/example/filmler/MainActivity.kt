package com.example.filmler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var filmlerArrayList: ArrayList<Filmler>
    private lateinit var adapter: FilmlerAdapter
    private val adapterYeni:FilmlerAdapter2= FilmlerAdapter2()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        val f1 = Filmler(1, "Aşkı Memnu", "askimemnu", 14.90)
        val f2 = Filmler(2, "Eşkiya Dünyaya Hükmdar Olmaz", "edho", 54.90)
        val f3 = Filmler(3, "Ezhel", "ezhel", 144.90)
        val f4 = Filmler(4, "Kurtlar Vadisi", "kv", 34.90)
        val f5 = Filmler(5, "Paramparça", "paramparca", 84.90)
        val f6 = Filmler(6, "Yaprak Dokumu", "yaprakdokumu", 24.90)

        filmlerArrayList = ArrayList<Filmler>()
        filmlerArrayList.add(f1)
        filmlerArrayList.add(f2)
        filmlerArrayList.add(f3)
        filmlerArrayList.add(f4)
        filmlerArrayList.add(f5)
        filmlerArrayList.add(f6)


        /*adapter = FilmlerAdapter(this, filmlerArrayList)
        binding.rv.adapter = adapter*/

        adapterYeni.updateList(filmlerArrayList)
        binding.rv.adapter=adapterYeni
    }
}