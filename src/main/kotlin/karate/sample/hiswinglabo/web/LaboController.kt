package karate.sample.hiswinglabo.web

import karate.sample.hiswinglabo.infra.gateway.CatFactClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LaboController(
    private val client: CatFactClient
) {
    @GetMapping("/labo")
    fun get(): String {
        try {
            val result = client.fetch()
            return result
        } catch (e: Exception) {
            println(e.stackTrace)
            throw e
        }
    }
}