package com.example.room_example

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ViewModel (application: Application) : AndroidViewModel(application) {

    private val compositeDisposable = CompositeDisposable()

    private val _employee = MutableLiveData<List<Employee>>()
    var user: LiveData<List<Employee>> = _employee

    private var userRepository: EmployeeRepository =
        EmployeeRepository(AppDataBase.getInstance(application).employeeDao())

    fun getUsers() {
        userRepository.getUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (!it.isNullOrEmpty()) {
                    _employee.postValue(it)
                } else {
                    _employee.postValue(listOf())
                }
            }, {
            }).let {
                compositeDisposable.add(it)
            }
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        compositeDisposable.clear()
        super.onCleared()
    }

    fun updateUser(employee: Employee) {
        userRepository.updateUser(employee)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                getUsers()
            }, {
            }).let {
                compositeDisposable.add(it)
            }
    }

    fun saveUser(employee: Employee) {
        userRepository.insertUser(employee)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                getUsers()
            }, {
            }).let {
                compositeDisposable.add(it)
            }
    }

    fun deleteUser(employee: Employee) {
        userRepository.deleteUser(employee)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                getUsers()
            }, {
            }).let {
                compositeDisposable.add(it)
            }
    }
}

