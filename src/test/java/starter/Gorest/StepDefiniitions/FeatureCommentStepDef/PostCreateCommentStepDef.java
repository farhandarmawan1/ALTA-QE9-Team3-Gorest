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

public class PostCreateCommentStepDef {
    @Steps
    GorestAPI gorestAPI;
    @Given("Post create comments valid json and parameter {int} with auth token")
    public void postCreateCommentValidParamaterAndJsonWithAuthToken(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY_COMMENT + "ReqBodyValidPostCreateComment.json");
        gorestAPI.postCreatedCommentWithAuth(id,jsonReq);
    }

    @Given("Post create comments invalid json and parameter {int} with auth token")
    public void postCreateCommentInvalidJsonWithAuthToken(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY_COMMENT + "ReqBodyInvalidPostCreateComment.json");
        gorestAPI.postCreatedCommentWithAuth(id,jsonReq);
    }

    @Given("Post create comments valid json and parameter {int} without auth token")
    public void postCreateCommentvalidJsonAndParamWithoutAuthToken(int id){
        File jsonReq = new File(Constant.JSON_REQ_BODY_COMMENT + "ReqBodyValidPostCreateComment.json");
        gorestAPI.postCreatedCommentNoAuth(id, jsonReq);
    }

    @When("Send post create comment")
    public void sendPostCreateComment() {
        SerenityRest.when().post(gorestAPI.POST_CREATED_COMMENT);
    }

    @And("Response should be id is {int} and post id is {int} and name is {string} and email is {string} and body is {string}")
    public void responsBodyShouldBeNameEmailAndBody(int id, int post_id, String name, String email, String body) {
        SerenityRest.then()
                .body(GorestResponses.ID,equalTo(id))
                .body(GorestResponses.POST_ID,equalTo(post_id))
                .body(GorestResponses.NAME,equalTo(name))
                .body(GorestResponses.EMAIL,equalTo(email))
                .body(GorestResponses.BODY,equalTo(body));
    }

    @And("Validate post create comment resources json schema")
    public void validatePostCreateCommentResourcesJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA_COMMENT +"PostCreateCommentJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
    
}
