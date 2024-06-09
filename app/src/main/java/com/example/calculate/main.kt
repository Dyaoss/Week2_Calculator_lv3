package com.example.calculate

fun main() {
    println("첫번째 숫자를 입력하세요.")
    print("-> ")
    val num1 = readln().toDouble()

    println("연산자를 입력해주세요.(+ -> 더하기, - -> 빼기, x -> 곱하기, / -> 나누기)")
    print("-> ")
    var op = readln()


    println("두번째 숫자를 입력하세요.")
    print("-> ")
    val num2 = readln().toDouble()

    val operator = when (op) {
        "+" -> AddOperator()
        "-" -> SubstractOperator()
        "x" -> MultiplyOperator()
        "/" -> DivideOperator()
        else -> {
            println("잘못된 연산자입니다!")
            return
        }
    }

    val calculate = Cal()
    val result = calculate.operation(operator, num1, num2)
    println("$num1 ${op} $num2 = ${result}")
}

abstract class Operator {
    abstract fun calculate(num1: Double, num2: Double): Double
}

class Cal() {
    fun operation(operator: Operator, num1: Double, num2: Double): Double =
        operator.calculate(num1, num2)
}

class AddOperator() : Operator() {
    override fun calculate(num1: Double, num2: Double): Double = (num1 + num2)
}

class SubstractOperator() : Operator() {
    override fun calculate(num1: Double, num2: Double): Double = (num1 - num2)
}

class MultiplyOperator() : Operator() {
    override fun calculate(num1: Double, num2: Double): Double = (num1 * num2)
}

class DivideOperator() : Operator() {
    override fun calculate(num1: Double, num2: Double): Double = (num1 / num2)
}