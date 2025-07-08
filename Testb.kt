package com.example.myktest

import org.junit.Test
import org.junit.Assert.*

class Testb {
    //변수
    @Test
    fun value(){
        var a: Int = 123
        print(a)
        val b: Int = 456
        print(b)
        var c: Int? = null
        print(c)
    }
    //형변환
    @Test
    fun castingT(){
        var a: Int = 123
        var b: Long = a.toLong()
        var c: Double = a.toDouble()
        print(b)
        print(c)

    }
    //배열
    @Test
    fun testmy(){
        var intArr:Array<Int> = arrayOf(1,2,3,4,5)
        var intArr2= arrayOfNulls<Int>(5)
        var anyArr:Array<Any> = arrayOf(1,"2",3.0)
        print(intArr[0])
        print(intArr2[0])
        print(anyArr[0])

    }
    //함수
    @Test
    fun fTest(){
        print("성공"+add(1,2,3)+"\n")
    }
    fun add(a: Int, b:Int, c:Int):Int{
        return a+b+c;
    }
    //단일 표현식 함수
    fun fadd(a: Int, b:Int, c:Int):Int = a+b+c
    @Test
    fun addTest(){
        print("성공"+fadd(1,2,3)+"\n")
    }

    //조건문
    @Test
    fun condition(){
        var a = 4
        if(a>6){
            println(a)
        }else{
            print("exit")
        }
    }
    //데이터 타입 비교
    @Test
    fun tComparison(){
        var a: Any = "1"
        if(a is Int) {
            println("a는 Int 타입입니다.")
        }else{
            println("a는 Int 타입이 아닙니다.")
        }

    }
    //when문 switch랑 비슷
    @Test
    fun wTest(){
        exWhen(1)
    }
    fun exWhen(a: Any){
        var c =
        when(a){
            1 -> a
            "b" -> a
            else -> "else"

        }
        println(c)
    }

    //while
    @Test
    fun whTest(){
        var i: Int = 0
        while(i<10){
            println(i)
            i++
        }
    }
    //for
    @Test
    fun foTest(){
        for(i in 0..9){
            print(i)
        }
        println()
        for(i in 3 downTo 0){
            print(i)
        }
        println()
        for(i in 0..6 step 2){
            print(i)
        }
        println()
        for(i in 'a'..'z'){
            print(i)
        }
    }
    //흐름제어
    @Test
    fun flTest(){
        for(i in 1..10){
            if(i==3) break
            print(i)
        }
        println()
        for(i in 1..10){
            if(i==3) continue
            print(i)
        }


    }
    //라벨
    @Test
    fun lTest() {
        loop@ for (i in 1..10) {
            print("loop$i")
            for (j in 1..10) {
                print("no$j")
                if(i==3 && j==6)
                    break@loop
            }
        }

    }
    //클래스
    @Test
    fun cTest(){
        var a = myclass(1,2)
        a.myfun(2,3)
    }
    class myclass(var a:Int, val b:Int){
        fun myfun(a:Int, b:Int){
            println("$a, $b")
        }

    }
    //init 생성자와 구문 실행
    @Test
    fun iTest(){
        var a = myclass2(1,2)
    }
    class myclass2(var a:Int, val b:Int) {
        init {
            println("${this.a} ${this.b}")
        }

        fun myfun(a: Int, b: Int) {

        }
    }
    //contructor 보조생성자(생성자 오버로딩)
    @Test
    fun contTest(){
        var a = myClass3("aws");
        var b = myClass3("sla");
    }
    class myClass3(var name:String, val birth:Int){
        constructor(name: String): this(name,23)
        init{
            println("${this.name} ${this.birth}")
        }
    }
    //상속 open키워드 사용

    @Test
    fun oTest(){
        var a = Dog("aws", 23)
        var b = Animal("vcx", 13, "개")
        a.introduce()
        b.introduce()
    }
    open class Animal(var name: String, var age:Int, var type:String){
        open fun introduce(){
            println("저는 ${this.name}이고 ${this.age}살 ${this.type}입니다.")
        }
    }
    class Dog(var nam1: String, var age1: Int): Animal(nam1, age1, "강아지"){
        fun introduce1(){
            super.introduce()
        }
        override fun introduce(){
            println("override")
        }

    }
    //추상클래스
    @Test
    fun aTest(){
        var a = Rabbit()
        a.sniff()
        a.eat()
    }
    abstract class Animal2{
        abstract fun eat()
        fun sniff(){
            println("킁킁");
        }
    }
    class Rabbit: Animal2(){
        override fun eat() {
            println("당근을 먹습니다.")
        }
    }
    //인터페이스 코틀린은 자바랑 다르게 추상 함수 말고 일반 함수도
    //존재하지만 생성자는 없음
    //구현부가 있으면 open
    //구현부가 없으면 abstract
    @Test
    fun i1Test(){
        var a = Dog2("양")
        var b = Dog2("개")
        a.eat2()
        a.eat()
        a.run()
        b.run()
    }
    interface Runner{
        fun run()
    }
    interface Eater{
        fun eat(){
            println("먹다")
        }
    }
    class Dog2(var type1: String): Runner, Eater{

        override fun run(){
            println("${type1} 달리다")
        }
        override fun eat(){
            println("개같이 먹음")
        }
        fun eat2(){
            super.eat()
        }

    }
    //접근제한자는 public, private, protected가 존재하고 기본값은 public
    //고차함수 / 람다함수
    //고차함수 : 함수를 인자로 받아서 실행하는 함수
    //람다함수 : 함수를 변수처럼 사용` 익명함수라고도 불림. 이름이 없음
    //var 변수이름: (매개변수)-> 반환타입 = {매개변수 -> 실행코드}
    @Test
    fun main(){
        b(::a) //함수를 넘겨줄 때 ::사용
        var c: (String)->Unit = {s -> println(s)}//람다함수
        var d = {s: String -> println(s)}
        var e = {s: String -> s}
        var f ={
            println("xzcxc")
        }
        var g : (String)->Unit = {println(it)}
        c("zxc")
        d("sss")
        println(e("ccc"))
        f()
        g("qqq")
    }
    fun a(str: String): String{
        return str
    }
    //고차함수 fun 함수명(함수명:(매개변수타입)->반환타입){실행코드}
    fun b(funs:(String)->String){
        var c: String = funs("fd")
        println("$c")
    }


}
