package com.example.journal_test_task.model

import io.realm.RealmObject

open class Article (var title:String="", var date:String="", var imgString: String=""): RealmObject() {
}

