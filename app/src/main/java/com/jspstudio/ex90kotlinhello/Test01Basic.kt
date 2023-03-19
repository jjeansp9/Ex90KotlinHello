package com.jspstudio.ex90kotlinhello

// 문법적 주요 특징

// 1. 문장의 끝을 나타내는 ;을 사용하지 않음. 써도 에러는아니지만 무시됨
// 2. 변수를 만들 때 자료형을 명시하지 않고 var, val 키워드를 사용함. 단, 자료형은 존재함
// 3. new 키워드 없이 객체 생성함 [ new String() -> String() ]
// 4. 안전하게 null 을 다룰 수 있는 문법을 제공함
// 5. 코틀린은 함수형 언어임. 즉, 함수를 객체처럼 생각해서 변수에 저장하고 파라미터 넘겨주는 등의 작업이 가능함

// #. 프로그램의 시작함수인 main함수가 반드시 있어야함
fun main(){

    // **.kt 코틀린 파일만 별도로 실행하려면 마우스 우클릭으로 해당 파일만 run 메뉴 실행

    // 1. 화면출력 : print(), println() 함수
    print(100)
    print(3.14 )
    print("Nice")

    // 자동줄바꿈이 되는 출력기능함수 사용
    println()
    println(1121)
    println("ss11")
    println('A')
    println('a')
    println(true)
    println(5+3)

    var a: Int = 10000 // 모든 자료형의 첫글자는 대문자로 씀
    println(a)
    var b: String = "Hello World!!!!!"
    println(b)

    // 2. 자료형과 변수
    // * 코틀린 자료형의 종류
    // 1) 기초타입 : Boolean, Byte, Char, Short, Int, Long, Float, Double [ 기본적으로 코틀린은 모든 변수가 객체임. 즉 모두 참조변수임 ]
    // 2) 참조(reference)타입 : String, Any(Java의 Object와 비슷), Unit.. 그외 Kolin APIs, Java APIs

    // * 변수의 2가지 종류 : var, val
    // 2-1 var [ 값 변경 가능한 변수 ]
    var num: Int= 5555
    println(num)

    var num2: Double= 3.144444
    println(num2)

    // 지역변수는 변수를 만들 때 값을 대입하지 않아도 됨
    var num3: Float // 이러한 방식은 권장하지 않음
    num3= 66.3141f
    println(num3)

    // 변수이므로 변수의 값을 변경할 수 있음
    num= 20
    num2= 30.6
    num3= 10.40f
    println(num)
    println(num2)
    println(num3)

    // 당연히 다른 자료형의 값 대입은 불가능
    //num= 3.14 // error [ Int형 변수에 Double형 대입 불가능 ]
    //num2= 50 // error [ Double 변수에 Int 대입 불가능 ] - 자동형변환 X

    // 명시적으로 형변환 하는 방법 [ .toXXX()로 변환 ]
    //num= (int)143.14 //()형변환 연산자 없음
    num= 2.13.toInt()
    num2= 50.toDouble()
    println(num)
    println(num2)

    // 문자열 String 객체
    var s: String= "Hello"
    println(s)
    //var s2: String= String("Hello") // String() 객체생성 메소드가 없음
    println()

    // 2-2 val [ 값 변경 불가능한 변수 - 읽기전용 변수 ] # 상수와는 약간 다름. 상수는 const 키워드사용.
    val n1:Int= 123
    //n1= 200 // error - 변경불가
    val n2:Boolean= true
    //n2= false // error

    // 권장하지 않지만 초기값을 다음줄에 설정할 수 있음
    val n3: String
    n3= "nice"
    //n3= "good" // error
    println(n3)
    println()

    // ## var, val 사용 팁: 데이터를 가지는 변수는 var[ ex: name, age, title ... ], 객체를 참조하는 변수는 val [ ex: TextView, ImageView ... ]

    // 2-3 자료형을 생략하여 변수선언이 가능함 - 자료형은 자동 추론됨
    var aa= 10 // Int로 추론
    println(aa)
    var bb= 3.14 // 위와 동일
    println(bb)
    var cc= 3.14f // 위와 동일
    println(cc)
    val dd= true // 위와 동일
    println(dd)
    val ee= 'A' // 위와 동일
    println(ee)
    val ff= "Hello" // 위와 동일
    println(ff)

    // 자료형이 없는게 아니라 추론된 것임
    // 당연히 추론된 후, 다른 자료형의 값 대입 불가능
    //aa= 1.42f // error - Int로 이미 추론된 변수

    // 그렇기에 자료형을 명시하지 않으면서 값대입도 없으면 에러
    //    var gg // error
    //    gg= 10

    // * 정수값 표기법의 특이한 점 *
    var a3= 5_000_000 // 세자리 구분자 사용 ( 큰 숫자 세기 어려울 때 사용 )
    println(a3)
    println()

    // 2-4 코틀린만의 자료형 타입
    // Any타입 [ 최상의 자료형 ]
    var v: Any // Any참조변수가 객체를 가리키는 것

    v=10
    println(v)
    v= "wewe"
    println(v)
    v= 3.15f
    println(v)

    // Any 타입을 사용하면 만능 자료형 처럼 보이기에
    // 초심자들이 참 편해서 사용하고싶어하지만
    // 변수를 봤을때 무슨 자료형인지 확인하기 어려워서
    // 실무에서는 사용을 제한적으로 함
    println()

    // 2-5 ** null 값에 대한 특이한 자료형 [별도로 추가수업 예정] **
    // 기본적으로 자료형은 null 값을 저장할 수 없음
    //var n2:Int= null // error
    //var s: String= null // error

    // null값을 저장할 수 있는 자료형이라는 "?"표시가 필요함
    var nn: Int? = null
    println(nn)
    var s2: String? = null
    println(s2)
    println()

    // 일반자료형과 Nullable 자료형의 차이
    var aaa: String= "Hello"
    println(aaa.length)

    var bbb: String?= "Hello"
    //println(bbb.length) // error - null일수도 있어서 그냥 "."하면 에러
    println(bbb?.length) // ?. 널안전 연산자
    println()
    // ################################################

    // ** 화면출력할때 (String을 특정 format으로 만들기)
    println("hello" + " kotlin")

    // 문자열의 + 결합연산자를 사용할 때
    // 기본자료형과 함께 사용하면 자동 형변환이 되었음
    //println(10+"hello") // error - 기초타입을 String으로 자동형변환 안해줌
    // 기초타입을 String으로 변환하여 결합
    println(10.toString() + "aaa")

    // 특이한 점은 순서를 바꾸면 자동형변환 함
    println("aaa" + 10)
    println()

    // ** 2개의 정수형변수의 값 덧셈 프로그램 **
    var nnn1: Int = 50
    var nnn2: Int = 30

    // 두 변수의 덧셈결과를 식과 함께 출력하는 format
    // [ 문자열 템플릿 ]
    println("${nnn1} + $nnn2 = ${nnn1+nnn2}")

    var name = "sam" // 자동추론
    var age = "20"
    println("이름 : $name \n나이 : $age\n")



}



















