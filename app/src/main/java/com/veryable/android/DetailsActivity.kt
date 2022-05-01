package com.veryable.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val view_name : TextView = findViewById(R.id.account_name)
        val view_desc: TextView = findViewById(R.id.desc)
        val view_img : ImageView = findViewById(R.id.img)
        val done : Button = findViewById(R.id.done)
        val back : Button = findViewById(R.id.back)

        val bunlde : Bundle? = intent.extras
        val account_name = bunlde!!.getString("name")
        val desc = bunlde!!.getString("desc")
        val type = bunlde!!.getString("type")

        view_name.text = account_name
        view_desc.text = desc
        if (type.equals("card")){
            view_img.setBackgroundResource(R.drawable.baseline_credit_card_black_48pt_3x)
        }
        else{
            view_img.setBackgroundResource(R.drawable.baseline_account_balance_black_48pt_3x)
        }

        done.setOnClickListener{
            onBackPressed()
        }
        back.setOnClickListener{
            onBackPressed()
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}