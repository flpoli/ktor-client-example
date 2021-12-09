package com.poli.ktor_client_example.data.remote

import com.poli.ktor_client_example.data.remote.dto.PostRequest
import com.poli.ktor_client_example.data.remote.dto.PostResponse

interface PostService {

    suspend fun getPosts(): List<PostResponse>
    suspend fun createPost(postRequest: PostRequest): PostResponse?
}