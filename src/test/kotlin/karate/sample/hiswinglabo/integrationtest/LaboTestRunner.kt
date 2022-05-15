package karate.sample.hiswinglabo.integrationtest

import com.intuit.karate.core.MockServer
import com.intuit.karate.junit5.Karate
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
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
            .feature("classpath:karate/sample/hiswinglabo/integrationtest/mock.feature")
            .arg("demoServerPort", null)
            .http(8089).build()
    }

    @AfterAll
    fun after() {
        server?.stop()
    }


    @Karate.Test
    fun karateTestRun(): Karate {
        return Karate.run("classpath:karate/sample/hiswinglabo/integrationtest/sample.feature")
            .karateEnv("mock")
            .systemProperty("mock.cats.url", "http://localhost:8080/labo")
    }
}