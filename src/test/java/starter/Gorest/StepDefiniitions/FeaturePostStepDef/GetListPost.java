package starter.Gorest.StepDefiniitions.FeaturePostStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Gorest.FeaturePost.GetAPI;
import starter.Gorest.FeaturePost.JsonPlace.JsonSchema;

import java.io.File;

public class GetListPost {
    @Steps
    GetAPI getAPI;

//    Get list without parameter
    @Given("Get list user without parameter")
    public void getListUserWithoutParameter() {
        getAPI.getList();
    }

    @When("Send get list user")
    public void sendGetListUser() {
        SerenityRest.when().get(GetAPI.GET_LIST);
    }

    @And("Validate get list post resources json schema")
    public void validateGetListPostResourcesJsonSchema() {
        File jsonSchema = new File(JsonSchema.GET_LIST_SCHEMA);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

//    Get list invalid feature
    @Given("Get list user with invalid feature {string}")
    public void getListUserWithInvalidFeature(String feature) {
        getAPI.getListInvalid(feature);
    }

    @When("Send get list user invalid feature")
    public void sendGetListUserInvalidFeature() {
        SerenityRest.when().get(GetAPI.GET_LIST_INVALID);
    }

//    Get list with valid page
    @Given("Get list user with valid parameter {int}")
    public void getListUserValidParameterPage(int page) {
        getAPI.getListPage(page);
    }

    @When("Send get list user parameter valid page")
    public void sendGetListUserParameterValidPage() {
        SerenityRest.when().get(GetAPI.GET_LIST_PAGE);
    }

//    Get list post with invalid parameter page
    @Given("Get list user with invalid parameter {string}")
    public void getListUserWithInvalidParameter(String page) {
        getAPI.getListPageInvalid(page);
    }
}
