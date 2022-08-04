package com.example.sports_summary.pojo.api
import com.example.sports_summary.NestedJSONModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    //@GET("/league-list?")
    @GET("/league-matches?key=test85g57&season_id=1625")
    suspend  fun getSeasonOne( ): Response<NestedJSONModel>

    @GET("/league-matches?key=test85g57&season_id=2012")
    suspend  fun getSesonTwo( ): Response<NestedJSONModel>

    @GET("/league-matches?key=test85g57&season_id=4759")
    suspend  fun getSesonThree( ): Response<NestedJSONModel>


}