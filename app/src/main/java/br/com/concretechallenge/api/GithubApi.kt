package br.com.concretechallenge.api

import retrofit2.http.GET

interface GithubApi {

    @GET("/search/repositories")
    fun searchRepos():List<RepositoriesData> (

    )

}