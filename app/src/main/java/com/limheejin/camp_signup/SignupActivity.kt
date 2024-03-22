package com.limheejin.camp_signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        overridePendingTransition(R.anim.horizon_enter, R.anim.horizon_none)

        val backButton = findViewById<ImageView>(R.id.ic_back)
        val signupName = findViewById<EditText>(R.id.signup_name)
        val signupId = findViewById<EditText>(R.id.signup_id)
        val signupPw = findViewById<EditText>(R.id.signup_pw)
        val signupButton = findViewById<Button>(R.id.btn_signup)



        // 뒤로가기 버튼
        backButton.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.horizon_none, R.anim.horizon_exit)
        }


        //회원가입 버튼
        signupButton.setOnClickListener {
            val name = signupName.text.toString()
            val id = signupId.text.toString()
            val pw = signupPw.text.toString()

            if(name.isEmpty() || id.isEmpty() || pw.isEmpty()){
                Toast.makeText(this.applicationContext, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            }
            else {
//                val intent = Intent(this, SignInActivity::class.java)
//                intent.putExtra("id", id)
//                intent.putExtra("pw", pw)
//                setResult(RESULT_OK, intent)
                finish()
                Toast.makeText(this.applicationContext, "회원가입이 완료되었습니다. 로그인하세요.", Toast.LENGTH_SHORT).show()
            }
        }


    }
}