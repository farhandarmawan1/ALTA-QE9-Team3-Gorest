package starter.Gorest.StepDefiniitions.FeaturePostStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Gorest.FeaturePost.DeleteAPI;
import starter.Gorest.FeaturePost.JsonPlace.JsonSchema;

import java.io.File;

public class DeleteUserPost {
    @Steps
    DeleteAPI deleteAPI;

//    Delete valid user
    @Given("Delete single user with valid and existing parameter {int}")
    public void deleteSingleUserWithValidAndExistingParameterId(int id) {
        deleteAPI.deleteValidUser(id);
    }

    @When("Send delete single user post")
    public void sendDeleteSingleUser() {
        SerenityRest.when().delete(DeleteAPI.DELETE_USER_POST);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

//    Delete previously user
    @Given("Delete single user with previously {int}")
    public void deleteSingleUserWithPreviouslyId(int id) {
        deleteAPI.deleteValidPreUser(id);
    }

    @When("Send delete previously single user")
    public void sendDeletePreviouslySingleUser() {
        SerenityRest.when().delete(DeleteAPI.DELETE_USER_PREVIOUSLY);
    }

    @And("Validate delete user json schema invalid")
    public void validateDeleteUserJsonSchemaInvalid() {
        File jsonSchema = new File(JsonSchema.DELETE_SCHEMA_ERROR);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

//    Delete user without parameter
    @Given("Delete user without parameter id")
    public void deleteUserWithoutParameterId() {
        deleteAPI.deleteNoIdUser();
    }

    @When("Send delete single user without id post")
    public void sendDeleteSingleUserWithoutIdPost() {
        SerenityRest.when().delete(DeleteAPI.DELETE_USER_NOPARAMETER);
    }

//    Delete user invalid id
    @Given("Delete single user with invalid {string}")
    public void deleteSingleUserWithInvalid(String id) {
        deleteAPI.deleteInvalidUser(id);
    }
}
