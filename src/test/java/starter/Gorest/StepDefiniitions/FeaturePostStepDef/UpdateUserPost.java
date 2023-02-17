package starter.Gorest.StepDefiniitions.FeaturePostStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Gorest.FeaturePost.JsonPlace.JsonSchema;
import starter.Gorest.FeaturePost.PutAPI;
import starter.Gorest.GorestResponses;
import starter.Gorest.Utils.Constant;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UpdateUserPost {
    @Steps
    PutAPI putAPI;

//    Update valid id user
    @Given("Put update user with valid parameter {int} as id and json with auth token")
    public void putUpdateUserWithValidParameterAndJsonWithAuthToken(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY_POST + "SendDataValid.json");
        putAPI.updateValidUser(id, jsonReq);
    }

    @When("Send put update user parameter")
    public void sendPutUpdateUserParameter() {
        SerenityRest.when().put(PutAPI.PUT_VALID_USER);
    }

    @And("Response body should be {int} as user_id")
    public void responseBodyShouldBeAsUser_id(int user_id) {
        SerenityRest.then().body(GorestResponses.USER_ID, equalTo(user_id));
    }

    @And("Validate put update user resources json schema")
    public void validatePutUpdateUserResourcesJsonSchema() {
        File jsonSchema = new File(JsonSchema.PUT_VALID_USER);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

//    Update invalid id user
    @Given("Put update user with valid parameter {string} as id and json with auth token")
    public void putUpdateUserWithValidParameterAsIdAndJsonWithAuthToken(String id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY_POST + "SendDataValid.json");
        putAPI.updateInvalidUser(id, jsonReq);
    }

//    Update user with invalid user_id
    @Given("Put update user with valid parameter {int} as id and invalid user_id with auth token")
    public void putUpdateUserWithValidParameterAsIdAndInvalidUser_idWithAuthToken(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY_POST + "SendUnregisteredId.json");
        putAPI.updateValidUser(id, jsonReq);
    }

    @Then("Status code should be {int} Unprocessable Entity")
    public void statusCodeShouldBeUnprocessableEntity(int entity) {
        SerenityRest.then().statusCode(entity);
    }

    @And("Response body should be {string} as field and {string} as message")
    public void responseBodyShouldBeAsFieldAndAsMessage(String field, String message) {
        SerenityRest.then()
                .body(GorestResponses.FIELD, equalTo(field))
                .body(GorestResponses.MESSAGE, equalTo(message));
    }

//    Update user unregistered user_id
    @And("Validate put unregistered id resources json schema")
    public void validatePutUnregisteredIdResourcesJsonSchema() {
        File jsonSchema = new File(JsonSchema.UNREGISTERED_ID);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

//    Update user without inputting title
    @Given("Put update user with valid parameter {int} as id and not inputting title")
    public void putUpdateUserWithValidParameterAsIdAndNotInputtingTitle(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY_POST + "SendWithoutTittle.json");
        putAPI.updateValidUser(id, jsonReq);
    }

//    Update user without inputting body
    @Given("Put update user with valid parameter {int} as id and not inputting body")
    public void putUpdateUserWithValidParameterAsIdAndNotInputtingBody(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY_POST + "SendWithoutbody.json");
        putAPI.updateValidUser(id, jsonReq);
    }
}
