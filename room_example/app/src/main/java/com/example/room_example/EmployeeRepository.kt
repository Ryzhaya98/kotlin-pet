package com.example.room_example

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe

class EmployeeRepository (private val employeeDao: EmployeeDao) {

    fun getUser(): List<Employee> {
        return employeeDao.getAllEmployee()
    }

    fun insertUser(employee: Employee): Completable {
        return employeeDao.insertEmployee(employee)
    }

    fun updateUser(employee: Employee): Completable {
        return employeeDao.updateEmployee(employee)
    }

    fun deleteUser(employee: Employee): Completable {
        return employeeDao.deleteEmployee(employee)
    }
}