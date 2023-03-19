package com.jspstudio.ex90kotlinhello

fun main(){
    // 안드로이드에서 많이 사용되는 것들
    // 1) 이너클래스 , 인터페이스 , 익명클래스
    // 2) static 의 대체기능인 companion object[동반객체]        companion : 동반자
    // 3) 늦은 초기화 - lateinit , by lazy          lazy : 게으른

    // 1. 이너클래스
    //var obj = AAA.BBB() // 이너클래스는 아웃터클래스에서만 생성가능함
    var obj= AAA()
    var obj2= obj.makeBBBInstance()
    obj2.show()

//    var obj3= AAA().BBB()
//    obj3.show()

    // 2. 인터페이스
    //val c= Clickable() // error : 인터페이스는 곧바로 객체생성이 불가능
    // Clickable을 구현한 Test클래스 객체 생성

    val btn= Test()
    btn.onClick()

    // 3. 익명클래스
    val a= object : Clickable{
        override fun onClick() { println("Anonymous class onClick") }
    }

    a.onClick()
    println()
    // 4. 동반객체 [ companion object ] - Java의 static 키워드와 유사한 기능 : 객체생성없이 사용가능한 멤버만들때 사용하는 기능
    //println(Sample.n) // 클래스의 일반멤버는 객체를 생성할때만 사용가능
    println(Sample.title) // 클래스 생성없이 사용가능
    Sample.title= "robin"
    println(Sample.title)
    Sample.showTitle()

    // 5. 늦은초기화 - 클래스의 프로퍼티 초기화를 미룰 수 있는 키워드
    val h= Hello()
    h.onCreate()
    h.show()

}

// 5.
class Hello{

    //var name:String // error : 프로퍼티는 선언하면서 값을 초기화 해야함
    // 만약 초기화를 나중에 하고싶다면? [ 안드로이드에서 View들 참조변수들은 onCreate()에서 초기화 이루어져야함 ]
    // 5-1) lateinit
    lateinit var name:String // 선언하고 초기화 안해도됨

    fun onCreate(){
        name= "Sam" // 프로퍼티 초기화
    }

    fun show(){
        println("name : $name")
    }

    // ** lateinit 키워드 사용할때 주의할 점 **
    // 1. lateinit 키워드는 null초기화는 불가능 [ 즉, String? 타입은 불가 ]
    //lateinit var title:String? - error

    // 2. 기초타입 자료형에서는 사용 불가능
    //lateinit var age:Int - error

    // 3. val 키워드로 만든 읽기전용 변수에는 사용이 불가능
    //lateinit val address:String - error
    // ********************************************

    // 5-2) val 변수의 늦은초기화 키워드 [ by lazy ]
    val address:String by lazy { "Seoul" } // {}안에 있는 값을 지금 대입하지 않고 처음 이 변수가 사용될 때 대입해줌

    val title:String by lazy {
        "Hello title"
        "aaaaaaa" // 마지막줄 값이 실행
         println("Asdsa") // println()은 마지막줄에 있으면 error
        "asdsd"
    }

    // by lazy는 lateinit과 다르게 기초타입도 가능함
    val age:Int by lazy { 20 }

    // nullable type 도 가능함
    val message:String? by lazy { "Hello by lazy" }
    val message2:String? by lazy { null }

    // 연산에 의한 초기화도 가능함
    val message3:String? by lazy { if(age<20) "미성년자" else "성인" }

    // 단, by lazy는 var에는 사용 불가능
    // 개발자가 만든 클래스의 객체 생성도 by lazy로 가능
    val person:Person by lazy { Person("nam", 20) }

}

// 4.
class Sample{
    var n:Int= 10

    // 코틀린은 static 키워드 존재하지 않음
    // 객체생성없이 사용가능한 멤버들 [ 동반객체 - 클래스설계도와 같이 존재하는 객체 ]
    companion object{
        var title:String= "sam" // java의 static 변수같은 역할

        fun showTitle(){ // java의 static 메소드같은 역할
            println("제목 : $title")
            //n = 50 // error - 동반객체안에서 클래스의 인스턴스멤버는 사용불가
        }
    }

}



// 인터페이스를 구현할 때 ":" 키워드 사용(상속과 같음). 생성자호출 "()" 안씀(상속과 다름)
class Test : Clickable{
    override fun onClick() {
        println("Clicked")
        println()
    }
}

// 2. 인터페이스는 특별하게 다른점 없음
interface Clickable{
    // 추상메소드
    fun onClick()

}


// 1.
class AAA{
    var a:Int= 0

    fun show(){
        println("AAA클래스의 show() 영역")
        println()


    }// show()

    // 이너클래스를 객체로 만들어서 리턴해주는 기능메소드
    fun makeBBBInstance():BBB{
        return BBB()
    }

    // 이너클래스 [ 자바와 다르게 inner 라는 키워드 필요함 ]
    inner class BBB{
        fun show(){
            println("아웃터 클래스의 프로퍼티(멤버변수) a : $a") // 아웃터클래스(AAA class)의 프로퍼티(멤버변수)를 사용할 수 있음

            // 아웃터클래스의 멤버메소드도 사용해보기
            //AAA().show()
            this@AAA.show()
        }
    }/////////////////


}// AAA class

























