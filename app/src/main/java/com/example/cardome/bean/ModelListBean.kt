package com.example.cardome.bean

import com.google.gson.annotations.SerializedName

class ModelListBean {
    @SerializedName("reason")
    private var reason: String? = null

    @SerializedName("error_code")
    private var errorCode: Int? = null

    @SerializedName("result")
    private var result: List<ResultDTO?>? = null

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

    fun getResult(): List<ResultDTO?>? {
        return result
    }

    fun setResult(result: List<ResultDTO?>?) {
        this.result = result
    }

    class ResultDTO {
        @SerializedName("id")
        var id: String? = null

        @SerializedName("series_id")
        var seriesId: String? = null

        @SerializedName("name")
        var name: String? = null

        @SerializedName("year")
        var year: String? = null

        @SerializedName("peizhi")
        var peizhi: String? = null
    }
}