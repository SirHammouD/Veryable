package com.veryable.android

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.veryable.android.databinding.ActivityPayoutsListBinding
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class PayoutsListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPayoutsListBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_payouts_list)
        setContentView(binding.root)

       // if(NetworkCall()) {
            doAsync {
                val json =
                    URL("https://veryable-public-assets.s3.us-east-2.amazonaws.com/veryable.json").readText()
                uiThread {
                    d("testing", "json: $json")
                    val data = Gson().fromJson(json, Array<Data>::class.java).toList()

                    val cardData: MutableList<Data> = mutableListOf<Data>()
                    val bankData: MutableList<Data> = mutableListOf<Data>()

                    for (i in data) {
                        if (i.account_type.equals("card")) {
                            cardData.add(i)
                        }
                    }

                    for (i in data) {
                        if (i.account_type.equals("bank")) {
                            bankData.add(i)
                        }
                    }

                    binding.rcViewBank.apply {

                        layoutManager =
                            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                        adapter = DataAdapter(bankData, context)
                        addItemDecoration(
                            DividerItemDecoration(
                                context,
                                LinearLayoutManager.VERTICAL
                            )
                        )

                    }


                    binding.rcViewCard.apply {

                        layoutManager =
                            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                        adapter = DataAdapter(cardData, context)
                        addItemDecoration(
                            DividerItemDecoration(
                                context,
                                LinearLayoutManager.VERTICAL
                            )
                        )

                    }
                }
            }


       /* }
        else{
            Toast.makeText(this, "No internet connection, please connect to wifi to display data", Toast.LENGTH_LONG).show()
        }*/

    }
/*
    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("WrongConstant")
    private fun NetworkCall(): Boolean{

        val connectivityManager = getSystemService(Context.CONNECTIVITY_DIAGNOSTICS_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
        return networkCapabilities != null && networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_CAPTIVE_PORTAL)
    }*/
}