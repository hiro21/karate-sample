package karate.sample.hiswinglabo.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LaboController {
    @GetMapping("/labo")
    fun get(): String {
        return "ok"
    }
}