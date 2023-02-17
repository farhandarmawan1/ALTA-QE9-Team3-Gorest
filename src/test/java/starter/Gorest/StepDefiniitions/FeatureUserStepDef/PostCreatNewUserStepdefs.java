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
    }

    @Then("Status code should be {int} Unauthorized")
    public void statusCodeShouldBeUnauthorized(int arg0) {
    }

    @And("Respons body should be message {string}")
    public void responsBodyShouldBeMessage(String arg0) {
    }

    @And("Validate post create new user resources json schema without auth token")
    public void validatePostCreateNewUserResourcesJsonSchemaWithoutAuthToken() {
    }

    @Given("Post create new user valid parameter and empty name json with auth token")
    public void postCreateNewUserValidParameterAndEmptyNameJsonWithAuthToken() {
    }

    @Then("Status code should be {int} Unprocessable Entity")
    public void statusCodeShouldBeUnprocessableEntity(int arg0) {
    }

    @And("Respons body should be field {string} message {string}")
    public void responsBodyShouldBeFieldMessage(String arg0, String arg1) {
    }
}
