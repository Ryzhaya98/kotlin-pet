package com.example.hilt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hilt.db.RoomRepository
import com.example.hilt.db.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository:RoomRepository):ViewModel() {
    lateinit var userData: MutableLiveData<List<UserEntity>>

    init {
        userData = MutableLiveData()
    }

    fun getRecordObserver(): MutableLiveData<List<UserEntity>>{
        return userData
    }

    fun loadRecord(){
        val list = repository.getRecord()
        userData.postValue(list)
    }
    fun insertRecord(userEntity: UserEntity){
        repository.insertRecord(userEntity)
        loadRecord()
    }
}