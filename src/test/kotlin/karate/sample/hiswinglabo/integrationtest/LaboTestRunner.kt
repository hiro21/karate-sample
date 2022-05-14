package karate.sample.hiswinglabo.integrationtest

import com.intuit.karate.Runner
import com.intuit.karate.core.MockServer
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.test.context.SpringBootTest

/**
 * reference
 * https://github.com/karatelabs/karate/tree/master/karate-demo/src/test/java/mock/micro
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LaboTestRunner {
    var server: MockServer? = null

    @BeforeAll
    fun beforeClass() {
        server = MockServer
            // .feature("classpath:mock/micro/cats-mock.feature")
            .feature("classpath:karate/sample/hiswinglabo/integrationtest/mock.feature")
            .arg("demoServerPort", null)
            .http(0).build()
    }

    @Test
    fun testMock() {
        // val results = Runner.path("classpath:mock/micro/cats.feature")
        val results = Runner.path("classpath:karate/sample/hiswinglabo/integrationtest/sample.feature")
            .karateEnv("mock")
            // .systemProperty("mock.cats.url", "http://localhost:" + server!!.port + "/cats")
            // .systemProperty("mock.cats.url", "http://localhost:" + server!!.port + "/labo")
            .systemProperty("mock.cats.url", "http://localhost:8080/labo")
            .parallel(1)
        assertEquals(results.errorMessages, results.failCount == 0)
    }

    companion object {
    }
}