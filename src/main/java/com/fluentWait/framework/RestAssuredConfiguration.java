package com.fluentWait.framework;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;

/**
 * Created by boris on 16.07.17.
 */
public class RestAssuredConfiguration {

    @BeforeSuite(alwaysRun = true)
    public void configure() {
        RestAssured.baseURI = "http://services.groupkt.com/";
        RestAssured.basePath = "country/get";
    }

    public RequestSpecification getRequestSpecification() {
        return RestAssured.given().contentType(ContentType.JSON);
    }
}
