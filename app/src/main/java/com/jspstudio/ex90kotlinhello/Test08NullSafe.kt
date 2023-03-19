package com.jspstudio.ex90kotlinhello

fun main() {
    // NullPointException [NPE]에 대한 앱의 버그를 문법적으로 막아주기 위한 Null safety 관련 문법들

    // 코틀린은 null 값을 저장할 수 있는 타입을 명시적으로 구분하여 사용하도록 함
    //var s1:String = null // error - non nullable 변수
    var s2: String? = null // OK - nullable 변수
    println(s2)

    // Nullable 변수를 사용할 때 특이한 멤버접근 연산자들
    var str1: String = "Hello" // non nullable type
    var str2: String? = "Nice" // nullable type

    // 위 두 타입(String, String?)의 차이
    println("글자수 : " + str1.length) // ok - 반드시 객체가 있다고 확신함. null값으로 초기화가 불가능해서
    //println("글자수 : " + str2.length) // error - String? 타입은 null일 수도 있어서 객체 참조여부와 상관없이 접근(.)불가 error

    // 해결방법 : null 인지 확인하고 사용하면 됨
    if (str2 != null) {
        // 이 영역 안에서는 str2가 null일 수가 없기때문에 . 연산자접근 허용
        println("글자수 : " + str2.length)
    }

    // 그러나 매번 String? 타입을 사용할때마다 if문을 사용하는것은 매우 번거로움

    // 1) ?. 연산자 - null safe 연산자
    println("글자수 : " + str2?.length) // null이 아닐때만 멤버에 접근. 만약 null이면 . 멤버를 사용하지 않음

    str2 = null
    println("글자수 : " + str2?.length)

    // 근데 결과가 null 이라는 것은 마음에 들지않음
    // 그래서 null일때는 글자수의 결과값으로 -1을 주고 싶음
    val len: Int = if (str2 != null) str2.length else -1
    println("글자수 : $len")

    // 해결은 되지만 if- else문이 번거로워 보임
    // 2) ?: 연산자 - 엘비스[Elvis] 연산자
    val len2: Int = str2?.length ?: -1 // ?: 앞에 값이 null이면 뒤에 값이 결과
    println("글자수 : $len2")
    println()

    // Java처럼 NPE이 발생해도 괜찮다고 하고싶다면
    // 3) !! non-null asserted 연산자
    var ss:String? = "Hello"
    println("글자수 : " + ss!!.length) // null이 아니라고 주장하는 방법

    // 진짜 null을 참조하면 error
    //var sss:String? = null
    //println("글자수 : " + sss!!.length) // 문법적 에러는 아니지만 실행하면 NPE 발생

    // 4) 안전한 형변환 연산자 as?
    val mmm:MMM? = MMM() // 제대로된 캐스팅(casting)

    //val zzz:ZZZ? = MMM() // error - 전혀 상관없는 클래스의 객체를 참조하는 것은 불가능

    // 억지로 형변환하여 참조시켜보기
    //var zzz:ZZZ? = MMM() as ZZZ? // 문법적 에러가 없어짐. 하지만 실행하면 casting 예외가 발생함. 다운됨

    // 문법적 에러가 표시되지 않아 개발자가 형변환을 실수할 여지가 있음
    // 안전한 형변환 연산자를 권함
    var zzz:ZZZ? = MMM() as? ZZZ? // 형변환 불가능하면 null로 결과를 줌
    println(zzz)

}

class MMM{
    var a = 10
}

class ZZZ{
    var a = 20
}
























