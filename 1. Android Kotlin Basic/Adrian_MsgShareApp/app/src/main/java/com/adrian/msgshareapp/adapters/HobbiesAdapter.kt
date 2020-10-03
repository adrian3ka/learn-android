package com.adrian.msgshareapp.adapters

import android.content.ClipDescription
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adrian.msgshareapp.models.Hobby
import com.adrian.msgshareapp.R
import com.adrian.msgshareapp.showToast
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdapter(private val context: Context, private val hobbies: List<Hobby>) :
    RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var currentHobby: Hobby? = null
        private var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                val message = currentHobby!!.title + " Clicked !"

                context.showToast(message)
            }

            itemView.imgShare.setOnClickListener {
                val message: String = "My hobby is: " + currentHobby!!.title

                val intent = Intent()

                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, message)
                intent.type = ClipDescription.MIMETYPE_TEXT_PLAIN

                context.startActivity(Intent.createChooser(intent, "Please select app: "))
            }
        }

        fun setData(hobby: Hobby?, position: Int) {
            hobby?.let {
                itemView.txvTitle.text = hobby.title
            }

            this.currentHobby = hobby
            this.currentPosition = position
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]

        holder.setData(hobby, position)
    }
}