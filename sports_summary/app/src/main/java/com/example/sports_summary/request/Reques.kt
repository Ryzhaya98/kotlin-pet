//package com.example.sports_summary.request
//import android.util.Log
//import com.example.sports_summary.pojo.api.ApiFactory
//import io.reactivex.disposables.CompositeDisposable
//import io.reactivex.schedulers.Schedulers
//import java.util.concurrent.TimeUnit
//
//class Reques {
//    private val compositeDisposable = CompositeDisposable()
//         fun loadData(season:Number) {
//        val disposable = ApiFactory.apiService.getTopCoinsInfo(key = "test85g57", season = season)
//            .delaySubscription(10, TimeUnit.SECONDS)
//            .delaySubscription(10, TimeUnit.SECONDS)
//            .repeat()
//            .retry()
//            .retry()
//            .subscribeOn(Schedulers.io())
//            .subscribe({
//
//                Log.d("TEST_OF_LOADING_DATA", "Success: $it")
//            }, {
//                Log.d("TEST_OF_LOADING_DATA", "Failure: ${it.message}")
//            })
//        compositeDisposable.add(disposable)
//
//
//    }
//}