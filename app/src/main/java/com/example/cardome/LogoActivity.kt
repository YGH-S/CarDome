package com.example.cardome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.View.OnClickListener
import androidx.databinding.DataBindingUtil
import com.example.cardome.adapter.LogoAdapter
import com.example.cardome.bean.LogoBean
import com.example.cardome.databinding.ActivityLogoBinding
import com.example.cardome.util.CarApi
import com.example.cardome.util.RetrofitUtil
import retrofit2.Call
import retrofit2.Response

class LogoActivity : AppCompatActivity() {

    val binding: ActivityLogoBinding by lazy {
        DataBindingUtil.setContentView(this,R.layout.activity_logo)
    }
    val mDatas = mutableListOf<LogoBean.ResultBean>()
    val adapter:LogoAdapter by lazy {
        LogoAdapter(this,mDatas)
    }

    var letter_msg = "当前品牌首字母："
    var letter = "A"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.adapter = adapter
        binding.name = letter_msg + letter

        loadDatas(letter)

        binding.logoBtn.setOnClickListener(object :OnClickListener{
            override fun onClick(v: View?) {
                val lt = binding.logoEt.text.toString().trim().uppercase()
                if (!TextUtils.isEmpty(lt) && !lt.equals(letter)) {
                    letter = lt
                    binding.name = letter_msg + letter
                    loadDatas(letter)

                }
            }
        })
    }

    private fun loadDatas(letter: String) {
        val api = RetrofitUtil.getApi(CarApi.base_url, CarApi::class.java)
        val call = api.getCarLogo(CarApi.key, letter)
        call?.enqueue(object : retrofit2.Callback<LogoBean>{
            override fun onResponse(call: Call<LogoBean>, response: Response<LogoBean>) {
                val bean: LogoBean? = response.body()
                mDatas.clear()
                adapter.addDatas(bean?.getResult())
            }

            override fun onFailure(call: Call<LogoBean>, t: Throwable) {

            }

        })
    }
}