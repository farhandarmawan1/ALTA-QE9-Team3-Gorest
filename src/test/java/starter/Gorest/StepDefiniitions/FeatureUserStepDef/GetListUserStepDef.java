package starter.Gorest.StepDefiniitions.FeatureUserStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Gorest.GorestAPI;
import starter.Gorest.Utils.Constant;
import java.io.File;

import io.restassured.module.jsv.JsonSchemaValidator;

public class GetListUserStepDef {
    @Steps
    GorestAPI gorestAPI;
    @Given("Get list user with valid parameter")
    public void getListUserWithValidParameter() {
        gorestAPI.getListUsers("users");
    }

    @When("Send get list user parameter")
    public void sendGetListUserParameter() {
        SerenityRest.when().get(gorestAPI.GET_LIST_USERS);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Validate get list resources json schema")
    public void validateGetListResourcesJsonSchema(){
        File jsonSchemaListUser = new File(Constant.JSON_SCHEMA_USER +"ListUserJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));
    }

    @Given("Get list user with page {int} valid parameter")
    public void getListUserWithPageIdValidParameter(int id) {
        gorestAPI.setGetListUsersPage(id);
    }
    @When("Send get list user parameter page")
    public void sendGetListUserParameterPage() {
        SerenityRest.when().get(gorestAPI.GET_LIST_USERS_PAGE);
    }

    @Given("Get list user invalid parameter {string}")
    public void getListUserInvalidParameter(String users) {
        gorestAPI.getListUsers(users);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    @Given("Get list user invalid page parameter {int}")
    public void getListUserInvalidPageParameterId(int id) {
        gorestAPI.setGetListUsersPage(id);
    }
}
