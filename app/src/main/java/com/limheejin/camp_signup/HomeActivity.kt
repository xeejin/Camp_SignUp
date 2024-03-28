package com.limheejin.camp_signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import java.util.Random

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        // 이미지 랜덤 출력
        val profilePic = findViewById<ImageView>(R.id.img_profile)
        val img : IntArray = intArrayOf(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5)
        val random = Random()
        val num = random.nextInt(img.size) // num 변수에 0부터 (images의 길이 - 1) 만큼 숫자 중 무작위 Int 저장
        profilePic.setImageResource(img[num]) // 랜덤으로 뽑은 숫자의 사진을 넣음



        // 로그인에서 받은 아이디를 넘겨줌
        val getid = intent.getStringExtra("idFromSigninActivity")
        val id = findViewById<TextView>(R.id.homeId)
        id.setText(getid)


        // 돌아가기 버튼
        val btn_back = findViewById<ImageView>(R.id.btn_back)
        btn_back.setOnClickListener {
            finish()

        }

    }
}