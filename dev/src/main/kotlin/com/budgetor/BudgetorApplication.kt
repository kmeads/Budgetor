package com.budgetor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BudgetorApplication

fun main(args: Array<String>) {
	runApplication<BudgetorApplication>(*args)
}
