package com.chrisprime.mviarchitecturesandbox.network

import com.chrisprime.mviarchitecturesandbox.network.model.Post
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.*

class PostApiImpl(
    private val httpClient: HttpClient
): PostApi {
    override suspend fun getPosts(): List<Post> {
        return httpClient.get {
            url("https://jsonplaceholder.typicode.com/posts")
        }.body()
    }
}
