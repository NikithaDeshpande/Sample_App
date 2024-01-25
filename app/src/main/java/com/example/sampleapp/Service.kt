package com.example.sampleapp

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

@Suppress("SimplifyBooleanWithConstants")
class Service(private val context: Context?) {
    private val gson: Gson = GsonBuilder().setLenient().create()
    private val r = Retrofit.Builder()
        .baseUrl("http://192.168.152.68:8081/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    private val apiInterface = r.create(ApiInterface::class.java)
    fun loginFunction(fragment: Fragment, email: String, password: String) {
        val l = LoadingDialog(fragment)
        val call: Call<ResponseBody> = apiInterface.sendData(email, password)
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    try {
                        val responseBodyString: String? = response.body()?.string()
                        if (responseBodyString != null) {
                            if (responseBodyString.trim()
                                    .equals("Login Successful", ignoreCase = true) == true
                            ) {
                                // Handle successful login
                                Log.d("Response", "Login Successful")
                                l.startLoginDialog(true)
                            } else {
                                // Handle unsuccessful login
                                Log.d("Response", "Login Not Successful: $responseBodyString")
                                l.startLoginDialog(false)
                            }
                        } else {
                            Log.d("Response", "Empty response")
                        }

                    } catch (e: IOException) {
                        Log.e("loginFragment", "Error reading response body: ${e.message}")
                        l.startLoginDialog(false)

                    }
                } else {
                    Log.d("loginFragment", "not is successful")

                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.d("loginFragment", "$t")

            }

        })
    }

    fun registerFunction(
        fragment: Fragment,
        name: String,
        email: String,
        password: String,
        conPassword: String,
        gender: String,
        place: String,
        language: String,
        date: String?,
        hour: String?
    ) {
        val call: Call<Void> = apiInterface.userDetails(
            "Register",
            name,
            email,
            password,
            conPassword,
            gender,
            place,
            language,
            date,
            hour
        )
        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                val l = LoadingDialog(fragment)
                if (response.code() == 200)
                    l.startDialog(true)
                else
                    l.startDialog(false)
                if (response.isSuccessful) {
                    Log.e("MainActivity", "registered  $response")

                } else {
                    Log.e("MainActivity", "not registered Status code:$response")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(context, "On Failure $t", Toast.LENGTH_SHORT).show()
                Log.d("ServiceActivity", "$t")
            }

        })
    }
}