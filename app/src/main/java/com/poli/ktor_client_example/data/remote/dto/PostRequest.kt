package com.poli.ktor_client_example.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class PostRequest (
    val body: String,
    val title: String,
    val userId: Int
    )