package com.poli.ktor_client_example.data.remote

import com.poli.ktor_client_example.data.remote.dto.PostRequest
import com.poli.ktor_client_example.data.remote.dto.PostResponse
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*



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

        return try {
            client.post<PostResponse> {

                url(HttpRoutes.POSTS)
                contentType(ContentType.Application.Json)
                body = postRequest

            }
        }
        catch(e: RedirectResponseException ){
            println("Error: ${e.response.status.description}")
            null
        }catch(e: ClientRequestException ){
            println("Error: ${e.response.status.description}")
            null
        }catch(e: ServerResponseException ){
            println("Error: ${e.response.status.description}")
            null
        }

    }

}