# :iphone: 로그인 및 회원가입 화면전환 구현 앱
   

## :tada: 필요한 지식
- Activity
- XML Layout(ConstraintLayout, EditText, TextView, Button등)
- Widget
- 사용자 이벤트 처리
- Intent
- Toast
- 예외 처리
- EditText Validation
- finish


## :hammer: 로그인 페이지 만들기 (SignInActivity)

<p align="center">
   <img src="https://github.com/xeejin/Camp_SignUp/assets/141006937/43be461b-bff3-4e2d-8ce1-1b7e7aec3a5a" height=700px>
</p>

- [x]  MainActivity의 이름을 SignInActivity로 변경
- [x]  로고 이미지 삽입
- [x]  아이디, 비밀번호를 입력 받는 EditText 배치
- [x]  미리보기 글씨(플레이스 홀더) 구현: android:hint = "" 이용
- [x]  비밀번호 EditText 입력시 가림 ●●● 처리: android:inputType="TextPassword" 이용
- [ ]  로그인 버튼을 누르면 HomeActivity가 실행되도록 구현 (Extra로 아이디를 넘겨줌)
- [ ]  아이디/비밀번호 모두 입력 되어야만 로그인 버튼이 눌리도록 구현  (“로그인 성공”이라는 토스트 메세지 출력하도록 구현)
- [ ]  아이디/비밀번호 중 하나라도 비어 있다면 “아이디/비밀번호를 확인해주세요” 라는 토스트 메세지가 출력되도록 구현
- [ ]  회원가입 버튼을 누르면 SignUpActivity가 실행되도록 구현

 
## :hammer: 회원가입 페이지 만들기 (SignUpActivity)

- [ ]  타이틀 이미지는 원하는 이미지로 변경
- [ ] 이름, 아이디, 비밀번호 모두 입력 되었을 때만 회원가입 버튼이 눌리도록 구현합
  (셋 중 하나라도 비어있으면 “입력되지 않은 정보가 있습니다” 라는 토스트 메세지를 출력하도록 구현)
- [ ]  비밀번호 EditText는 입력 내용이 가려져야 함 (●●● 처리)
- [ ]  회원가입 버튼이 눌리면 SignInActivity로 이동하도록 구현 (finish 활용)


## :hammer: 자기소개 페이지 만들기 (HomeActivity)

- [ ]  SignInActivity에서 받은 extra data(아이디)를 화면에 표시
- [ ]  ImageView, TextView 외에 각종 Widget을 활용해 자유롭게 화면을 디자인
    - [ ]  이름, 나이, MBTI 등 자기소개등이 들어가는 위젯을 자유롭게 디자인
- [ ]  종료 버튼이 눌리면 SignInActivity로 이동하도록 구현 (finish 활용)


## :hammer: 화면 이동 + a
- [ ]  회원가입 페이지에서 입력한 아이디/비밀번호가 로그인 화면으로 입력할 때 자동으로 이동되도록 구현
- [ ]  registerForActivityResult 에 대한 탐구


## :hammer: 자기소개 랜덤사진
- [ ]  5장의 사진 파일을 등록 후, 자기 소개 페이지가 시작될 때 5장 중 랜덤으로 1장의 사진이 표시되도록 구현


## :hammer: 개인적인 구현
- [ ]  로그인 화면에서 CheckBox를 추가하고 비밀번호 가림 체크/해제 기능
