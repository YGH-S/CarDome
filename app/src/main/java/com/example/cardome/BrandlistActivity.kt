package com.example.cardome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.cardome.adapter.BrandlistAdapter
import com.example.cardome.bean.BrandlistBean
import com.example.cardome.bean.LogoBean
import com.example.cardome.databinding.ActivityBrandlistBinding
import com.example.cardome.util.CarApi
import com.example.cardome.util.RetrofitUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BrandlistActivity : AppCompatActivity() {

    val binding:ActivityBrandlistBinding by lazy {
        DataBindingUtil.setContentView(this,R.layout.activity_brandlist)
    }
    val mDatas = mutableListOf<BrandlistBean.ResultBean>()
    val adapter : BrandlistAdapter by lazy {
        BrandlistAdapter(this,mDatas)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bean: LogoBean.ResultBean = intent.getSerializableExtra("bean") as LogoBean.ResultBean
        binding.title = bean.brandName
        binding.adapter = adapter
        loadDatas(bean.id)
    }

    private fun loadDatas(id: String?) {
        val api = RetrofitUtil.getApi(CarApi.base_url, CarApi::class.java)
        val call : Call<BrandlistBean>? = api.getBrandList(CarApi.key,id ?: "1")
        call?.enqueue(object :Callback<BrandlistBean>{
            override fun onResponse(call: Call<BrandlistBean>, response: Response<BrandlistBean>) {
                val bean:BrandlistBean? = response.body()
                adapter.addDatas(bean?.getResult())
            }

            override fun onFailure(call: Call<BrandlistBean>, t: Throwable) {

            }

        })
    }
}