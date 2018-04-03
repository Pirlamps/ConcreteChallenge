package br.com.concretechallenge.main

import br.com.concretechallenge.api.GithubApi
import br.com.concretechallenge.model.RepositoryData
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainController {


    suspend fun getData(): RepositoryData {

        val retrofit = Retrofit.Builder().apply {
            baseUrl("https://api.github.com/")
            addConverterFactory(GsonConverterFactory.create())
            addCallAdapterFactory(CoroutineCallAdapterFactory())
        }.build()

        val service = retrofit.create(GithubApi::class.java)
        val response = service.searchRepos(
                "java",
                "stars",
                1,
                2
        ).await()
        println(response)
        return response
    }

}