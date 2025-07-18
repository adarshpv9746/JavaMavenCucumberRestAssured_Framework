package cucumber.stepdefintions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.sql.SQLOutput;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Products {

    public RequestSpecification httpRequest;
    public Response response;
    public int ResponseCode;
    public ResponseBody body;
    public JsonPath jsonpath;
    public JSONObject requestParams;


    @Given("I hit URL of the get products API endpoint")
    public void i_hit_url_of_the_get_products_api_endpoint(){
        RestAssured.baseURI = "https://fakestoreapi.com/";
    }

    @When("I pass the URL of products in the API")
    public void i_pass_the_url_of_products_in_the_api() {
        httpRequest = given();
        response = httpRequest.get("products");
    }
    @Then("I receive the response code as {int}")
    public void i_receive_the_response_code_as(Integer int1) {
        ResponseCode = response.getStatusCode();
        assertEquals(ResponseCode, 200);
    }

    @Then("I Verify that the rate of the first product is {}")
    public void i_verify_that_the_rate_of_the_first_product_is(String expectedRate) {
        body = response.getBody();

        //convert response body to string
        String responseBody = body.asString();

        //JSON representation of the Response Body
        jsonpath = response.jsonPath();

        String actualRate = jsonpath.getJsonObject("rating[0].rate").toString();
        assertEquals(expectedRate, actualRate);
    }

    @Given("I hit URL of the post products API endpoint")
    public void iHitURLOfThePostProductsAPIEndpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
        httpRequest = given();
    }

    @And("I pass the request body of the product title {}")
    public void iPassTheRequestBodyOfTheProductTitle(String product) {

        //generating json body
        requestParams = new JSONObject();
        requestParams.put("title",product);
        requestParams.put("price",13.5);
        requestParams.put("description","lorem ipsum set");
        requestParams.put("image","https://i.pravatar.cc");
        requestParams.put("category","electronic");
        httpRequest.body(requestParams.toJSONString());
        response = httpRequest.post("products");
        body = response.getBody();
        ResponseCode = response.getStatusCode();
        System.out.println(ResponseCode);
        assertEquals(ResponseCode, 200);
        System.out.println(body.asString());
    }

    @Then("I receive the response body with ID as {}")
    public void iReceiveTheResponseBodyWithIDAs(String ID) {
        jsonpath = response.jsonPath();
        String ActualID = jsonpath.getJsonObject("id").toString();
        assertEquals(ID, ActualID);
    }

    @Given("I hit URL of the put products API endpoint")
    public void iHitURLOfThePutProductsAPIEndpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
    }

    @When("I pass the URL of products in the API with {}")
    public void iPassTheURLOfProductsInTheAPIWith(String ProdNum) {
        httpRequest = given();
        //generating json body
        requestParams = new JSONObject();
        requestParams.put("title","Test Tittle");
        requestParams.put("price",13.5);
        requestParams.put("description","lorem ipsum set");
        requestParams.put("image","https://i.pravatar.cc");
        requestParams.put("category","electronic");
        httpRequest.body(requestParams.toJSONString());
        response = httpRequest.put("products/"+ProdNum);
        body = response.getBody();
        System.out.println(response.statusCode());
        System.out.println(body.asString());

    }

    @Given("I hit URL of the delete products API endpoint")
    public void iHitURLOfTheDeleteProductsAPIEndpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
    }

    @When("I pass the URL of products to be deleted in the API with {}")
    public void iPassTheURLOfProductsToBeDeletedInTheAPIWith(String ID) {
        httpRequest = given();
        requestParams =  new JSONObject();
        requestParams.put("title","Test Tittle");
        requestParams.put("price",13.5);
        requestParams.put("description","lorem ipsum set");
        requestParams.put("image","https://i.pravatar.cc");
        requestParams.put("category","electronic");
        response = httpRequest.delete("products/"+ID);
        body = response.getBody();
        ResponseCode = response.statusCode();
        System.out.println(ResponseCode);
        System.out.println(body.asString());
    }
}
