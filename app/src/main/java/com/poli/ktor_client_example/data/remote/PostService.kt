package com.poli.ktor_client_example.data.remote

import com.poli.ktor_client_example.data.remote.dto.PostRequest
import com.poli.ktor_client_example.data.remote.dto.PostResponse
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

interface PostService {

    suspend fun getPosts(): List<PostResponse>
    suspend fun createPost(postRequest: PostRequest): PostResponse?

    companion object {
        fun create(): PostService {

            return PostServiceImpl(client = HttpClient(Android){
                install(Logging){
                    level = LogLevel.ALL
                }
                install(JsonFeature){
                    serializer = KotlinxSerializer()
                }
            })
        }
    }
}