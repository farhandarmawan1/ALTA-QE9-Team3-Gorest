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

import static org.hamcrest.Matchers.equalTo;

public class GetListCommentStepDef {

    @Steps
    GorestAPI gorestAPI;


    @Given("Get list comments with valid parameter")
    public void getListUsersWithValidParameterPage() {
        gorestAPI.getListComment("comments");
    }

    @Given("Get list comment with invalid parameter")
    public void getListUsersWithInvalidParameterPagePage() {
        gorestAPI.getListComment("comments/1000000000");
    }

    @When("Send request get list comment")
    public void sendRequestGetListComment() {
        SerenityRest.when().get(gorestAPI.GET_LIST_COMMENT);
    }

    @Then("Status code should be {int} not found")
    public void statusCodeShouldBeNotFound(int not) {
        SerenityRest.then().statusCode(not);
    }

    @And("Validate get comment json schema")
    public void validateJsonSchema(){
        File jsonSchema = new File(Constant.JSON_SCHEMA_COMMENT+"GetListCommentJSONSchema.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

}
