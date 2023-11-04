package com.example.cardome.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cardome.BrandlistActivity
import com.example.cardome.R
import com.example.cardome.bean.BrandlistBean
import com.example.cardome.bean.LogoBean
import com.example.cardome.bean.LogoBean.ResultBean
import com.example.cardome.databinding.ItemLogoBinding

class LogoAdapter(
    var ctx:Context,
    var mDatas: MutableList<ResultBean>
) : RecyclerView.Adapter<LogoAdapter.LogoHolder>(){

    val inflater = LayoutInflater.from(ctx)

    class LogoHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        var binding:ItemLogoBinding? = null
    }

    fun addDatas(list: List<ResultBean>?){
        if (list != null) {
            mDatas.addAll(list)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogoHolder {
        val binding:ItemLogoBinding = DataBindingUtil
            .inflate(inflater, R.layout.item_logo,parent,false)
        val holder = LogoHolder(binding.root)
        holder.binding = binding
        return holder
    }

    override fun onBindViewHolder(holder: LogoHolder, position: Int) {
        val bean = mDatas.get(position)
        holder.binding?.item = bean

        holder.binding?.root?.setOnClickListener(object : OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(ctx, BrandlistActivity::class.java)
                intent.putExtra("bean",bean)
                ctx.startActivity(intent)
            }

        })
    }

    override fun getItemCount(): Int {
        return mDatas.size
    }
}
