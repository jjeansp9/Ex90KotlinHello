package com.jspstudio.ex90kotlinhello


fun main(){

    // 3. 연산자 특이점
    // 숫자타입들간의 연산은 자동형변환이 수행됨
    println(10+3.14)

    // 숫자타입이 아닌 자료형과는 연산이 안됨
    //println(10 + true) // error
    //println(10 + 'A') // error

    // 연산자중에 특별한 것은 없고, is 라는 연산자
    // 자료형을 체크하는 연산자
    // 통상적으로는 Any 타입일때 사용함
    var obj:Any

    obj= 10
    obj= 3.14

    if( obj is Int ) println("${obj}은(는) Int입니다") // obj가 Int라면, 실행

    class Person{
        var name:String= "name"
        var age:Int= 20
    }

    obj= Person() // java에서는 new 키워드 사용으로 만들지만 코틀린에서는 생략

    if(obj is Person){
        println("이름: ${obj.name} \n나이: ${obj.age}")
    }
    println()

    // is의 특이점 참인 영역 안에서는 그 클래스의
    // 멤버가 리스트업됨
    var obj2:Any
    obj2= Person()
    if(obj2 is Person){
        println("이름: ${obj2.name} \n나이: ${obj2.age}")
    }

    // 결론. java의 instanceof 라는 연산자와 비슷한 기능

    ////////////////////////////////////////////
    // 비트연산자 기호가 없어짐 [논리연산자 아님]
    //println(7|3) //error
    //println(7.or(3)) // OR연산 기능메소드
    println(7 or 3) // 윗줄과 같음 - OR연산 글씨
    println(7 and 3)
    println()

    ////////////////////////////////////////////

    // 4. 조건문.. [ if, when ] - switch 문법 없음
    // 4-1 if 표현식이라고 부름 [ if문 X ]

    // 차이점
    var str:String
    if(10>15){ // if문
        str= "aaa"
    }else{
        str= "bbb"
    }
    println("str : $str")

    // 자바의 3항연산자가 없어지고, 대신 if 표현식이 그 역할을 함
    str= if(10>5) "aaa" else "bbb" // if 표현식
    println("str : $str")

    str= if(10>15){ // 만약 여러줄이면 마지막 값이 결과값임
        println("참")
        "aaa"
        "Hello"
    }else{
        println("거짓")
        "bbb"
        "Nice"
    }
    println("$str")

    // 4-2 switch문법이 없고 when문법이 이를 대체함
    var h:Any

    var num:Int= 50

    h= 400

    when(h){
        10-> println("aaa")
        20-> println("bbb")
        "aaa"-> println("ssdfs")
        true-> println("hello")
        // 변수값과 비교가능
        num-> println("hello world") // h의 값이 num의 값과 같으면 실행
        // 2개이상의 조건을 묶을 수 있음
        30, 40-> println("ccc") // 30이거나 40이면 실행

        // switch문의 default 같은 역할
        else-> { // 여러줄일땐 중괄호 사용
            println("else1")
            println("else2")
        }
    } // when
    println()

    // when의 조건을 수식으로 지정할 수 있음
    h= 90
    when{ // 수식을 쓸땐 "()"를 사용안함
        //h>=90 && h<=100 -> println("a학점")
        h in 90..100 -> println("a학점") // h값이 90 과 100의 사이인경우 실행
        h>= 80 -> println("b학점")
        h>= 70 -> println("c학점")
        h>= 60 -> println("d학점")
        else -> println("f학점")

    }

    h= false
    when(h){
        is Int -> println("정수입니다")
        is Double -> println("실수입니다")
        is Boolean -> println("논리값입니다")
        else -> println("잘 모르겠습니다")
    }

    // when도 표현식이라고 부름
    h = 25
    var sss:String = when(h){
        10->{
            "aaa"
            "hhh" // 마지막값이 결과값
        }
        20->"bbb"
        25->"ccc"
        else-> "ddd"
    }
    println()

    // 5. 반복문 : for, while
    // while문은 사용법이 같음
    // for문은 문법이 완전 다름

    // 0부터 5까지 6번반복
    for(i in 0..5){ // 제어변수를 만드는 var키워드 없음
        println(i)
    }
    println()

    for(a in 3   ..     10){ // .. 양 옆에 띄어쓰기는 무시됨
        println(a)
    }
    println()

    // 마지막숫자 전까지 ..대신에 until을 사용
    for ( a in 0 until 10){ // 0 ~ 9
        println(a)
    }
    println()

    // 2씩 증가 ( step )
    for (i in 0 .. 10 step 2) println(i)
    println()

    // 값의 감소 ( downTo )
    for (i in 10 downTo 0 step 2) println(i)
    println()


    // ** '@' Label로 반복문의 종료영역 선택하기(잘 안씀) **
    for(y in 0..4){
        print("$y : ")
        for (x in 0..9){
            if(x==6) break // x에 대한 반복문 정지
            print("$x   ")
        }
        println()
    }
    println()

    KKK@ for(y in 0..4){
        print("$y : ")
        for (x in 0..9){
            if(x==6) break@KKK // KKK 라벨의 break
            print("$x   ")
        }
        println()
    }
    println()

    // 반복문에 대한 사용연습은 배열과 함께 추가로 소개




}


































