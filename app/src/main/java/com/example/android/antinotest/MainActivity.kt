package com.example.android.antinotest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    lateinit var adapter:NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
    }

    private fun getNews() {
        val news = NewsService.newsInstance.getHeadlines("in",1)
        news.enqueue(object :retrofit2.Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if(news!=null){
                    Log.d("CheezyCode",news.toString())
                    adapter = NewsAdapter(this@MainActivity,news.articles)
                    rvList.adapter = adapter
                    rvList.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("CHEEZYCODE","Error in fetching News",t)
            }
        })
    }
}