package com.pale.presenter

import com.pale.model.DataItem

interface CrudView {
//    Untuk Get Data
    fun onSuccessGet(data: List<DataItem>?)
    fun onFailedGet(msg: String)

//    Untuk delete
    fun onSuccessDelete(msg: String)
    fun onErrorDelete(msg: String)

//   Untuk add
    fun successAdd(msg: String)
    fun errorAdd(msg: String)

//    Untuk Update
    fun onSuccessUpdate(msg: String)
    fun onErrorUpdate(msg: String)
}