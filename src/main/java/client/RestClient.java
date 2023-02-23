package client;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RestClient {
    String baseUrl;

    public RestClient(String baseUrl){
        this.baseUrl = baseUrl;
    }

    public Response get(String path, Map<String, Object> params, Map<String, Object> headers, Object body) {
        RequestSpecification httpRequest = RestAssured.given()
                .log()
                .all(true);
        httpRequest.baseUri(baseUrl);
        httpRequest.header("Content-Type", "application/json");
        if (params != null) {
            httpRequest.params(params);
        }
        if (headers != null) {
            httpRequest.headers(headers);
        }
        if (body != null) {
            httpRequest.body(body);
        }

        Response response = httpRequest.get(path);
        response.then().log().body();
        return response;
    }

    public Response post(String path, Map<String, Object> params, Map<String, Object> headers, Object body) {
        RequestSpecification httpRequest = RestAssured.given()
                .log()
                .all(true);
        httpRequest.baseUri(baseUrl);
        httpRequest.header("Content-Type", "application/json");
        if (params != null) {
            httpRequest.queryParams(params);
        }
        if (headers != null) {
            httpRequest.headers(headers);
        }
        if (body != null) {
            httpRequest.body(body);
        }

        Response response = httpRequest.post(path);
        response.then().log().body();
        return response;
    }

    public Response put(String path, Map<String, Object> params, Map<String, Object> headers, Object body) {
        RequestSpecification httpRequest = RestAssured.given()
                .log()
                .all(true);
        httpRequest.baseUri(baseUrl);
        httpRequest.header("Content-Type", "application/json");
        if (params != null) {
            httpRequest.params(params);
        }
        if (headers != null) {
            httpRequest.headers(headers);
        }
        if (body != null) {
            httpRequest.body(body);
        }
        Response response = httpRequest.put(path);
        response.then().log().body();
        return response;
    }

    public Response delete(String path, Map<String, Object> params, Map<String, Object> headers, Object body) {
        RequestSpecification httpRequest = RestAssured.given()
                .log()
                .all(true);
        httpRequest.baseUri(baseUrl);
        httpRequest.header("Content-Type", "application/json");
        if (params != null) {
            httpRequest.params(params);
        }
        if (headers != null) {
            httpRequest.headers(headers);
        }
        if (body != null) {
            httpRequest.body(body);
        }
        Response response = httpRequest.delete(path);
        response.then().log().body();
        return response;
    }

    public Response patch(String path, Map<String, Object> params, Map<String, Object> headers, Object body)  {
        RequestSpecification httpRequest = RestAssured.given()
                .log()
                .all(true);
        httpRequest.baseUri(baseUrl);
        httpRequest.header("Content-Type", "application/json");
        if (params != null) {
            httpRequest.params(params);
        }
        if (headers != null) {
            httpRequest.headers(headers);
        }
        if (body != null) {
            httpRequest.body(body);
        }
        Response response = httpRequest.patch(path);
        response.then().log().body();
        return response;
    }
}
