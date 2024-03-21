package com.limheejin.camp_signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        // 로그인에서 받은 아이디를 넘겨줌
        val getid = intent.getStringExtra("idFromSigninActivity")
        val id = findViewById<TextView>(R.id.homeId)
        id.setText(getid)


        // 돌아가기 버튼
        val btn_back = findViewById<Button>(R.id.btn_back)
        btn_back.setOnClickListener {
            finish()
        }

    }
}