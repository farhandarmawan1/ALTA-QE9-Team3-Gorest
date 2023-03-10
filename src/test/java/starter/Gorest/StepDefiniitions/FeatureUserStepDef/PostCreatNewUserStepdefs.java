package starter.Gorest.StepDefiniitions.FeatureUserStepDef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ResponseBody;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.Gorest.GorestAPI;
import starter.Gorest.GorestResponses;
import starter.Gorest.Utils.Constant;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static starter.Gorest.GorestAPI.TOKEN;

public class PostCreatNewUserStepdefs {
    @Steps
    GorestAPI gorestAPI;
    @Given("Post create new user valid paramater and json with auth token")
    public void postCreateNewUserValidParamaterAndJsonWithAuthToken() {
        gorestAPI.setPostCreateUser("users");
    }

    @When("Send post create new user parameter")
    public void sendPostCreateNewUserParameter() {
        SerenityRest.when().post(gorestAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then()
                .statusCode(created);
    }

    @And("Respons body should be name {string}, gender {string} and Status {string}")
    public void responsBodyShouldBeNameEmailGenderAndStatus(String name, String gender, String status) {
        SerenityRest.then()
                .body(GorestResponses.NAME,equalTo(name))
                .body(GorestResponses.GENDER,equalTo(gender))
                .body(GorestResponses.STATUS,equalTo(status));
    }

    @And("Validate post create new user resources json schema")
    public void validatePostCreateNewUserResourcesJsonSchema() {
        File jsonSchemaListUser = new File(Constant.JSON_SCHEMA_USER +"CreateUserJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));
    }

    @Given("Post create new user valid parameter and json without auth token")
    public void postCreateNewUserValidParameterAndJsonWithoutAuthToken() {
     gorestAPI.setPostCreateUserNoAuth("users");
    }

    @Then("Status code should be {int} Unauthorized")
    public void statusCodeShouldBeUnauthorized(int unauthorized) { SerenityRest.then()
            .statusCode(unauthorized);
    }

    @And("Respons body should be message {string}")
    public void responsBodyShouldBeMessage(String message) {
        SerenityRest.then()
            .body(GorestResponses.MESSAGE,equalTo(message));
    }

    @And("Validate post create new user resources json schema without auth token")
    public void validatePostCreateNewUserResourcesJsonSchemaWithoutAuthToken() {
        File jsonSchemaListUser = new File(Constant.JSON_SCHEMA_USER +"CreateUserNoAuthJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));
    }

    @Given("Post create new user valid parameter and empty name json with auth token")
    public void postCreateNewUserValidParameterAndEmptyNameJsonWithAuthToken() {
        gorestAPI.setPostCreateUserNoName("users");
    }

    @Then("Status code should be {int} Unprocessable Entity")
    public void statusCodeShouldBeUnprocessableEntity(int unprocessable) {SerenityRest.then()
            .statusCode(unprocessable);
    }

    @And("Validate post create new user empty name resources json schema")
    public void validatePostCreateNewUserEmptyNameResourcesJsonSchema() {
        File jsonSchemaListUser = new File(Constant.JSON_SCHEMA_USER +"CreateUserNoNameJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));
    }

    @Given("Post create new user valid parameter and empty email json with auth token")
    public void postCreateNewUserValidParameterAndEmptyEmailJsonWithAuthToken() {
        gorestAPI.setPostCreateUserNoEmail("users");
    }

    @And("Respons body should be field {string} message {string}")
    public void responsBodyShouldBeFieldMessageCanTBeBlank(String email, String message1) {
        SerenityRest.then()
                .body(GorestResponses.NAME2,equalTo(email))
                .body(GorestResponses.MESSAGE2,equalTo(message1));
    }

    @And("Validate post create new user empty email resources json schema")
    public void validatePostCreateNewUserEmpetyEmailResourcesJsonSchema() {
        File jsonSchemaListUser = new File(Constant.JSON_SCHEMA_USER +"CreateUserNoNameJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));
    }

    @Given("Post create new user valid parameter and empty gender json with auth token")
    public void postCreateNewUserValidParameterAndEmptyGenderJsonWithAuthToken() {
        gorestAPI.setPostCreateUserNoGender("users");
    }

    @And("Validate post create new user empty gender resources json schema")
    public void validatePostCreateNewUserEmptyGenderResourcesJsonSchema() {
        File jsonSchemaListUser = new File(Constant.JSON_SCHEMA_USER +"CreateUserNoNameJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));
    }

    @Given("Post create new user valid parameter and empty status json with auth token")
    public void postCreateNewUserValidParameterAndEmptyStatusJsonWithAuthToken() {
        gorestAPI.setPostCreateUserNostatus("users");
    }

    @And("Validate post create new user empty status resources json schema")
    public void validatePostCreateNewUserEmptyStatusResourcesJsonSchema() {
        File jsonSchemaListUser = new File(Constant.JSON_SCHEMA_USER +"CreateUserNoNameJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));
    }

    @Given("Post create new user invalid parameter {string} with auth token")
    public void postCreateNewUserInvalidParameterWithAuthToken(String users) {
        gorestAPI.setPostCreateUser(users);
    }

    @Given("Post create new user valid paramater and json with email registered")
    public void postCreateNewUserValidParamaterAndJsonWithEmailRegistered() {
        SerenityRest.given().header("Authorization","Bearer "+TOKEN)
                .contentType("multipart/form-data")
                .multiPart("name", "ALTA GOREST")
                .multiPart("email", "embranthiri_bhargavi@murazik.io")
                .multiPart("gender", "female")
                .multiPart("status", "active");
    }

    @And("Validate post create new user email registered resources json schema")
    public void validatePostCreateNewUserEmailRegisteredResourcesJsonSchema() {
        File jsonSchemaListUser = new File(Constant.JSON_SCHEMA_USER +"CreateUserNoNameJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));
    }

    @When("Send post create new userr parameter")
    public void sendPostCreateNewUserrParameter() {
        SerenityRest.when().post(gorestAPI.USERS);
    }
}
