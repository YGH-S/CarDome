package com.example.cardome.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cardome.R
import com.example.cardome.bean.BrandlistBean
import com.example.cardome.databinding.ItemBrandlistBinding
import com.example.cardome.databinding.ItemLogoBinding

class BrandlistAdapter(var ctx:Context,
                       var mDatas:MutableList<BrandlistBean.ResultBean>)
    : RecyclerView.Adapter<BrandlistAdapter.BrandHolder>() {

    val inflater = LayoutInflater.from(ctx)
    class BrandHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var binding: ItemBrandlistBinding? = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandHolder {
        val binding:ItemBrandlistBinding = DataBindingUtil.inflate(inflater,R.layout.item_brandlist,parent,false)
        val holder = BrandHolder(binding.root)
        holder.binding = binding
        return  holder
    }

    override fun onBindViewHolder(holder: BrandHolder, position: Int) {
        val bean = mDatas.get(position)
        holder.binding?.item = bean
    }

    override fun getItemCount(): Int {
        return mDatas.size
    }

    fun addDatas(list : List<BrandlistBean.ResultBean>?){
        if (list != null){
            mDatas.addAll(list)
            notifyDataSetChanged()
        }
    }

}