package com.example.kotlin8last

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin8last.databinding.ItemNameBinding

class RecyclerAdapter(onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(), View.OnClickListener {

    private var list: MutableList<RecyclerModel>? = null
    private val onItemClickListener: OnItemClickListener

    fun setData(listCelebrity: MutableList<RecyclerModel>?) {
        this.list = listCelebrity
        notifyDataSetChanged()
    }

    fun setData2(model: RecyclerModel) {
       list?.add(model)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener(this)
        holder.onBind(list!![position])
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    init {
        this.onItemClickListener = onItemClickListener
    }

    override fun onClick(view: View) {
        onItemClickListener.onClick(view.tag as RecyclerModel)
    }

    class ViewHolder(private val binding: ItemNameBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(celebrities: RecyclerModel) {
            Glide.with(binding.ivImage.context).load(celebrities.imageUrl).into(binding.ivImage)
            binding.tvName.text = celebrities.name
            binding.tvAge.text = celebrities.age.toString()
            binding.tvFamily.text = celebrities.family
            itemView.tag = celebrities
        }
    }
}