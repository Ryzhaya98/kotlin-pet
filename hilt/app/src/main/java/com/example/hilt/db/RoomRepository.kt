package com.example.hilt.db

import javax.inject.Inject

class RoomRepository @Inject constructor(private val appDao: AppDao) {

    fun getRecord():List<UserEntity>{
        return appDao.getRecord()
    }
    fun insertRecord(userEntity: UserEntity){
        appDao.insertRecord(userEntity)
    }
}