package starter.Gorest.StepDefiniitions.FeatureCommentStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Gorest.GorestAPI;
import starter.Gorest.GorestResponses;
import starter.Gorest.Utils.Constant;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PutUpdateCommentStepDef {
    @Steps
    GorestAPI gorestAPI;
    @Given("Put Update comments valid json and parameter {int} with auth token")
    public void putUpdateCommentValidParamaterAndJsonWithAuthToken(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY_COMMENT + "ReqBodyValidUpdateComment.json");
        gorestAPI.putUpdateCommentWithAuth(id,jsonReq);
    }

    @When("Send put Update comment")
    public void sendPutUpdateComment() {
        SerenityRest.when().put(gorestAPI.PUT_PATCH_UPDATE_COMMENT);
    }

    @And("Response should be id is {int} and user id is {int} and title is {string} and body is {string}")
    public void responsBodyShouldBeIdTitleBody(int id, int user_id, String title, String body) {
        SerenityRest.then()
                .body(GorestResponses.ID,equalTo(id))
                .body(GorestResponses.USER_ID,equalTo(user_id))
                .body(GorestResponses.TITLE,equalTo(title))
                .body(GorestResponses.BODY,equalTo(body));
    }

    @And("Validate update comment resources json schema")
    public void validatePutPatchUpdateCommentResourcesJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA_COMMENT +"PutPatchUpdateCommentJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Put Update comments invalid json and parameter {int} with auth token")
    public void putUpdateCommentInvalidJsonWithAuthToken(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY_COMMENT + "ReqBodyInvalidUpdateComment.json");
        gorestAPI.putUpdateCommentWithAuth(id,jsonReq);
    }

    @Given("Put Update comments valid json and parameter {int} without auth token")
    public void putUpdateCommentvalidJsonAndParamWithoutAuthToken(int id){
        File jsonReq = new File(Constant.JSON_REQ_BODY_COMMENT + "ReqBodyValidUpdateComment.json");
        gorestAPI.putUpdateCommentNoAuth(id, jsonReq);
    }

}
