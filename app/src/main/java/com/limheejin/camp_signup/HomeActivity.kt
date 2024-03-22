package com.limheejin.camp_signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

//        overridePendingTransition(R.anim.horizon_enter, R.anim.horizon_none)

        // 로그인에서 받은 아이디를 넘겨줌
        val getid = intent.getStringExtra("idFromSigninActivity")
        val id = findViewById<TextView>(R.id.homeId)
        id.setText(getid)


        // 돌아가기 버튼
        val btn_back = findViewById<ImageView>(R.id.btn_back)
        btn_back.setOnClickListener {
            finish()
//            overridePendingTransition(R.anim.horizon_none, R.anim.horizon_exit)
        }

    }
}