package com.example.myktest

import kotlinx.coroutines.processNextEventInCurrentThread
import org.junit.Test
import org.junit.Assert.*

class Testb {
    //변수
    @Test
    fun value() {
        var a: Int = 123
        print(a)
        val b: Int = 456
        print(b)
        var c: Int? = null
        print(c)
    }

    //형변환
    @Test
    fun castingT() {
        var a: Int = 123
        var b: Long = a.toLong()
        var c: Double = a.toDouble()
        print(b)
        print(c)

    }

    //배열
    @Test
    fun testmy() {
        var intArr: Array<Int> = arrayOf(1, 2, 3, 4, 5)
        var intArr2 = arrayOfNulls<Int>(5)
        var anyArr: Array<Any> = arrayOf(1, "2", 3.0)
        print(intArr[0])
        print(intArr2[0])
        print(anyArr[0])

    }

    //함수
    @Test
    fun fTest() {
        print("성공" + add(1, 2, 3) + "\n")
    }

    fun add(a: Int, b: Int, c: Int): Int {
        return a + b + c;
    }

    //단일 표현식 함수
    fun fadd(a: Int, b: Int, c: Int): Int = a + b + c

    @Test
    fun addTest() {
        print("성공" + fadd(1, 2, 3) + "\n")
    }

    //조건문
    @Test
    fun condition() {
        var a = 4
        if (a > 6) {
            println(a)
        } else {
            print("exit")
        }
    }

    //데이터 타입 비교
    @Test
    fun tComparison() {
        var a: Any = "1"
        if (a is Int) {
            println("a는 Int 타입입니다.")
        } else {
            println("a는 Int 타입이 아닙니다.")
        }

    }

    //when문 switch랑 비슷
    @Test
    fun wTest() {
        exWhen(1)
    }

    fun exWhen(a: Any) {
        var c =
            when (a) {
                1 -> a
                "b" -> a
                else -> "else"

            }
        println(c)
    }

    //while
    @Test
    fun whTest() {
        var i: Int = 0
        while (i < 10) {
            println(i)
            i++
        }
    }

    //for
    @Test
    fun foTest() {
        for (i in 0..9) {
            print(i)
        }
        println()
        for (i in 3 downTo 0) {
            print(i)
        }
        println()
        for (i in 0..6 step 2) {
            print(i)
        }
        println()
        for (i in 'a'..'z') {
            print(i)
        }
    }

    //흐름제어
    @Test
    fun flTest() {
        for (i in 1..10) {
            if (i == 3) break
            print(i)
        }
        println()
        for (i in 1..10) {
            if (i == 3) continue
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
                if (i == 3 && j == 6)
                    break@loop
            }
        }

    }

    //클래스
    @Test
    fun cTest() {
        var a = myclass(1, 2)
        a.myfun(2, 3)
    }

    class myclass(var a: Int, val b: Int) {
        fun myfun(a: Int, b: Int) {
            println("$a, $b")
        }

    }

    //init 생성자와 구문 실행
    @Test
    fun iTest() {
        var a = myclass2(1, 2)
    }

    class myclass2(var a: Int, val b: Int) {
        init {
            println("${this.a} ${this.b}")
        }

        fun myfun(a: Int, b: Int) {

        }
    }

    //contructor 보조생성자(생성자 오버로딩)
    @Test
    fun contTest() {
        var a = myClass3("aws");
        var b = myClass3("sla");
    }

    class myClass3(var name: String, val birth: Int) {
        constructor(name: String) : this(name, 23)

        init {
            println("${this.name} ${this.birth}")
        }
    }
    //상속 open키워드 사용

    @Test
    fun oTest() {
        var a = Dog("aws", 23)
        var b = Animal("vcx", 13, "개")
        a.introduce()
        b.introduce()
    }

    open class Animal(var name: String, var age: Int, var type: String) {
        open fun introduce() {
            println("저는 ${this.name}이고 ${this.age}살 ${this.type}입니다.")
        }
    }

    class Dog(var nam1: String, var age1: Int) : Animal(nam1, age1, "강아지") {
        fun introduce1() {
            super.introduce()
        }

        override fun introduce() {
            println("override")
        }

    }

    //추상클래스
    @Test
    fun aTest() {
        var a = Rabbit()
        a.sniff()
        a.eat()
    }

    abstract class Animal2 {
        abstract fun eat()
        fun sniff() {
            println("킁킁");
        }
    }

    class Rabbit : Animal2() {
        override fun eat() {
            println("당근을 먹습니다.")
        }
    }

    //인터페이스 코틀린은 자바랑 다르게 추상 함수 말고 일반 함수도
    //존재하지만 생성자는 없음
    //구현부가 있으면 open
    //구현부가 없으면 abstract
    @Test
    fun i1Test() {
        var a = Dog2("양")
        var b = Dog2("개")
        a.eat2()
        a.eat()
        a.run()
        b.run()
    }

    interface Runner {
        fun run()
    }

    interface Eater {
        fun eat() {
            println("먹다")
        }
    }

    class Dog2(var type1: String) : Runner, Eater {

        override fun run() {
            println("${type1} 달리다")
        }

        override fun eat() {
            println("개같이 먹음")
        }

        fun eat2() {
            super.eat()
        }

    }

    //접근제한자는 public, private, protected가 존재하고 기본값은 public
    //고차함수 / 람다함수
    //고차함수 : 함수를 인자로 받아서 실행하는 함수
    //람다함수 : 함수를 변수처럼 사용` 익명함수라고도 불림. 이름이 없음
    //var 변수이름: (매개변수)-> 반환타입 = {매개변수 -> 실행코드}
    @Test
    fun main() {
        b(::a) //함수를 넘겨줄 때 ::사용
        var c: (String) -> Unit = { s -> println(s) }//람다함수
        var d = { s: String -> println(s) }
        var e = { s: String -> s }
        var f = {
            println("xzcxc")
        }
        var g: (String) -> Unit = { println(it) }
        c("zxc")
        d("sss")
        println(e("ccc"))
        f()
        g("qqq")
    }

    fun a(str: String): String {
        return str
    }

    //고차함수 fun 함수명(함수명:(매개변수타입)->반환타입){실행코드}
    fun b(funs: (String) -> String) {
        var c: String = funs("fd")
        println("$c")
    }


    //스코프함수
    //함수형 언어를 좀 더 편리하게 사용할 수 있도록 하는 기본 함수
    //apply = 객체 생성과 동시에 속성을 초기화, this생략
    @Test
    fun applyTest() {
        var a = Book("a", 20000)
        a.apply {
            name = "apply $name"
            dc()
        }
        a.printName()
    }

    class Book(var name: String, var price: Int) {
        fun dc() {
            price -= 2000
        }

        fun printName() {
            println("$name $price")
        }
    }

    //run
    //apply와 비슷하지만 마지막 구문에 있는 값을 반환
    @Test
    fun rTest() {
        var a = Book("a", 20000)
        var b = a.run {
            name = "apply $name"
            dc()
            "cas"

        }
        print(b)
    }

    class Book1(var name: String, var price: Int) {
        fun dc() {
            price -= 2000
        }

        fun printName() {
            println("$name $price")
        }

    }

    //with
    //run이랑 똑같지만 사용법만 다름
    @Test
    fun wiTest() {
        var a = Book2("a", 20000)
        var b = with(a) {
            name = "apply $name"
            dc()
            "cas"
        }
        print(b)
    }

    class Book2(var name: String, var price: Int) {
        fun dc() {
            price -= 2000
        }

        fun printName() {
            println("$name $price")

        }
    }

    //let/also
    //apply = also
    //run = let
    //let과 also의 공통된 차이점은 it 키워드 사용
    //같은 이유 이름 변수로 혼동이 올 수 있기 때문
    @Test
    fun ltest() {
        var price = 5000
        var a = Book("a", 20000)
        a.let {
            println(it.price)
        }
        a.also {
            println(it.price)

        }
    }

    class Book3(var name: String, var price: Int) {

    }

    //Object
    @Test
    fun obTest() {
        Counter.countUp()
        Counter.countUp()
        println(Counter.count)
        Counter.clear()
        println(Counter.count)
        println(Food.a)
        Food.create()
        println(Food.a)
    }

    //객체가 하나만 필요해서 사용하는 경우 -> 싱글통
    //메모리위치가 고정
    //class 안에도 만들 수 있다. 키워드는 companion object
    object Counter {
        var count = 0
        fun countUp() {
            count++
        }

        fun clear() {
            count = 0
        }
    }

    class Food() {
        companion object {
            var a = 1
            fun create() {
                a++
            }

            val b = "cc"

        }
    }
    //observer 옵저버 패턴
    //listner, callback이라고 부른다
    //이벤트 발생을 감시해서 발생시에 기능이 호출되도록

    @Test
    fun liTest() {
        EventPrinter().start()
    }

    interface EventListener {
        fun onEvent(count: Int)
    }

    class Counter2(var listener: EventListener) {
        fun count() {
            for (i in 1..10) {
                if (i % 5 == 0) listener.onEvent(i)

            }
        }
    }

    class EventPrinter {
        //익명클래스로 정의 방법
        fun start() {
            Counter2(object : EventListener {
                override fun onEvent(count: Int) {
                    println(count)
                }
            }).count()
        }
    }

    //이벤트함수
//        override fun onEvent(count: Int) {
//            println("${count}-")
//        }
//        fun start(){
//            val counter = Couter2(this)
//            counter.count()
//        }
    //다형성 as
    //as는 클래스를 casting하는 역할을 한다
    //casting이란 하나의 클래스를 다른 클래스로 변환하는 것
    @Test
    fun CTest() {
        var a = Drink()
        a.drink()
        var b: Drink = Cola()
        b.drink()
        var s = Cola()
        s.drink()
        //일시적 캐스팅
        if (b is Cola) {
            b.washDishes()
        }
        var c = b as Cola
        c.washDishes()
        //명시적 캐스팅
        var d = b as Cola
        d.washDishes()
    }

    class Cola : Drink() {
        var type = "콜라"
        override fun drink() {
            println("${name}을 먹는다")
        }

        fun washDishes() {
            println("${type}을 세탁한다")
        }

    }

    open class Drink {
        var name = "음료"
        open fun drink() {
            println("${name}을 마신다")
        }
    }
    //Generic
    //타입을 미리 정하지 않고 나중에 정함

    @Test
    fun genTest() {
        UsingGeneric(A()).doShoot()
        UsingGeneric(B()).doShoot()

        funGerneric(A())
        funGerneric(B())
    }

    //A상속받은 객체만 타입으로 지정
    fun <T : A> funGerneric(t: T) {
        t.shoot()
    }

    open class A {
        open fun shoot() {
            println("A shoot")
        }
    }

    class B : A() {
        override fun shoot() {
            println("B shoot")
        }
    }

    //마찬가지
    class UsingGeneric<T : A>(var t: T) {
        fun doShoot() {
            t.shoot()
        }
    }

    //Collection List
    //리스트에는 ListOf, mutableListOf가 있다
    //listOf는 정적 mutableListOf는 동적
    @Test
    fun listTest() {
        var a = listOf<Int>(1, 2, 3, 4, 5)
        var b = mutableListOf<Int>(1, 2, 3, 4, 5)
        b.add(6)
        println(a)
        println(b)
    }

    //String function
    @Test
    fun stringTest() {
        var test = "a.b.c.d"
        println(test.length)
        //String문자를 .을 기준으로 배열값으로 만든다.
        var spl = test.split(".")
        println(spl)
        //2번째부터 6번째까지 출력 .포함해서
        println(test.substring(2..6))
        //배열값들을 string으로 출력
        println(spl.joinToString())
        //-로 나눠서 출력 string으로
        println(spl.joinToString("-"))
        //문자열이 a.으로 시작하면 true
        println(test.startsWith("a."))
        //문자열이 .d로 끝나면 true
        println(test.endsWith(".d"))
        //b.c를 포함하면 true
        println(test.contains("b.c"))

    }

    //null처리
    //자바에서는 보통 if(변수==null)형식으로 null값처리
    //?앞의 변수가 null이 아니면 뒤에 코드를 실행하고 null이면 null을 반환
    //!! 이 변수는 null이 아니니 무조건 실행해라
    @Test
    fun nuTest() {
        val a = listOf<String?>("awd", null, "zxc")
        val c = mutableListOf<String>()
        val e = mutableListOf<String>()
        val f = mutableListOf<String>()
        for (b in a) {
            //b가 null이라면 let구문을 실행하지 않음
            b?.let { c.add(it) }

            //b가 null이면 default값이 대신 추가
            //?:는 엘비스 연산자이다
            //왼쪽값이 null이면 오른쪽값을 사용
            e.add(b ?: "default")
        }

    }

    //infix
    //함수를 연산자처럼 사용한다
    @Test
    fun infTest() {
        println("awd" strSum 1)
        println("awd".strSum(2))

        println(3 intSum 4)
        println(3.intSum(4))
    }

    //infix fun(this에 해당되는 타입).함수이름(인자이름:타입): 반환 = 구문
    infix fun String.strSum(x: Int): String = this + x
    infix fun Int.intSum(x: Int): Int = this + x


    //Data클래스
    //클래스에 has(). equals(), toString(), copy(), componentX()를 자동으로 구현해주는 클래스
    // 'User'라는 이름의 데이터 클래스 선언
    data class User(val name: String, val age: Int)
    @Test
    fun maain() {
        val user1 = User("홍길동", 25)
        val user2 = User("홍길동", 25)
        val user3 = user1.copy(age = 30)

        // 1. equals(): 내용 비교
        // user1과 user2는 내용이 같으므로 true가 나옵니다.
        println("내용 비교: ${user1 == user2}") // 결과: 내용 비교: true

        // 2. toString(): 읽기 좋은 형태로 출력
        // 객체의 프로퍼티를 보기 좋게 출력합니다.
        println("객체 출력: $user1") // 결과: 객체 출력: User(name=홍길동, age=25)

        // 3. copy(): 객체 복사 및 일부 값 변경
        // user1을 복사하면서 나이만 30으로 변경합니다.
        println("복사 후 수정: $user3") // 결과: 복사 후 수정: User(name=홍길동, age=30)

        // 4. 구조 분해 할당 (Destructuring Declaration)
        // 객체의 프로퍼티를 각각의 변수에 나누어 담습니다.
        val (name, age) = user1
        println("이름: $name, 나이: $age") // 결과: 이름: 홍길동, 나이: 25
    }

    //enum클래스
    //열거형은 서로 관련된 상수들을 모아놓은 특별한 타입
    @Test
    fun enTest() {
        var a = St.A
        println(a)
        println(a.msg)
        println(a.isA())
    }

    enum class St(val msg: String) {
        A("a"),
        B("b"),
        C("c");

        fun isA() = this == St.A
    }

    //Map 컬렉션
    @Test
    fun mTest(){
        var a: MutableMap<Int, String> = mutableMapOf()
        a[1] = "a"
        a[2]= "b"
        for(i in a){
            println("${i.key} ${i.value}")
        }
        a.remove(1)
        println(a)
        println(a[2])
    }
    //lateinit
    //기본 자료형을 제외하고 객체 생성시 초기화를 하지 않고 변수 선언만
    @Test
    fun laTest(){
        var t = a()
        println(t.test())
        t.a = "zxc"
        println(t.test())
    }
    class a {
        lateinit var a: String
        fun test(): String{
            //a가 초기화됐는지 체크
            if(::a.isInitialized){
                return a
            }else{
                return "null"
            }
        }
    }
    //lazy
    @Test
    fun asmain() {
        val num: Int by lazy {
            println("초기화")
            7
        }
        println("start")
        println(num)
        println(num)
    }
}


