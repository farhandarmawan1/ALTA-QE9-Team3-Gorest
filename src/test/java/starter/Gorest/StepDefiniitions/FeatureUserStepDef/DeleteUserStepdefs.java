package starter.Gorest.StepDefiniitions.FeatureUserStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Gorest.GorestAPI;
import starter.Gorest.Utils.Constant;

import java.io.File;

public class DeleteUserStepdefs {
    @Steps
    GorestAPI gorestAPI;
    @Given("Delete user id registered valid parameter with auth token")
    public void deleteUserIdIdRegisteredValidParameterWithAuthToken() {
        Response response = SerenityRest.get("https://gorest.co.in/public/v2/users/");
        JsonPath jsonPath= response.jsonPath();
        int id = jsonPath.getInt("[0]['id']");
        gorestAPI.setDeleteSingleUser(id);
    }

    @When("Send delete user parameter")
    public void sendDeleteUserParameter() {
        SerenityRest.when().delete(gorestAPI.DELETE_SINGLE_USER);
    }

    @Then("Status code should be {int} No content")
    public void statusCodeShouldBeNoContent(int ok) {SerenityRest.then().statusCode(ok);
    }

    @Given("Delete user id registered without auth token")
    public void deleteUserIdIdRegisteredWithAuthToken() {
        Response response = SerenityRest.get("https://gorest.co.in/public/v2/users/");
        JsonPath jsonPath= response.jsonPath();
        int id = jsonPath.getInt("[0]['id']");
        gorestAPI.setDeleteSingleUser2(id);
    }

    @And("Validate delete new user resources json schema")
    public void validateDeleteNewUserResourcesJsonSchema() {
        File jsonSchemaListUser = new File(Constant.JSON_SCHEMA_USER +"CreateUserNoAuthJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));
    }

    @Given("Delete user id {int} registered  with auth token")
    public void deleteUserIdRegisteredWithAuthToken(int id) {
        gorestAPI.setDeleteSingleUser(id);
    }

    @And("Validate delete new user not found resources json schema")
    public void validateDeleteNewUserNotFoundResourcesJsonSchema() {
        File jsonSchemaListUser = new File(Constant.JSON_SCHEMA_USER +"SingleUserUnregisterJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));
    }
}
