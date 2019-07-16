import io.restassured.RestAssured
import io.restassured.RestAssured.given
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Tests {

    @BeforeAll
    fun setUp() {
        RestAssured.baseURI = "http://localhost:8082"
    }

    @Test
    fun getNewOwnerTest() {
        given().get("/owners/new").then().statusCode(200)
    }

    @Test
    fun getOwnersListTest() {
        given().get("/owners").then().statusCode(200)
    }

    @Test
    fun findOwnerTest() {
        given().get("/owners/find").then().statusCode(200)
    }

}