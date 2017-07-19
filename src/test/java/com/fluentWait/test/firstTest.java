package com.fluentWait.test;

import com.fluentWait.framework.RestAssuredConfiguration;
import com.fluentWait.test.common.EndPoint;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

/**
 * Created by boris on 16.07.17.
 */
public class firstTest {
    @Test(groups = "demo")
    public void validateQu1eryParameter(){
        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
        given().spec(requestSpecification).get(EndPoint.GET_ALL).then().statusCode(HttpStatus.SC_OK).log().all();
        // Getting response
        Response response = given().spec(requestSpecification).get(EndPoint.GET_ALL);
        response.then().
                body("RestResponse.result.alpha2_code", hasItems("US", "DE", "GB"));
    }
}
