package starter.Gorest.StepDefiniitions.FeatureCommentStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Gorest.GorestAPI;
import starter.Gorest.Utils.Constant;

import java.io.File;

public class DeleteCommentsStepDef {

    @Steps
    GorestAPI gorestAPI;
    @Given("Delete comments valid parameter with auth token")
    public void deleteCommentValidParamaterWithAuthToken() {
        Response response = SerenityRest.get("https://gorest.co.in/public/v2/posts/");
        JsonPath jsonPath= response.jsonPath();
        int id = jsonPath.getInt("[0]['id']");
        gorestAPI.setDeleteCommentWithAuth(id);
    }

    @Given("Delete comments invalid parameter {string} with auth token")
    public void deleteCommentInvalidParamWithAuthToken(String id) {
        gorestAPI.setDeleteCommentInvalidParameterWithAuth(id);
    }

    @Given("Delete comments valid parameter without auth token")
    public void deleteCommentvalidParamWithoutAuthToken(){
        Response response = SerenityRest.get("https://gorest.co.in/public/v2/users/");
        JsonPath jsonPath= response.jsonPath();
        int id = jsonPath.getInt("[0]['id']");
        gorestAPI.setDeleteCommentWithoutAuth(id);
    }

    @Given("Delete comments blank parameter blank with auth token")
    public void deleteCommentsBlankParameterIdWithAuthToken() {
        gorestAPI.setDeleteCommentBlankParameterWithAuth();
    }

    @When("Send request delete comment")
    public void sendDeleteComment() {
        SerenityRest.when().delete(gorestAPI.DELETE_COMMENT);
    }

    @When("Send request delete comment not found")
    public void sendDeleteCommentNotFound() {
        SerenityRest.when().delete(gorestAPI.DELETE_COMMENT_STRING);
    }

    @When("Send request delete comment blank")
    public void sendDeleteCommentBlank() {
        SerenityRest.when().delete(gorestAPI.DELETE_COMMENT_BLANK);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int nocontent) {
        SerenityRest.then().statusCode(nocontent);
    }

}
