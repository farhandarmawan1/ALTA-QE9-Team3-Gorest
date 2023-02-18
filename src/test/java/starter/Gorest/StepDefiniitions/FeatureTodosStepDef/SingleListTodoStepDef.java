package starter.Gorest.StepDefiniitions.FeatureTodosStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Gorest.GorestAPI;
import starter.Gorest.Utils.Constant;

import java.io.File;

public class SingleListTodoStepDef {

    @Steps
    GorestAPI gorestAPI;

    @Given("Get single list todo with valid id {int}")
    public void getSingleListTodoWithValidId(int id) {
        gorestAPI.getSingleListTodoswithId(id);
    }

    @Given("Get single list todo with valid user_id {int}")
    public void getSingleListTodoWithValidUser_Id(int user_id) {
        gorestAPI.getSingleListTodosWithUserId(user_id);
    }

    @When("Send request get single list todo id")
    public void sendRequestGetSingleListTodoId() {
        SerenityRest.when().get(GorestAPI.GET_SINGLE_LIST_TODOS_ID);
    }

    @When("Send request get single list todo user_id")
    public void sendRequestGetSingleListTodoUserId() {
        SerenityRest.when().get(GorestAPI.GET_SINGLE_LIST_TODOS_USER_ID);
    }

    //Negative Case
    @Given("Get single list todo with invalid id {string}")
    public void getSingleListTodoWithInvalidIdId(String id) {
        gorestAPI.getSingleListTodoswithInvalidId(id);
    }

    @Then("Should return status code {int}")
    public void shouldReturnStatusCode(int OK) {SerenityRest.then().statusCode(OK);
    }
}
