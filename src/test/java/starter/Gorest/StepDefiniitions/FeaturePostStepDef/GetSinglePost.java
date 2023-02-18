package starter.Gorest.StepDefiniitions.FeaturePostStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Gorest.FeaturePost.GetAPI;
import starter.Gorest.FeaturePost.JsonPlace.JsonSchema;
import starter.Gorest.GorestResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetSinglePost {
    @Steps
    GetAPI getAPI;

    //    Get single valid parameter
    @Given("Get single user with registered {int}")
    public void getSingleUserWithRegisteredId(int id) {
        getAPI.getSingleUser(id);
    }

    @When("Send get single user post")
    public void sendGetSingleUser() {
        SerenityRest.when().get(GetAPI.GET_SINGLE_USER);
    }

    @And("Response body should be {int} user")
    public void responseBodyShouldBeIdUser(int id) {
        SerenityRest.then().body(GorestResponses.ID, equalTo(id));
    }

    @And("Validate get single json schema")
    public void validateGetSingleJsonSchema() {
        File jsonSchema = new File(JsonSchema.GET_SINGLE_SCHEMA);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

//    Get single unregistered id
    @Given("Get single user with unregistered {int}")
    public void getSingleUserWithUnregisteredId(int id) {
        getAPI.getSingleUser(id);
    }

    @And("Response body should be {string} as error message")
    public void responseBodyShouldBeAsErrorMessage(String error) {
        SerenityRest.then().body(GorestResponses.ERROR, equalTo(error));
    }

    @And("Validate get single json schema invalid")
    public void validateGetSingleJsonSchemaInvalid() {
        File jsonSchema = new File(JsonSchema.GET_SINGLE_SCHEMA_ERROR);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

//    Get single invalid id
    @Given("Get single user with invalid {string}")
    public void getSingleUserWithUnregistered(String id) {
        getAPI.getSingleInvalidUser(id);
    }

//    Get single with invalid feature
    @Given("Get single user with registered {int} and invalid {string}")
    public void getSingleUserWithRegisteredIdAndInvalid(String feature, int id) {
        getAPI.getSingleInvalidUserFeature(feature, id);
    }

    @When("Send get single user invalid feature")
    public void sendGetSingleUserInvalidFeature() {
        SerenityRest.when().get(GetAPI.GET_SINGLE_USER_INVALID);
    }
}
