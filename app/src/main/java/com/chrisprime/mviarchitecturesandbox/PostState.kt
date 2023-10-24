package com.chrisprime.mviarchitecturesandbox

import com.chrisprime.mviarchitecturesandbox.network.model.Post

data class PostState(
    val progressBar: Boolean = false,
    val posts: List<Post> = emptyList(),
//    val error: String? = null
)
