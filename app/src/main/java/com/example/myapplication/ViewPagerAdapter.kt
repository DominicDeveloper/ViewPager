package com.example.myapplication

import android.content.Context
import android.icu.text.CaseMap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import me.relex.circleindicator.CircleIndicator3
import org.w3c.dom.Text

class ViewPagerAdapter(private var skip:List<String>,private var theme:List<String>,private var about:List<String>) : RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemSkip: TextView=itemView.findViewById(R.id.text_skip)
        val itemTheme: TextView=itemView.findViewById(R.id.text_theme)
        val itemAbout: TextView=itemView.findViewById(R.id.text_About)
        val itemBack: View = itemView.findViewById(R.id.bacRelativasos)
        val itemCard:View = itemView.findViewById(R.id.clickSkip)


        init {
            itemAbout.setOnClickListener { v: View ->
                val position=adapterPosition
                Toast.makeText(
                    itemView.context,
                    "You cliced on item #${position + 1}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.itme_pager, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return theme.size
    }


    override fun onBindViewHolder(holder: ViewPagerAdapter.Pager2ViewHolder, position: Int) {
    holder.itemSkip.text = skip[position]
    holder.itemTheme.text = theme[position]
        holder.itemCard.setOnClickListener {
            holder.itemBack.setBackgroundResource(R.drawable.earphone)
            holder.itemTheme.text = theme.last()
            holder.itemAbout.text = about.last()


        }
        holder.itemAbout.text = about[position]
        when(theme[position]){
            "Xush kelibsiz" -> holder.itemBack.setBackgroundResource(R.drawable.earphone)
            "Hikoyalar dunyosi" -> holder.itemBack.setBackgroundResource(R.drawable.earphones_2)
            "Kitob ortidan..." -> holder.itemBack.setBackgroundResource(R.drawable.earphones_3)

        }

    }


}
