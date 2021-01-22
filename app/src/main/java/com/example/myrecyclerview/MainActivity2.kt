package com.example.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity2 : AppCompatActivity(){
    private val grid = ArrayList<Hero.Heroes>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        rv_heroes.setHasFixedSize(true)

        grid.addAll(getGridHeroes())
        showRecyclerGrid()
    }
    fun getGridHeroes(): Collection<Hero.Heroes> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val gridHero = ArrayList<Hero.Heroes>()
        for (position in dataName.indices) {
            val hero = Hero.Heroes(
                dataName[position],
                dataDescription[position],
                dataPhoto[position]
            )
            gridHero.add(hero)
        }
        return gridHero
    }

    private fun showRecyclerGrid() {
        rv_heroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(grid)
        rv_heroes.adapter = listHeroAdapter
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
            }
            R.id.action_grid -> {
                showRecyclerGrid()
            }
            R.id.action_cardview -> {
            }
        }
    }
}