package com.adrian.msgshareapp.activities

import android.content.ClipDescription
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.adrian.msgshareapp.Constants
import com.adrian.msgshareapp.R
import com.adrian.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener {
            val message = resources.getString(R.string.btn_was_clicked)
            Log.i(TAG, message)

            showToast(message, Toast.LENGTH_LONG)
        }

        btnSendMsgToNextActivity.setOnClickListener {
            val message: String = etUserMessage.text.toString()

            showToast(message)

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(Constants.USER_MESSAGE, message)

            startActivity(intent)
        }

        btnShareToOtherApps.setOnClickListener {
            val message: String = etUserMessage.text.toString()

            val intent = Intent()

            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = ClipDescription.MIMETYPE_TEXT_PLAIN

            startActivity(Intent.createChooser(intent, "Share to: "))
        }

        btnRecyclerViewDemo.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)

            startActivity(intent)
        }
    }
}