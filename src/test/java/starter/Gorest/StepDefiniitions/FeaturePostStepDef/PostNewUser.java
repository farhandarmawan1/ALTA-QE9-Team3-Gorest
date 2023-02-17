package starter.Gorest.StepDefiniitions.FeaturePostStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Gorest.FeaturePost.JsonPlace.JsonSchema;
import starter.Gorest.FeaturePost.PostAPI;
import starter.Gorest.Utils.Constant;

import java.io.File;

public class PostNewUser {
    @Steps
    PostAPI postAPI;

//    Post new user with valid data
    @Given("Post new user with valid parameter and json with auth token")
    public void postNewUserWithValidParameterAsIdAndJsonWithAuthToken() {
        File jsonReq = new File(Constant.JSON_REQ_BODY_POST + "SendDataValid.json");
        postAPI.postValidUser(jsonReq);
    }

    @When("Send post new user parameter")
    public void sendPostNewUserParameter() {
        SerenityRest.when().post(PostAPI.POST_VALID_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

//    Post new user with empty json data
    @Given("Post new user with empty json")
    public void postNewUserWithEmptyJson() {
        File jsonReq = new File(Constant.JSON_REQ_BODY_POST + "SendEmptyData.json");
        postAPI.postValidUser(jsonReq);
    }

    @And("Validate post empty json data schema")
    public void validatePostEmptyJsonData() {
        File jsonSchema = new File(JsonSchema.POST_EMPTY_DATA);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

//    Post new user unregistered user_id
    @Given("Post new user with valid json data and unregistered id_user")
    public void postNewUserWithValidJsonDataAndUnregisteredId_user() {
        File jsonReq = new File(Constant.JSON_REQ_BODY_POST + "SendUnregisteredId.json");
        postAPI.postValidUser(jsonReq);
    }

    @And("Validate post unregistered User_id json data schema")
    public void validatePostUnregisteredUser_idJsonDataSchema() {
        File jsonSchema = new File(JsonSchema.UNREGISTERED_ID);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

//    Post new user without inputting user_id
    @Given("Post new user without inputting user_id")
    public void postNewUserWithoutInputtingUser_id() {
        File jsonReq = new File(Constant.JSON_REQ_BODY_POST + "SendWithoutId_user.json");
        postAPI.postValidUser(jsonReq);
    }

    @And("Validate post without inputting User_id json data schema")
    public void validatePostWithoutInputtingUser_idJsonDataSchema() {
        File jsonSchema = new File(JsonSchema.NOT_INPUTTING_IDUSER);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

//    Post new user without inputting title
    @Given("Post new user without inputting title")
    public void postNewUserWithoutInputtingTitle() {
        File jsonReq = new File(Constant.JSON_REQ_BODY_POST + "SendWithoutTittle.json");
        postAPI.postValidUser(jsonReq);
    }

    @And("Validate post without inputting title json data schema")
    public void validatePostWithoutInputtingTitleJsonDataSchema() {
        File jsonSchema = new File(JsonSchema.UNREGISTERED_ID);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

//    Post new user without inputting body
    @Given("Post new user without inputting body")
    public void postNewUserWithoutInputtingBody() {
        File jsonReq = new File(Constant.JSON_REQ_BODY_POST + "SendWithoutbody.json");
        postAPI.postValidUser(jsonReq);
    }

    @And("Validate post without inputting body json data schema")
    public void validatePostWithoutInputtingBodyJsonDataSchema() {
        File jsonSchema = new File(JsonSchema.UNREGISTERED_ID);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
