package com.developer.fetchapp.services

import com.developer.fetchapp.model.Item
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
const val END_POINT = "hiring.json"

private val retrofit = Retrofit
    .Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val fetchService = retrofit.create(ApiService::class.java)

interface ApiService{
    @GET(END_POINT)
    suspend fun getListItems(): List<Item>
}