package com.example.week10

import retrofit2.Call
import retrofit2.http.*
interface MovieAPIService {
    // Display the movie list
    @GET(".")
    fun getAllMovies(): Call<ApiResponse<List<Movie>>>

    // Display a movie by ID
    @GET("{id}")
    fun getMovieById(@Path("id") id: String?): Call<ApiResponse<Movie>>

    // Add a new movie
    @POST(".")
    fun addMovie(@Body movie: Movie): Call<ApiResponse<Movie>>

    // Update a movie by ID
    @PUT("{id}")
    fun updateMovie(@Path("id") id: String?, @Body movie: Movie): Call<ApiResponse<Movie>>

    // Delete a movie by ID
    @DELETE("{id}")
    fun deleteMovie(@Path("id") id: String?): Call<ApiResponse<String>>
}