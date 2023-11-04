package com.example.cardome.bean

import com.google.gson.annotations.SerializedName

class BrandlistBean {
    @SerializedName("reason")
    private var reason: String? = null

    @SerializedName("error_code")
    private var errorCode: Int? = null

    @SerializedName("result")
    private var result: List<ResultBean>? = null

    fun getReason(): String? {
        return reason
    }

    fun setReason(reason: String?) {
        this.reason = reason
    }

    fun getErrorCode(): Int? {
        return errorCode
    }

    fun setErrorCode(errorCode: Int?) {
        this.errorCode = errorCode
    }

    fun getResult(): List<ResultBean>? {
        return result
    }

    fun setResult(result: List<ResultBean>?) {
        this.result = result
    }

    class ResultBean {
        @SerializedName("id")
        var id: String? = null

        @SerializedName("name")
        var name: String? = null

        @SerializedName("brandid")
        var brandid: String? = null

        @SerializedName("levelid")
        var levelid: String? = null

        @SerializedName("levelname")
        var levelname: String? = null

        @SerializedName("sname")
        var sname: String? = null
    }
}