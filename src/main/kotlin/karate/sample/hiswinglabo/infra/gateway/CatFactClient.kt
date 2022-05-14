package karate.sample.hiswinglabo.infra.gateway

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "cats", url = "\${catfat.url}")
interface CatFactClient {
    @GetMapping("/facts")
    fun fetch(): String
}