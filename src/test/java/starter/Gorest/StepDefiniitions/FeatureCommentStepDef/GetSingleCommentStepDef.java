package starter.Gorest.StepDefiniitions.FeatureCommentStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Gorest.GorestAPI;
import starter.Gorest.Utils.Constant;

import java.io.File;

public class GetSingleCommentStepDef {
    @Steps
    GorestAPI gorestAPI;

    @Given("Get single comment with valid parameter id {int}")
    public void getSingleCommentWithParam(int id) {
        gorestAPI.getSingleCommentValid(id);
    }

    @Given("Get single comment with invalid parameter {string}")
    public void getListUsersWithBlankParameter(String id) {
        gorestAPI.getSingleCommentInvalid(id);
    }

    @Given("Get single comment with blank parameter id {}")
    public void getSingleUsersWithBlankParameterIdId(String id) {
        gorestAPI.getSingleCommentInvalid(id);
    }

    @When("Send request get single comment")
    public void sendRequestGetSingleComment() {
        SerenityRest.when().get(gorestAPI.GET_SINGLE_COMMENT);
    }


    @When("Send request get single comment not found")
    public void sendRequestGetSingleUsersNotFound() {
        SerenityRest.when().get(gorestAPI.GET_SINGLE_COMMENT);
    }

    @And("Validate get single comment JSON")
    public void validateGetSingleCommentJsonSchema() {
        File jsonSchema= new File(Constant.JSON_SCHEMA_COMMENT+"GetSingleCommentJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
