package karate.sample.hiswinglabo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class HiswinglaboApplication

fun main(args: Array<String>) {
	runApplication<HiswinglaboApplication>(*args)
}
