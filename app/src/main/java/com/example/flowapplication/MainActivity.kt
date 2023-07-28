package com.example.flowapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: DataViewModel
    lateinit var adapter: DataAdapter

    val list: ArrayList<DataModel> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recView = findViewById<RecyclerView>(R.id.recView)
        val ipProgress = findViewById<ProgressBar>(R.id.ipProgress)
        viewModel = ViewModelProvider(this,DataFactory(DataRepository())).get(DataViewModel::class.java)
        adapter = DataAdapter(list)
        recView.layoutManager = LinearLayoutManager(this)
        recView.adapter = adapter



        CoroutineScope(Dispatchers.Main).launch {
            viewModel.dataflow.collect {
                /*    when(it){
                        it.data -> viewModel.getData()

                    }*/
                when {
                    it.isLoading -> {
                        ipProgress.visibility = View.VISIBLE

                    }


                    !it.errr.isBlank() -> {
                    }

                    else -> {
                        ipProgress.visibility = View.GONE
                        list.addAll(ArrayList(it.data))
                        adapter.notifyDataSetChanged()

                    }
                }
            }
        }
        viewModel.getData()

    }
}


/*    *//*       val txtView = findViewById<TextView>(R.id.txtView)
    viewModel =ViewModelProvider(this).get(FlowViewModel::class.java)
    CoroutineScope(Dispatchers.Main).launch {
     viewModel.datflow.collect{value->

         delay(500)
         txtView.text = value.toString()



         Log.d("value",value.toString())
     }
    }*

    /
     *//*


    *//*
            CoroutineScope(Dispatchers.Main).launch {
                val data: Flow<Int> = productData()
                data.collect {

                    Log.d("flowData---1",it.toString())
                }
            }
            CoroutineScope(Dispatchers.Main).launch {
                val data: Flow<Int> = productData()
                data.collect {
                    delay(300)
                    Log.d("flowData---2",it.toString())
                }
            }*//*



    CoroutineScope(Dispatchers.Main).launch
    {
        getList().map {
            FlowFormatted(it.id, it.isActive, it.description, it.title.uppercase())
        }
            .filter {
                it.isActive

            }.collect {
                Log.d("dataflow", it.toString())

                Log.d("thread ", Thread.currentThread().name)
            }
    }
}


*//*    fun productData() = flow<Int> {
        val list = listOf(1,2,3,4,5)
        list.forEach {
            emit(it)
        }
    }*//*
}*/
