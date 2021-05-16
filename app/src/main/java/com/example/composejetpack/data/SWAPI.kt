package com.example.composejetpack.data

import com.example.composejetpack.data.dto.PeopleDTO
import com.example.composejetpack.data.dto.PlanetDTO
import com.example.composejetpack.data.dto.StartshipDTO
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface SWAPI {
    @GET("people/1/")
    fun getPeople(): Deferred<Response<PeopleDTO>>

    @GET("starships/9/")
    fun getStarships(): Deferred<Response<StartshipDTO>>

    @GET("planets/3/")
    fun getPlanets(): Deferred<Response<PlanetDTO>>
}