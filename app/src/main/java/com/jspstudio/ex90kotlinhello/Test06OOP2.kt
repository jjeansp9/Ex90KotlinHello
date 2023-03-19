package com.jspstudio.ex90kotlinhello

fun main(){
    // 코틀린의 class 상속
    val obj:Second = Second()
    obj.a = 100 // 상속받은 멤버을 내것인양 사용
    obj.b = 200
    obj.show()
    println()

    // 업캐스팅 : 부모참조변수로 자식객체 참조가 가능하다
    var f:First = Second()
    f.show() // 자식객체의 오버라이드 메소드 사용가능
    //f.aaa() // 참조는 되지만 자식고유의 기능사용 불가능
    println()

    // 자식참조변수를 만들어야만 자식객체 고유기능 사용 가능함
    //var s:Second = f // error : 자식참조변수에 부모객체를 줬다고 오인함
    var s:Second = f as Second // as연산자 : 형변환 연산자 [ 다운캐스팅 ]
    s.aaa()
    s.show()
    println()
    println("========================================")

    // 상속에 대한 마무리 연습
    // [ 일반, 학생, 교수, 근로학생 ] 클래스 설계
    var p= Person("sam", 20)
    p.show()
    println()

    val stu= Student("robin", 22, "android")
    stu.show()
    println()

    val pro= Professor("kim", 40, "mobile")
    pro.show()
    println()

    val alba= AlbaStudent("hong", 27, "ios", "pc management")
    alba.show()
    println()
}

// First를 상속받을 클래스 [ 상속키워드 : extends 대신에 ":"를 사용 ]
// 반드시 상속해주는 클래스명 옆에 ()를 통해 생성자를 호출해줘야 함
class Second:First(){
    var b:Int = 20

    // 상속받은 show()메소드의 기능이 맘에들지 않아
    // 새로 만들어내는 기술 : Method Override
    // 코틀린은 명시적으로 오버라이드 메소드임을 표기해야만 함
    // 오버라이드할 메소드가 open 되어 있어야만 오버라이드 가능함
    override fun show(){
        //println("a : $a") // 부모의 property
        // 부모의 멤버출력은 부모의 기능을 이용하는것을 권장
        super.show()
        println("b : $b")
    }

    fun aaa(){
        println("Second aaa method...")
    }
}

// 상속해줄 부모클래스 - 상속해주는 클래스는 반드시 open 키워드가 필요함
open class First(){
    var a:Int = 10

    // 상속해줄 Second class의 메소드를 오버라이드 하기위해 open 필요
    open fun show(){
        println("First a: $a")
    }
}



















