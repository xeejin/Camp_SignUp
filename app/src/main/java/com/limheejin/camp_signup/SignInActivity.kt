package com.limheejin.camp_signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val loginButton = findViewById<Button>(R.id.btn_login)
        val signupButton = findViewById<Button>(R.id.btn_signup)
        val loginId = findViewById<EditText>(R.id.login_id)
        val loginPw = findViewById<EditText>(R.id.login_pw)



        // 로그인 버튼
        loginButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            val id = loginId.text.toString()
            val pw = loginPw.text.toString()

            if(id.isEmpty() || pw.isEmpty()){
                Toast.makeText(this.applicationContext,"아이디와 비밀번호를 모두 입력해주세요!", Toast.LENGTH_SHORT).show()
            } else {
                intent.putExtra("idFromSigninActivity", id)
                Toast.makeText(this.applicationContext,"로그인 성공!",Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }




//        // 회원가입의 ID를 넘겨주기 위한 ActivityResultLauncher
//        lateinit var resultLauncher: ActivityResultLauncher<Intent>
//        fun setResultSignup(){
//            resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
//                result -> if(result.resultCode == Activity.RESULT_OK){
//                    val id = result.data?.getStringExtra("id") ?: ""
//                    val pw = result.data?.getStringExtra("pw") ?: ""
////                    binding.loginId.setText(id)
////                    binding.loginPw.setText(pw)
//            }
//            }
//        }

        // 회원가입 버튼
        signupButton.setOnClickListener {

            val intent = Intent(this, SignupActivity::class.java)
//            resultLauncher.launch(intent)
            startActivity(intent)
        }


    }
}