package dev.xascar.virginmoneydeveloperchallenge.data.remote

import dev.xascar.virginmoneydeveloperchallenge.data.model.room.RoomModel
import dev.xascar.virginmoneydeveloperchallenge.data.model.people.PeopleModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiDetails {

    @GET(ApiReference.PEOPLE)
    suspend fun getPeopleList(): Response<PeopleModel>

    @GET(ApiReference.ROOM)
    suspend fun getRoomList(): Response<RoomModel>

}