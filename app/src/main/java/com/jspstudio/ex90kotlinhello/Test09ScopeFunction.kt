package com.jspstudio.ex90kotlinhello

fun main(){
    // Scope function : apply, let, run, also .... with

    // 어떤 객체의 멤버사용을 여러개 하고 싶을때
    val crew = Crew()
    crew.name = "sam"
    crew.age = 20
    crew.address = "seoul"
    crew.show()

    // 한 객체의 멤버들을 접근할때마다 객체명 쓰는게 불편
    // 그래서 등장한 scope function
    var crew2 = Crew()
    crew2.apply {
        // 이 영역 안에서는 this 키워드가 crew2임. this 키워드는 생략가능
        name= "kim"
        age= 23
        address= "busan"
        show()
    }

    // 위처럼 영역을 묶어서 한 객체의 멤버들을 사용하게 하여
    // 개발자가 다른 객체의 멤버를 사용하는 실수를 줄여주는 문법

    // 1) 영역안에서 this 키워드로 본인을 참조하는 scope : apply, run
    // 2) 영역안에서 it 키워드로 본인을 참조하는 scope : let, also

    val crew3 = Crew()
    crew3.apply {
        name= "luna"
        age= 26
        address= "newyork"
        show()
        // 리턴값이 this 객체임
    }

    val crew4 = Crew()
    crew4.let {
        // it 키워드는 생략불가
        it.name = "hong"
        it.age = 21
        it.address = "dajeon"
        it.show()
    }



}

class Crew{
    var name:String? = null
    var age:Int? = null
    var address:String? = null

    fun show(){
        println("$name : $age - $address")
    }

}



















