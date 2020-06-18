package com.pale

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pale.adapter.DataAdapter
import com.pale.model.DataItem
import com.pale.presenter.CrudView
import com.pale.presenter.Presenter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(), CrudView {

    private lateinit var presenter: Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = Presenter(this)
        presenter.getData()

        btnTambah.setOnClickListener{
            startActivity<UpdateAddActivity>()
            finish()
        }
    }

    override fun onSuccessGet(data: List<DataItem>?) {
        rvCategory.adapter = DataAdapter(data,object :
            DataAdapter.onClickItem{
            override fun clicked(item: DataItem?) {
                startActivity<UpdateAddActivity>("dataItem" to item)
            }
            override fun delete(item: DataItem?) {
                presenter.hapusData(item?.staffId)
                startActivity<MainActivity>()
                finish()
            }
        })

    }

    override fun onFailedGet(msg: String) {
        TODO("Not yet implemented")
    }

    override fun onSuccessDelete(msg: String) {
       presenter.getData()
    }

    override fun onErrorDelete(msg: String) {
        alert {
            title = "error Delete Data"
        }.show()
    }

    override fun successAdd(msg: String) {
        TODO("Not yet implemented")
    }

    override fun errorAdd(msg: String) {
        TODO("Not yet implemented")
    }

    override fun onSuccessUpdate(msg: String) {
        TODO("Not yet implemented")
    }

    override fun onErrorUpdate(msg: String) {
        TODO("Not yet implemented")
    }
}