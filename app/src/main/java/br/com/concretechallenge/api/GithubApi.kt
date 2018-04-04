package br.com.concretechallenge.api

import br.com.concretechallenge.model.RepositoryData
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    @GET("/search/repositories")
    fun searchRepos(
            @Query("q") q: String,
            @Query("sort") sort: String,
            @Query("page") page: Int,
            @Query("per_page") per_page: Int
    ): Deferred<RepositoryData>

}