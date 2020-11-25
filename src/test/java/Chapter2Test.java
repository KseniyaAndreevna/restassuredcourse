import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Chapter2Test {
    /**
     * Checking the Response Status Code
     */
    @Test
    public void requestUsZipCode90210_checkStatusCode_expectHttp200() {

        given().
        when().
            get("http://zippopotam.us/us/90210").
        then().
            assertThat().statusCode(200);
    }

    /**
     * Checking the Response Content Type
     */
    @Test
    public void requestUsZipCode90210_checkContentType_expectApplicationJson() {
        given().
        when().
            get("http://zippopotam.us/us/90210").
        then().
            assertThat().contentType(ContentType.JSON);
        //contentType("application/json"); //also works
    }

    /**
     * Logging Request and Response Details
     */
    @Test
    public void requestUsZipCode90210_logRequestAndResponseDetails() {
        given().
            log().all(). //this tells REST Assured to write everything there is to
                         // know about the API request to the standard output.
        when().
            get("http://zippopotam.us/us/90210").
        then().
            log().body();  //this tells REST Assured to log the contents of the
                           // response body to the standard output
    }

    /**
     * Checking the Response Body
     * https://testautomationu.applitools.com/automating-your-api-tests-with-rest-assured/chapter2.html
     * 5:28 minute
     */
}
