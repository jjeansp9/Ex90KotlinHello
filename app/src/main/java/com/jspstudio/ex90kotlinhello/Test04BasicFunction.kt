package com.jspstudio.ex90kotlinhello

fun main(){

    // 7. 함수
    // 7-1 함수선언 및 호출
    println("========= 7-1 함수선언 및 호출 =========")
    show()

    // 7-2 함수 파라미터 전달
    println("========= 7-2 함수 파라미터 전달 =========")
    output(100, "Hello")

    // 7-3 리턴을 하는 함수를 호출
    println("========= 7-3 리턴을 하는 함수를 호출 =========")
    var result= sum(5, 3)
    println(" sum 함수의 결과값 : $result")
    println()

    // 참고 ** 리턴이 없는 함수의 리턴을 받으면?
    println("========= 리턴타입 명시가 없는 함수 =========")
    var x= display()
    println(x)
    println()
    // ===========================================
    // 함수를 만드는 특이한 모습들
    // 7-4 함수선언의 단순화 : 리턴 키워드를 할당 연산자(=)로 바꿀 수 있음
    println("========= 7-4 함수선언의 단순화 =========")
    var data = getData()
    println(data)

    println("========= 7-4.2 return키워드를 할당연산자로 바꾸어 함수선언 =========")
    val data2= getData2()
    println(data2)
    println()

    println("========= 7-4.3 조금 더 복잡한 return 함수 =========")
    val data3= getData3(10)
    println(data3)
    println()

    println("========= 7-4.4 조금 더 복잡한 return 함수 =========")
    val data4= getData4(15)
    println(data4)
    println()

    // =========================================

    // 7-5 익명함수 - [ 추후 리스너 처리할 때 많이 사용됨 ]
    println("========= 7-5.1 기본적인 함수 =========")
    aaa()
    println()

    println("========= 7-5.2 익명함수 =========")
    // 7-5.2 익명함수 - 함수의 이름이 없음
    bbb()

    // 7-5.3 익명함수를 저장하는 변수에 자료형 표기해보기
    println("========= 7-5.3 익명함수를 저장하는 변수에 자료형 표기해보기 =========")
    ccc()

    // 7-5.4 익명함수를 좀 축약형으로 쓰고싶다면..

    println("========= 7-5.4 익명함수를 좀 축약형으로 쓰고싶다면.. =========")
    ddd()

    // 7-5.5 익명함수를 저장하는 변수의 자료형을 명시하지 않고 자동추론하도록
    println("========= 7-5.5 익명함수를 저장하는 변수의 자료형을 명시하지 않고 자동추론하도록 =========")
    eee()

    fff("hello")
    ggg("android")
    hhh("kim")
    iii("good")

    println(kkk()) // 리턴값 바로출력
    println(lll())
    println(mmm())
    println(nnn())

    getLength("aaa", eee) // 익명함수 eee를 전달
    getLength("aaa", fun(){ println("Hello@@")})
    getLength("aaa", { println("hello")})

    // 7-5.6 파라미터를 받는 익명함수

//    println("========= 7-5.2 익명함수 =========")
//    println("========= 7-5.2 익명함수 =========")
    //    println("========= 7-5.2 익명함수 =========")
    //    println("========= 7-5.2 익명함수 =========")
}

// ** 익명함수는 '고차함수'라는 곳에서 많이 활용됨
// '고차함수' : 파라미터로 다른 함수를 전달받는 함수
fun getLength(s:String, aaa:()->Unit){
    aaa() // 전달받은 함수를 대신 호출해줌
}

// 7-5.14 파라미터와 리턴이 모두 있는 익명함수
val ooo:(Int, Int)->Int = fun(a:Int, b:Int):Int{
    return a+b
}

val ppp:(Int, Int)->Int = { a,b-> a+b }

val rrr:(String)->Int = {
    it.length
}

// 7-5.13 만약 {} 영역안에 여러줄이 있다면 마지막 줄이 리턴값임
val nnn: ()->Int= {
    30
    40
    println("중간 실행문")
    50
}

// 7-5.12 익명함수의 축약형
val mmm: ()->Int = {
    30 // fun() 키워드를 생략하는 축약을 했다면 return 키워드도 생략해야만 함
}

// 7-5.11 익명함수의 자료형을 명시해보기
val lll: ()->Int= fun():Int{
    return 20
}

// 7-5.10 리턴타입있는 익명함수
val kkk= fun():Int{
    return 10
}

// 7-5.9 만약 익명함수의 축약형 사용할 때 파라미터가 1개라면 생략가능 [ 자동으로 it 이라는 변수가 지정됨 ]
val iii:(String)->Unit = {
    println("글자수 : ${it.length}")
}
// 변수의 자료형을 자동추론시켜버리면 파라미터의 존재여부를 확인할 수 없다고 판단해서 it도 사용불가
//val iii2= { println(it.length)} // error
val iii3 = {
    s:String-> println(s.length)
}

// 7-5.8 익명함수를 축약형으로 fun() 생략. 대신 {} 안에 파라미터 변수명 표시 ->
val hhh:(String)->Unit= {
        s->println("글자수 : ${s.length}")
}


// 7-5.7 변수에 자료형을 명시
val ggg:(String)->Unit= fun(s:String){
    println("글자수 : ${s.length}")
}

// 7-5.6 파라미터를 받는 익명함수
val fff= fun(s:String){
    println("글자수 : ${s.length}")
}

// 7-5.5 익명함수를 저장하는 변수의 자료형을 명시하지 않고 자동추론하도록
val eee= {
    println("eeee")
}

// 7-5.4 익명함수를 좀 축약형으로 쓰고싶다면..
val ddd:()->Unit = {
    println("ddd")
}
// 7-5.3 익명함수를 저장하는 변수에 자료형 표기해보기
// 함수의 자료형 모습 : ()->리턴타입
var ccc:()->Unit = fun(){ // 리턴타입이 없는경우 Unit
    println("ccc")
}

// 7-5.2 익명함수 - 함수의 이름이 없음 이름이 없기에 그냥쓰면 에러
//fun(){} //error
// 함수를 일반 변수에 대입(저장)할 수 있으며 저장하면 변수이름이 함수이 됨
var bbb= fun(){
    println("bbb")
}

// 7-5 익명함수 - [ 추후 리스너 처리할 때 많이 사용됨 ]
// 7-5.1 기본적인 함수
fun aaa(){
    println("aaa")
}

// 7-4.4 조금 더 복잡한 return 함수를 할당연산자로 단순화
fun getData4(n:Int):String = if (n<10) "good" else "bad"

// 7-4.3 조금 더 복잡한 return 함수
fun getData3(n:Int):String{
    if (n<10) return "Good"
    else return "Bad"
}

// 7-4.2 return키워드를 할당연산자로 바꾸어 함수선언
fun getData2():String = "Hello"


// 7-4 함수선언의 단순화 : 리턴 키워드를 할당 연산자(=)로 바꿀 수 있음
// 7-4.1 기본적인 return 사용함수
fun getData():String{

    return "Hello"
}


// 참고 ** 리턴타입 명시가 없는 함수 void가 아니라 Unit 이라는 자료형임
fun display(){
    println("display..")
}

// 7-3 리턴을 하는 함수선언
// 리턴타입을 함수명 앞에 쓰는게 아니라 함수명() 뒤에 ":리턴타입(자료형)" 명시함
fun sum(a:Int, b:Int):Int{

    return a+b
}

// 7-2 파라미터 전달받는 함수선언
// 파라미터 변수에 var 키워드 사용금지 - [ default로 val 로 됨 ]
fun output(num: Int, s: String){
    println("$num, $s" )
    //num = 50 // error - val로 되어있음
    println()
}

// 7-1 함수 선언
fun show(){
    println("show function")
    println()
}

