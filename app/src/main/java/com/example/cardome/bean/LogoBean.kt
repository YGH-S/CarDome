package com.example.cardome.bean

import com.google.gson.annotations.SerializedName

class LogoBean : java.io.Serializable{
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

    class ResultBean : java.io.Serializable{
        @SerializedName("id")
        var id: String? = null

        @SerializedName("first_letter")
        var firstLetter: String? = null

        @SerializedName("brand_name")
        var brandName: String? = null

        @SerializedName("brand_logo")
        var brandLogo: String? = null
    }
}