package com.sintiyawati.tokosaye

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Sampler
import android.util.Log
import android.widget.Button
import com.sintiyawati.tokosaye.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val REQUEST_CODE = 100
        const val EXTRA_COLOR = "extra_color"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_simple_intent.setOnClickListener {
            val simpleintent = Intent(this@MainActivity, SimpleActivity::class.java)
            startActivity(simpleintent)
        }
        btn_intent_with_data.setOnClickListener {
            val dataIntent = Intent(this@MainActivity, ExplicitIntentActivity::class.java)
            dataIntent.putExtra(ExplicitIntentActivity.EXTRA_NAME, "Baju Terusan Dress Wanita Lea Dress Ikat Bahan Twiscone")
            dataIntent.putExtra(ExplicitIntentActivity.EXTRA_AGE, "Ukuran All Size Fit To L")
            dataIntent.putExtra(ExplicitIntentActivity.EXTRA_EMAIL, "350")
            startActivity(dataIntent)
        }
        btn_intent_parcelable.setOnClickListener {
            val parcelIntent = Intent(this@MainActivity, ParcleActivity::class.java)
            val user = User("Sintiyawati", "sintiyawati2001@gmail.com", "19 Tahun")
            parcelIntent.putExtra(ParcleActivity.EXTRA_USER, user)
            startActivity(parcelIntent)
        }
        btn_implicit_intent.setOnClickListener {
            val phoneNumber = "089652993129"
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:$phoneNumber"))
            intent.putExtra("sms_body", "Assalammualaikum")
            startActivity(intent)
        }

        btn_intent_result.setOnClickListener {
            val intent = Intent(this@MainActivity, ResultActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)

        }

    }

    private fun startActivityForResult(intent: Intent) {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == 200){

            val color = data?.getStringExtra(ResultActivity.EXTRA_COLOR)
            Log.d("color", color.toString())
            view_result.setBackgroundColor(Color.parseColor(color))
        }
    }
}

