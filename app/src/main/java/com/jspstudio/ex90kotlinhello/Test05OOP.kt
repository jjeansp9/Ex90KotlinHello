package com.jspstudio.ex90kotlinhello

fun main(){
    // 1. class 선언 및 객체생성
    // 객체 생성 [ new 키워드 없음 ]
    var obj:MyClass = MyClass()
    obj.show()

    // 별도의 파일로 class 설계 하고 객체 생성
    var obj2 = MyKotlinClass()
    obj2.show()

    // 2. 생성자
    // 코틀린의 생성자는 2가지종류가 있음 [ 주생성자, 보조생성자 ]

    // 2-1 주생성자
    var s = Simple()
    val s2 = Simple2(100, 200)
    //val s3 = Simple2() // error - overloading [ 주생성자는 오버로딩이 불가능 ]

    // 2-2 보조생성자 - overloading 이 가능한 생성자
    val ss= Simple3() // val ss:Simple3= Simple3() 와 동일
    val ss2= Simple3(50)

    // 2-3 주생성자 + 보조생성자
    val ssss= Simple4()
    val ssss2= Simple4(100) // 보조생성자로 overloading

    // 2-4 주생성자 constructor 키워드 생략
    val ssss3= Simple5()


}

// 2-4 참고로 주생성자의 constructor 키워드는 생략이 가능함
class Simple5{
    init {
        println("simple5 primary constructor")
        println()
    }
}

// 2-3
class Simple4 constructor(){
    init {
        println("simple4 init")
    }

    // 주생성자와 함게 보조생성자를 사용한다면
    // 보조생성자에서 반드시 명시적으로 부모생성자를 호출해야만 함
    constructor(num:Int): this(){
        println("simple4 num : $num")
    }
}


// 2-2 보조성생자만 있는 클래스
class Simple3{
    constructor(){
        println("simple3 secondary constructor")
        println()
    }
    // 보조생성자 오버로딩 , 파라미터에 곧바로 var,val 키워드를 붙여 멤버를 만들 수 있는것은 주생성자만 가능
    constructor(a:Int){
        println("$a")
        println()
    }

}

// 2-1.2 주 생성자에 파라미터 전달
// 파라미터에 var , val 키워드를 붙이면 파라미터면서 멤버변수까지 됨
class Simple2 constructor(num:Int, var num2:Int){

    // 멤버변수 위치에서 주 생성자의 매개변수를 바로 사용가능함
    var num3:Int = num

    init {
        println("num : $num")
        println("num2 : $num2")
        println()
    }
    fun show(){
        //println("show num : $num") // error - 생성자의 파라미터는 init{ } 영역에서만 인식 가능
        println("show num : $num2") // num2는 멤버변수여서 인식가능 - 파라미터란에 var 추가해서 가능
    }
}

// 2-1 주생성자 - 클래스명 옆에 constructor()를 붙임
class Simple constructor(){
    // 객체의 주생성자가 호출될 때 자동으로 초기화를 위해 실행되는 영역
    init {
        println("Simple primary contructor")
        println()
    }
}


// 1.
class MyClass{
    // 1) 멤버변수 - [ Property : 프로퍼티 ]라고 부름 - 반드시 초기화해야함
    var a:Int = 10



    // 2) 멤버함수 - [ Method : 메소드 ]
    fun show(){
        println("show : $a")
        println()
    }

}




























