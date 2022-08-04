package com.example.sports_summary.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.item_season_info.view.*
import java.lang.reflect.Array.set
import com.example.sports_summary.R
//import com.example.sports_summary.model.Data
import com.example.sports_summary.Cell
import com.squareup.picasso.Picasso


class SeasonInfoAdapter (private val cell: ArrayList<Cell> ) : RecyclerView.Adapter<SeasonInfoAdapter.SeasonInfoViewHolder>() {

//    var leagueInfo: List<LeagueInfo> = listOf()
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }

   // var onCoinClickListener: OnCoinClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonInfoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_season_info, parent, false)
        return SeasonInfoViewHolder(view)
    }



    override fun onBindViewHolder(holder: SeasonInfoViewHolder, position: Int) {
        val cell_one = cell[position]
        with(holder) {
            with(cell) {
                //val symbolsTemplate = context.resources.getString(R.string.symbols_template)
              //  val lastUpdateTemplate = context.resources.getString(R.string.last_update_template)
                tvHomeName.text =cell_one.homeName
                tvAwayName.text = cell_one.awayName
                tvSeson.text = cell_one.season
                tvScore.text = "${cell_one.homeGoalCount} : ${cell_one.awayGoalCount}"
                tvStadiumName.text = cell_one.stadiumName


              //  Picasso.get().load(cell_one.homeImage).into(ivLogoHome)
               // Picasso.get().load(cell_one.awayImage).into(ivLogoAway)

//                itemView.setOnClickListener {
//                    onCoinClickListener?.onCoinClick(this,data)
//                }
            }
        }
    }

    inner class SeasonInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvHomeName = itemView.tvHomeName
        val tvAwayName = itemView.tvAwayName
        val tvSeson = itemView.tvSeson
        val tvScore = itemView.tvScore
        val tvStadiumName = itemView.tvStadiumName
        val ivLogoHome = itemView.ivLogoHome
        val ivLogoAway = itemView.ivLogoAway
    }
    override fun getItemCount(): Int {
        return cell.size
    }

//    interface OnCoinClickListener {
//        fun onCoinClick(dataList: MutableList<Data>)
//    }
}