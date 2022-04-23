package com.example.ramadanreminder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ramadanreminder.RamdanDay.View.RamdanAdapter
import com.example.ramadanreminder.RamdanDay.View.Specific_Day
import com.example.ramadanreminder.RamdanDay.View.onDayClick
import com.example.ramadanreminder.RamdanDay.ViewModel.SpecificViewModel
import com.example.ramadanreminder.RamdanDay.ViewModel.SpecificViewModelFactory

class MainActivity : AppCompatActivity()  , onDayClick{
    //ref to view model
    lateinit var viewModel: SpecificViewModel
    lateinit var factory: SpecificViewModelFactory

    lateinit var dayAdapter : RamdanAdapter
    lateinit var layoutManager: LinearLayoutManager
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComp()
        setRecycler()
    }

    private fun initComp() {
        recyclerView=findViewById(R.id.RamdanDays)
    }


    private fun setRecycler() {
        layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.VERTICAL

        dayAdapter = RamdanAdapter(this,this)
//        recyclerView?.addItemDecoration(
//            DividerItemDecoration(
//                this,
//                layoutManager.orientation
//            )
//        )
        recyclerView!!.adapter = dayAdapter
        recyclerView!!.layoutManager = layoutManager
    }

    override fun onlick(position: Int) {
        var intent =  Intent(applicationContext, Specific_Day::class.java)
        intent.putExtra("dayid",position)
        startActivity(intent)
    }


}