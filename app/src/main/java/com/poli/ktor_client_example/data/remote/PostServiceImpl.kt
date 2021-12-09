package com.poli.ktor_client_example.data.remote

import com.poli.ktor_client_example.data.remote.HttpRoutes
import com.poli.ktor_client_example.data.remote.dto.PostRequest
import com.poli.ktor_client_example.data.remote.dto.PostResponse
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.get
import io.ktor.client.request.*
import kotlin.text.get

class PostServiceImpl
    ( private val client: HttpClient): PostService {
    override suspend fun getPosts(): List<PostResponse> {

        return try {
            client.get { url(HttpRoutes.POSTS) }
        }
        catch(e: RedirectResponseException ){
            println("Error: ${e.response.status.description}")
            emptyList()
        }catch(e: ClientRequestException ){
            println("Error: ${e.response.status.description}")
            emptyList()
        }catch(e: ServerResponseException ){
            println("Error: ${e.response.status.description}")
            emptyList()
        }
    }

    override suspend fun createPost(postRequest: PostRequest): PostResponse? {
        TODO("Not yet implemented")
    }

}