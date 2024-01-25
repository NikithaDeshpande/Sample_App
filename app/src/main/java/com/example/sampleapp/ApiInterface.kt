package com.example.sampleapp

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {
    @FormUrlEncoded
    @POST("/RegisterApi/Register")
    fun userDetails(
        @Field("key_action") action: String,
        @Field("Key_name") name: String?,
        @Field("Key_email") email: String?,
        @Field("Key_password") password: String?,
        @Field("key_conPassword") confirmPassword: String?,
        @Field("Key_Gender") gender: String?,
        @Field("Key_Place") place: String?,
        @Field("Key_Language") language: String?,
        @Field("Key_date") date: String?,
        @Field("Key_Hour") hour: String?
    ): Call<Void>

    @FormUrlEncoded
    @POST("/LoginApi/Login")
    fun sendData(
        @Field("Key_Email") email: String,
        @Field("Key_Password") password: String
    ): Call<ResponseBody>
}