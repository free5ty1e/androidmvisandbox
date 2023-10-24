package com.chrisprime.mviarchitecturesandbox.network

import com.chrisprime.mviarchitecturesandbox.network.model.Post
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface PostApi {

    suspend fun getPosts(): List<Post>


    //Hilt dependency injection would be better:
    companion object {
        val httpClient = HttpClient(Android) {
            install(ContentNegotiation) {
                json(
                    Json {
                        this.ignoreUnknownKeys = true
                    }
                )
            }
        }
        fun providePostApi(): PostApi = PostApiImpl(httpClient)
    }
}
