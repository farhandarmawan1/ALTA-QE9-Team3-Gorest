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

public class GetListTodoStepdefs {

    @Steps
    GorestAPI gorestAPI;

    @Given("Get list todos with valid parameter")
    public void getListTodosWithValidParameter() { gorestAPI.getListTodos("todos");
    }

    @When("Send request get list todos")
    public void sendRequestGetListTodos() {
        SerenityRest.when().get(gorestAPI.GET_LIST_TODOS);
    }

    @Then("Should return status code {int} OK")
    public void shouldReturnStatusCode(int OK) { SerenityRest.then().statusCode(OK);
    }

    @And("Validate json schema list todos")
    public void validateJsonSchemaListTodos() {
        File jsonSchemaListTodos = new File(Constant.JSON_SCHEMA_TODOS + "ListTodosJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListTodos));
    }

    @Given("Get list todos with invalid parameter")
    public void getListTodosWithInvalidParameter() { gorestAPI.getListTodos("adsg");
    }
}
