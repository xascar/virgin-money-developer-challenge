package dev.xascar.virginmoneydeveloperchallenge.data.repository


import dev.xascar.virginmoneydeveloperchallenge.data.model.people.PeopleModel
import dev.xascar.virginmoneydeveloperchallenge.data.model.room.RoomModel
import retrofit2.Response

interface Repository {

    suspend fun getPeopleList() : Response<PeopleModel>

    suspend fun getRoomList() : Response<RoomModel>

}