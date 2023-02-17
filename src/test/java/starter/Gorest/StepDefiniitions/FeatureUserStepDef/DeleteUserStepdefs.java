package starter.Gorest.StepDefiniitions.FeatureUserStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Gorest.GorestAPI;

public class DeleteUserStepdefs {
    @Steps
    GorestAPI gorestAPI;
    @Given("Delete user id {int} registered valid parameter with auth token")
    public void deleteUserIdIdRegisteredValidParameterWithAuthToken(int id) {
        gorestAPI.setDeleteSingleUser(id);
    }

    @When("Send delete user parameter")
    public void sendDeleteUserParameter() {
        SerenityRest.when().get(gorestAPI.DELETE_SINGLE_USER);
    }

    @Then("Status code should be {int} No content")
    public void statusCodeShouldBeNoContent(int ok) {SerenityRest.then().statusCode(ok);
    }

//    @Given("Delete user id id registered  with auth token")
//    public void deleteUserIdIdRegisteredWithAuthToken() {
//    }
//
//    @And("Validate delete new user resources json schema")
//    public void validateDeleteNewUserResourcesJsonSchema() {
//    }

}
