package com.chrisprime.mviarchitecturesandbox.usecase

import com.chrisprime.mviarchitecturesandbox.DataState
import com.chrisprime.mviarchitecturesandbox.UIComponent
import com.chrisprime.mviarchitecturesandbox.network.PostApi
import com.chrisprime.mviarchitecturesandbox.network.model.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPosts(
    private val postApi: PostApi
) {
    fun execute(): Flow<DataState<List<Post>>> {
        return flow {
            emit(DataState.Loading(true))
            try {
                val posts = postApi.getPosts()
                emit(DataState.Success(posts))
            } catch (e: Exception) {
                e.printStackTrace()
                emit(DataState.Error(UIComponent.Toast(e.message ?: "Unknown error")))
            } finally {
                emit(DataState.Loading(false))
            }
        }
    }
}