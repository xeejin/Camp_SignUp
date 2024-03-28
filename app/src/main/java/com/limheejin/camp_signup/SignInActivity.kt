package com.limheejin.camp_signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts


class SignInActivity : AppCompatActivity() {


    // ActivityResultLauncher자료형인 resultLauncher 변수를 전역 변수로 선언
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>


    //onCreate()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val loginButton = findViewById<Button>(R.id.btn_login)
        val signupButton = findViewById<Button>(R.id.btn_signup)
        val loginId = findViewById<EditText>(R.id.login_id)
        val loginPw = findViewById<EditText>(R.id.login_pw)


        // 비밀번호 노출/가림 체크박스 구현
        val visibleCheckBox = findViewById<CheckBox>(R.id.btn_visible)
        visibleCheckBox.setOnCheckedChangeListener{ buttonView, isChecked ->
            if (isChecked) {
                 // 체크된 경우, 일반 텍스트 입력 형태로 변경
                loginPw.transformationMethod = null
            } else {
                // 체크가 해제 된 경우, 비밀번호 입력 형태로 변경
                loginPw.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }

        // setResultNext 함수 호출
        // setResultNext 함수를 버튼 클릭 이전에 실행하는 이유는, 회원가입 버튼을 클릭하여 회원가입 액티비티로 이동하기 전에
        // 이미 resultLauncher가 초기화되어야 하기 때문이다. 그렇지 않으면 회원가입 액티비티에서 결과를 받을 수 없게 된다.
        // 따라서 onCreate 메서드에서 초기화하는 것이 필요하다.
        setResultNext()


        // 로그인 버튼 클릭 리스너
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

        // 회원가입 버튼 클릭 리스너
        signupButton.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            resultLauncher.launch(intent)
        }
    }





    // 회원가입의 ID를 넘겨받기 위한 setResultNext 함수 정의. onCreate()밖에서 선언
    private fun setResultNext(){
        resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){result ->
            if(result.resultCode == RESULT_OK){
                val id = result.data?.getStringExtra("id") ?: ""
                val loginId = findViewById<EditText>(R.id.login_id)
                loginId.setText(id)     // 오류 해결: Edittext의 경우 .text = ""가 아니라 setText("") 이용
            }
        }
    }
    // setResultNext 함수는 registerForActivityResult 함수를 사용하여 ActivityResultLauncher를 초기화
    // registerForActivityResult 함수는 액티비티의 수명 주기를 관찰하여 다른 액티비티에서의 결과를 처리할 수 있는 런처를 생성
    // ActivityResultContracts.StartActivityForResult 컨트랙트를 사용하여 결과를 받기 위한 런처를 생성
    // 생성된 런처는 ActivityForResultLauncher<Intent> 타입의 resultLauncher 변수에 할당
    // 이 런처는 회원가입 액티비티를 시작하고, 해당 액티비티로부터 결과를 받아오는 역할
    // 결과가 도착하면 실행되는 콜백 함수에서는 다음을 수행
    // 1) result.resultCode == RESULT_OK를 사용하여 결과가 성공적으로 도착했는지 확인
    // 2) 만약 결과가 성공적으로 도착했다면, result.data?.getStringExtra("id")를 통해 회원가입 액티비티에서 전달된 ID 값을 가져옴
    // 3) 가져온 ID 값을 loginId라는 이름의 EditText 변수에 설정

}