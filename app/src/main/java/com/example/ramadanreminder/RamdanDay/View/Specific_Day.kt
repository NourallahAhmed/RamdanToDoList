package com.example.ramadanreminder.RamdanDay.View

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ramadanreminder.DB.ConcreteLocalSource
import com.example.ramadanreminder.MainActivity
import com.example.ramadanreminder.Model.RamdanModel
import com.example.ramadanreminder.R
import com.example.ramadanreminder.RamdanDay.ViewModel.SpecificViewModel
import com.example.ramadanreminder.RamdanDay.ViewModel.SpecificViewModelFactory
import com.example.ramadanreminder.Repo.Repo

class Specific_Day :AppCompatActivity() {
    //ref to view model
    lateinit var viewModel: SpecificViewModel
    lateinit var factory: SpecificViewModelFactory
    lateinit var myDay : RamdanModel
    lateinit var AzkarS :CheckBox
    lateinit var AzkarM :CheckBox
    lateinit var Quran :CheckBox
    lateinit var Tasbih :CheckBox
    lateinit var home :Button
    //sharedpref

    lateinit var settings : SharedPreferences
    lateinit var editer : SharedPreferences.Editor
    val PREFS_NAME= "mysharedfile"

    lateinit var daypref:String
    var  dayid :Int = 0


    //passing params

    var BTasbih =false
    var BQuran =false
    var BAzkarM =false
    var BAzkarS =false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.specific_day)
        initcomp()
        dayid= intent.getIntExtra("dayid",1)

        factory = SpecificViewModelFactory(Repo.getInstance(ConcreteLocalSource(this)))

        viewModel = ViewModelProvider(this, factory).get(SpecificViewModel::class.java)

        //shared
        settings = applicationContext.getSharedPreferences(PREFS_NAME,0)
        editer = settings.edit()
        daypref="day"+dayid
        checkDay()

        //todo -> get stored data it exist
        getstord()

    }

    private fun checkDay() {
        var check = settings.getInt(daypref,0)
        //first time entered
        println("check from pref : $check")
        if(check ==0 )
        {
            myDay= RamdanModel(dayid,false,false,false,false)
            viewModel.inserttoDB(myDay)
        }


    }

    private fun initcomp() {
        AzkarS=findViewById(R.id.AzkarSbah)
        AzkarM=findViewById(R.id.AzkarMasaa)
        Quran=findViewById(R.id.Quran)
        Tasbih=findViewById(R.id.tasbih)
        findViewById<Button?>(R.id.home).setOnClickListener {
            insertToDB()
            println("insert")
            startActivity(Intent(this,MainActivity::class.java))
        }
    }

    private fun getstord() {
        viewModel.getLocal(dayid)
        //observe
        viewModel.dataimmutable.observe(this){
            setDataOnScreen(it)
        }
    }

    private fun setDataOnScreen(it: RamdanModel?) {
        if(it!!.azkarM){
            AzkarM.isChecked=true
        }
        if(it!!.azkarS){
            AzkarS.isChecked=true
        }

        if(it!!.quran){
            Quran.isChecked=true
        }
        if(it!!.tasbih){
            Tasbih.isChecked=true
        }
    }

    private fun insertToDB() {
        println("insert")

        if(AzkarS.isChecked){
            BAzkarS=true
        }
        if(AzkarM.isChecked){
            BAzkarM=true
        }
        if(Quran.isChecked){
            BQuran=true
        }
        if(Tasbih.isChecked){
            BTasbih=true
        }

        //put in shared pref
        editer.putInt(daypref,dayid+1)
    println("put on pref: $daypref ,$dayid+1 ")
        //days from 1 not 0
        myDay=RamdanModel(dayid,BAzkarS,BAzkarM,BQuran,BTasbih)
        viewModel.inserttoDB(myDay)
    }

    override fun onStop() {
        super.onStop()
        editer.commit()
    }
}