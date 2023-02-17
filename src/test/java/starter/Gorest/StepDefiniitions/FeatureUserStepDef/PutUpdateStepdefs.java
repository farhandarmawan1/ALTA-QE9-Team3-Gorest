package starter.Gorest.StepDefiniitions.FeatureUserStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Gorest.GorestAPI;
import starter.Gorest.GorestResponses;
import starter.Gorest.Utils.Constant;

import java.io.File;

public class PutUpdateStepdefs {
    @Steps
    GorestAPI gorestAPI;

    @Given("Put update user id {int} valid paramater and json with auth token")
    public void putUpdateUserIdIdValidParamaterAndJsonWithAuthToken(int id) {
        gorestAPI.setPutUpdateUser(id);
    }

    @When("Send put update user parameter")
    public void sendPutUpdateUserParameter() {
        SerenityRest.when().put(gorestAPI.PUT_SINGLE_USER);
    }

    @And("Validate put update user resources json schema")
    public void validatePutUpdateUserResourcesJsonSchema(){
        File jsonSchemaListUser = new File(Constant.JSON_SCHEMA_USER +"PutUpdateUserJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));
    }

    @Given("Put update user id {int} valid paramater and json without auth")
    public void putUpdateUserIdIdValidParamaterAndJsonWithoutAuth(int  id) {
        gorestAPI.setPutUpdateUserNoAuth(id);

    }

    @And("Validate put update user without token resources json schema")
    public void validatePutUpdateUserWithoutTokenResourcesJsonSchema() {
        File jsonSchemaListUser = new File(Constant.JSON_SCHEMA_USER +"PutUpdateUserJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));
    }

    @Given("Put update user id {int} valid parameter and empty name json with auth token")
    public void putUpdateUserIdIdValidParameterAndEmptyNameJsonWithAuthToken(int id) {
        gorestAPI.setPutUpdateUserNoName(id);

    }

    @And("Validate put update user invalid resources json schema")
    public void validatePutUpdateUserInvalidResourcesJsonSchema() {
        File jsonSchemaListUser = new File(Constant.JSON_SCHEMA_USER +"CreateUserNoNameJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));
    }

    @Given("Put update user id {int} valid  parameter and empty email json with auth token")
    public void putUpdateUserIdIdValidParameterAndEmptyEmailJsonWithAuthToken(int id) {
        gorestAPI.setPutUpdateUserNoEmail(id);
    }

    @Given("Put update user id {int} valid parameter and empty gender json with auth token")
    public void putUpdateUserIdIdValidParameterAndEmptyGenderJsonWithAuthToken(int id) {
        gorestAPI.setPutUpdateUserNoGender(id);
    }

    @Given("Put update user id {int} valid parameter and empty status json with auth token")
    public void putUpdateUserIdIdValidParameterAndEmptyStatusJsonWithAuthToken(int id) {
        gorestAPI.setPutUpdateUserNoStatus(id);
    }

    @Given("Put update user id {int} invalid parameter with auth token")
    public void putUpdateUserIdIdInvalidParameterWithAuthToken(int id) {
        gorestAPI.setPutUpdateUser(id);
    }
}
