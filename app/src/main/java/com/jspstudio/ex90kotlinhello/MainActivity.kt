package com.jspstudio.ex90kotlinhello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

// 상속 키워드가 "extends"에서 ":" 으로 바뀜. 상속해주는 생성자를 호출하는 ()가 있음
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // 오버라이드가 @에서 키워드로 바뀜
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Button 참조변수
        // 변수는 var 키워드 사용
        var btn: Button = findViewById(R.id.btn)

        // 버튼 클릭에 반응하는 리스너 설정
        btn.setOnClickListener { clickBtn() }
    }

    // 함수만드는 키워드 fun
    fun clickBtn(){
        // TextView의 글씨를 변경하기 위해 TextView 참조하기
        var tv= findViewById<TextView>(R.id.tv) // 변수명 앞에 자료형 작성 안한경우 find뒤에 제네릭<> 을 작성해야함
        //tv.setText("ddd")

        // Kotlin 언어는 setXXX()메소드 사용을 권장하지 않고
        // 멤버변수에 값 대입하는 코드형식을 선호함
        tv.text= "Nice to meet you"
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume...", Toast.LENGTH_SHORT).show()

    }

}































