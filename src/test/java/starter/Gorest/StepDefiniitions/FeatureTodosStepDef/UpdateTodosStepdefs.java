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

public class UpdateTodosStepdefs {
    @Steps
    GorestAPI gorestAPI;

    @Given("Update todo with valid status")
    public void updateTodoWithValidStatus(String id) {gorestAPI.updatetodowithvalidstatus(id);
    }

    @When("Send request update todo")
    public void sendRequestUpdateTodo() { SerenityRest.when().get(gorestAPI.UPDATE_TODO);
    }

    @Then("API should return response {int} OK")
    public void apiShouldReturnResponseOK(int OK) { SerenityRest.then().statusCode(OK);
    }

    @And("Validate json schema")
    public void validateJsonSchema() {
        File jsonSchemaUpdateTodos = new File(Constant.JSON_SCHEMA_TODOS + "UpdateTodosJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaUpdateTodos));
    }

    @Given("Update todo with invalid status")
    public void updateTodoWithInvalidStatus() {gorestAPI.updatetodowithinvalid("zzzz");
    }

    @Then("API should return response {int} Unprocessable Entity")
    public void apiShouldReturnResponseUnprocessableEntity(int UnprocessableEntity) {
        SerenityRest.then().statusCode(UnprocessableEntity);
    }

    @Given("Update todo with valid title json")
    public void updateTodoWithValidTitleJson() {
        File Json = new File(starter.Gorest.Utils.Constant.JSON_SCHEMA_TODOS + "UpdateTodoJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(Json));
    }

    @Given("Update todo with invalid title json")
    public void updateTodoWithInvalidTitleJson() {
        File Json = new File(starter.Gorest.Utils.Constant.JSON_SCHEMA_TODOS + "UpdateTodoJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(Json));
    }

    @Given("Update todo with valid doe_on json")
    public void updateTodoWithValidDoe_onJson() {
        File Json = new File(starter.Gorest.Utils.Constant.JSON_SCHEMA_TODOS + "UpdateTodoJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(Json));
    }


    @Given("Update todo with invalid doe_on json")
    public void updateTodoWithInvalidDoe_onJson() {
        File Json = new File(starter.Gorest.Utils.Constant.JSON_SCHEMA_TODOS + "UpdateTodoJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(Json));
    }
}
