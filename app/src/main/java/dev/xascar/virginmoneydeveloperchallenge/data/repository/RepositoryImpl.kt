package dev.xascar.virginmoneydeveloperchallenge.data.repository

import dev.xascar.virginmoneydeveloperchallenge.data.model.people.PeopleModel
import dev.xascar.virginmoneydeveloperchallenge.data.model.room.RoomModel
import dev.xascar.virginmoneydeveloperchallenge.data.remote.ApiDetails
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    val apiDetails: ApiDetails
) : Repository {

    override suspend fun getPeopleList(): Response<PeopleModel> {
        return apiDetails.getPeopleList()
    }

    override suspend fun getRoomList(): Response<RoomModel> {
        return apiDetails.getRoomList()
    }
}