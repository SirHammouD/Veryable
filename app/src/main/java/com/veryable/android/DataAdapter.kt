package com.veryable.android

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(private val list: List<Data>, var context: Context) : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.bank_card_view,parent, false)

        return  DataViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val currentItem = list[position]

        holder.card.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {

                val intent = Intent(context, DetailsActivity::class.java)
                intent.putExtra("name",currentItem.account_name)
                intent.putExtra("desc",currentItem.desc)
                intent.putExtra("type",currentItem.account_type)
                context.startActivity(intent)

            }
        })

        holder.name.text = (currentItem.account_name)
        holder.description.text = (currentItem.desc)

        if (currentItem.account_type.equals("card")){
            holder.img.setBackgroundResource(R.drawable.baseline_credit_card_black_48pt_1x)
            holder.type.text = context.getString(R.string.card)
        }
        else{
            //holder.itemView.isVisible= false
            holder.img.setBackgroundResource(R.drawable.baseline_account_balance_black_48pt_1x)
            holder.type.text = context.getString(R.string.bank)
        }



    }

    override fun getItemCount() = list.size

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val name: TextView = itemView.findViewById(R.id.account_name)
        val description: TextView = itemView.findViewById(R.id.desc)
        val type: TextView = itemView.findViewById(R.id.type)
        val card: CardView = itemView.findViewById(R.id.card)
        val img: ImageView = itemView.findViewById(R.id.img)

    }



}

