package br.com.concretechallenge.api

import br.com.concretechallenge.model.RepositoryData
import retrofit2.http.GET

interface GithubApi {

    @GET("/search/repositories")
    fun searchRepos():List<RepositoryData>

}