package com.adrian.msgshareapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adrian.msgshareapp.Constants
import com.adrian.msgshareapp.R
import com.adrian.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_sencond.*

class SecondActivity : AppCompatActivity() {
    companion object {
        val TAG: String = SecondActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sencond)

        val bundle: Bundle? = intent.extras

        bundle?.let {
            val msg = bundle.getString(Constants.USER_MESSAGE).toString()

            showToast(msg)

            txvUserMessage.text = msg
        }
    }
}