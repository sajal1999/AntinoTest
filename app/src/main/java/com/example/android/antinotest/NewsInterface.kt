package com.example.android.antinotest

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


//https://newsapi.org/v2/everything?q=tesla&from=2021-04-16&sortBy=publishedAt&apiKey=a85320c745eb489bb500dadb02b63704
const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "a85320c745eb489bb500dadb02b63704"
interface NewsInterface {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country") country: String,@Query("page:")page:Int) :Call<News>
}

object NewsService{
    val newsInstance: NewsInterface
    init {
        val retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}