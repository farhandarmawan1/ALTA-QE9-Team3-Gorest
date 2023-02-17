package starter.Gorest.StepDefiniitions.FeatureCommentStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Gorest.GorestAPI;
import starter.Gorest.Utils.Constant;

import java.io.File;

public class DeleteCommentsStepDef {

    @Steps
    GorestAPI gorestAPI;
    @Given("Delete comments valid parameter {int} with auth token")
    public void deleteCommentValidParamaterWithAuthToken(int id) {
        gorestAPI.setDeleteCommentWithAuth(id);
    }

    @Given("Delete comments invalid parameter {string} with auth token")
    public void deleteCommentInvalidParamWithAuthToken(String id) {
        gorestAPI.setDeleteCommentInvalidParameterWithAuth(id);
    }

    @Given("Delete comments valid parameter {int} without auth token")
    public void deleteCommentvalidParamWithoutAuthToken(int id){
        File jsonReq = new File(Constant.JSON_REQ_BODY_COMMENT + "ReqBodyValidUpdateComment.json");
        gorestAPI.setDeleteCommentWithoutAuth(id);
    }

    @When("Send request delete comment")
    public void sendDeleteComment() {
        SerenityRest.when().delete(gorestAPI.DELETE_COMMENT);
    }

    @When("Send request delete comment not found")
    public void sendDeleteCommentNotFound() {
        SerenityRest.when().delete(gorestAPI.DELETE_COMMENT_STRING);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int nocontent) {
        SerenityRest.then().statusCode(nocontent);
    }
}
