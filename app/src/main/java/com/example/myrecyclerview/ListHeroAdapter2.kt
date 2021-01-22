package com.example.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_row_hero.view.*

class ListHeroAdapter2(private val listHero: ArrayList<Hero.Heroes>) : RecyclerView.Adapter<ListHeroAdapter2.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListHeroAdapter2.ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_grid_hero, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListHeroAdapter2.ListViewHolder, position: Int) {
        holder.bind(listHero[position])
    }

    override fun getItemCount(): Int = listHero.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(hero: Hero.Heroes) {
            with(itemView){
                Glide.with(itemView.context)
                    .load(hero.photo)
                    .apply(RequestOptions().override(55, 55))
                    .into(img_item_photo)
                tv_item_name.text = hero.name
                tv_item_description.text = hero.description
            }
        }
    }
}