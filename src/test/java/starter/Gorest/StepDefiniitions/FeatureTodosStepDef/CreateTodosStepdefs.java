package starter.Gorest.StepDefiniitions.FeatureTodosStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.jetbrains.annotations.NotNull;
import starter.Gorest.GorestAPI;
import starter.Gorest.GorestResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
import static org.jruby.embed.variable.BiVariable.Type.Constant;

public class CreateTodosStepdefs {
    @Steps
    GorestAPI gorestAPI;

    @Given("Post create todo with valid json")
    public void postCreateTodoWithValidJson() {
        File json = new File(starter.Gorest.Utils.Constant.JSON_REQ_CREATE_TODO+"RequestCreateTodo.json");
        gorestAPI.postCreateTodo("todo",json);
    }

    @When("Send request post create todos")
    public void sendRequestPostCreateTodos() {SerenityRest.when().post(GorestAPI.POST_CREATE_TODOS);
    }

    @And("Set Authentication")
    public void setAuthentication() {
        SerenityRest.given()
                .headers("Authorization","Bearer d0458302309555760e28b2f640c85b88ba5639d4f4421bac49d94d6492344f14");
    }

    @When("Send create request new comments and set authentication")
    public void sendCreateRequestNewCommentsAndSetAuthentication() {
        SerenityRest.when().post(GorestAPI.POST_CREATE_TODOS);
    }

    @And("And Response body title should be {string}, due_on {string} and status {string}")
    public void andResponseBodyTitleShouldBeDue_onAndStatus(String title, String due_on, String status) {
        SerenityRest.then()
                .body(GorestResponses.TITLE_TODO,equalTo(title))
                .body(GorestResponses.DUE_ON_TODO,equalTo(due_on))
                .body(GorestResponses.STATUS_TODO,equalTo(status));
    }

    @And("Validate json schema create todo")
    public void validateJsonSchemaCreateTodo() {
        File jsonSchema = new File(starter.Gorest.Utils.Constant.JSON_SCHEMA_TODOS+"/CreateTodosSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post create todo with invalid user_id json")
    public void postCreateTodoWithInvalidUser_idJson() {
        File json = new File(starter.Gorest.Utils.Constant.JSON_REQ_CREATE_TODO+"/RequestCreateTodosInvalid_User_Id.json");
        gorestAPI.postCreateTodo("todo",json);
    }

    @Given("Post create todo with invalid title json")
    public void postCreateTodosWithInvalidTitleJson() {
        File json = new File(starter.Gorest.Utils.Constant.JSON_REQ_CREATE_TODO+"/RequestCreateTodoInvalid_Title.json");
        gorestAPI.postCreateTodo("todo",json);
    }

    @Given("Post create todo with invalid due_on json")
    public void postCreateTodoWithInvalidDue_onJson() {
        File json = new File(starter.Gorest.Utils.Constant.JSON_REQ_CREATE_TODO+"/RequestCreateTodoInvalid_Due_On.json");
        gorestAPI.postCreateTodo("todo",json);
    }

    @Given("Post create todo with invalid status json")
    public void postCreateTodoWithInvalidStatusJson() {
        File json = new File(starter.Gorest.Utils.Constant.JSON_REQ_CREATE_TODO+"/RequestCreateTodoInvalid_Status.json");
        gorestAPI.postCreateTodo("todo",json);
    }
}
