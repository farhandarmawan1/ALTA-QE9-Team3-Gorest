package starter.Gorest.StepDefiniitions.FeatureUserStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Gorest.GorestAPI;
import starter.Gorest.GorestResponses;
import starter.Gorest.Utils.Constant;
import java.io.File;

import io.restassured.module.jsv.JsonSchemaValidator;

import static org.hamcrest.CoreMatchers.equalTo;

public class GetSingleStepdefs {
    @Steps
    GorestAPI gorestAPI;
    @Given("Get single user detail registered")
    public void getSingleUserDetailRegisteredId() {
        Response response = SerenityRest.get("https://gorest.co.in/public/v2/users/");
        JsonPath jsonPath= response.jsonPath();
        int id = jsonPath.getInt("[0]['id']");
        gorestAPI.setGetSingleUser(id);

    }

    @When("Send get single user parameter")
    public void sendGetSingleUserParameter() {
        SerenityRest.when().get(gorestAPI.GET_SINGLE_USER);
    }


    @And("Validate get single user detail resources json schema")
    public void validateGetSingleUserDetaliResourcesJsonSchema() {
        File jsonSchemaListUser = new File(Constant.JSON_SCHEMA_USER +"SingleUserJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));
    }

    @Given("Get single user detail unregistered {int}")
    public void getSingleUserDetailUnregisteredId(int id) {
        gorestAPI.setGetSingleUser(id);
    }

    @And("Respons body should error {string}")
    public void responsBodyShouldError(String message) {SerenityRest.then().body(GorestResponses.MESSAGE,equalTo(message));
    }

    @And("Validate json schema")
    public void validateGetSingleUserDetaliResourcesJsonSchema1() {
        File jsonSchemaListUser = new File(Constant.JSON_SCHEMA_USER +"SingleUserUnregisterJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));
    }
}
