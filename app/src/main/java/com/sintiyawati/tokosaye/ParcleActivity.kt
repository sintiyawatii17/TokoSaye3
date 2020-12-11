package com.sintiyawati.tokosaye

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sintiyawati.tokosaye.model.User
import kotlinx.android.synthetic.main.activity_explicit_intent.*
import kotlinx.android.synthetic.main.activity_explicit_intent.btn_back
import kotlinx.android.synthetic.main.activity_explicit_intent.txt_age
import kotlinx.android.synthetic.main.activity_explicit_intent.txt_email
import kotlinx.android.synthetic.main.activity_explicit_intent.txt_nama
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_parcle.*

class ParcleActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcle)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User

        txt_nama.text = user.name
        txt_email.text = user.email
        txt_age.text = user.age

        btn_back.setOnClickListener {
            val backItem = Intent(this@ParcleActivity, MainActivity::class.java)
            startActivity(backItem)

        }
    }
}
