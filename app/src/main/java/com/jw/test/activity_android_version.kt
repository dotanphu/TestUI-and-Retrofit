package com.jw.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.jw.test.adapter.AndroidVersionAdapter
import com.jw.test.databinding.ActivityAndroidVersionBinding
import com.jw.test.model.AndroidVersion
import com.jw.test.network.AndroidVersionClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class activity_android_version : AppCompatActivity() {
    private val android = arrayListOf<AndroidVersion>()
    private lateinit var binding: ActivityAndroidVersionBinding
    private lateinit var adapter: AndroidVersionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAndroidVersionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = AndroidVersionAdapter(android)
        binding.rvAndroidList.adapter = adapter
        binding.rvAndroidList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        getAndroidVersion()
    }

    private fun getAndroidVersion() {
        AndroidVersionClient().getAndroidVersion()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { data ->
                android.addAll(data)
                adapter.notifyDataSetChanged()
            }
    }
}