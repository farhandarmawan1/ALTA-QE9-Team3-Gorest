package starter.Gorest.StepDefiniitions.FeatureCommentStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Gorest.GorestAPI;
import starter.Gorest.GorestResponses;
import starter.Gorest.Utils.Constant;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PatchUpdateCommentStepDef {

    @Steps
    GorestAPI gorestAPI;
    @Given("Patch Update comments valid json and parameter {int} with auth token")
    public void patchUpdateCommentValidParamaterAndJsonWithAuthToken(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY_COMMENT + "ReqBodyValidUpdateComment.json");
        gorestAPI.patchUpdateCommentWithAuth(id,jsonReq);
    }

    @When("Send patch Update comment")
    public void sendPatchUpdateComment() {
        SerenityRest.when().patch(gorestAPI.PUT_PATCH_UPDATE_COMMENT);
    }

    @Given("Patch Update comments invalid json and parameter {int} with auth token")
    public void patchUpdateCommentInvalidJsonWithAuthToken(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY_COMMENT + "ReqBodyInvalidUpdateComment.json");
        gorestAPI.patchUpdateCommentWithAuth(id,jsonReq);
    }

    @Given("Patch Update comments valid json and parameter {int} without auth token")
    public void patchUpdateCommentvalidJsonAndParamWithoutAuthToken(int id){
        File jsonReq = new File(Constant.JSON_REQ_BODY_COMMENT + "ReqBodyValidUpdateComment.json");
        gorestAPI.patchUpdateCommentNoAuth(id, jsonReq);
    }

}
