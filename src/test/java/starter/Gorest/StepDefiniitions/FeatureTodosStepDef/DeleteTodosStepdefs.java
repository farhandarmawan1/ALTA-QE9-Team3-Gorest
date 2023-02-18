package starter.Gorest.StepDefiniitions.FeatureTodosStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Gorest.GorestAPI;

public class DeleteTodosStepdefs {
    @Steps
    GorestAPI gorestAPI;

    @Given("Delete todo with valid id")
    public void deleteTodoWithValidId(String id) {SerenityRest.given();
        gorestAPI.deleteTodo(id);
    }

    @When("Send request delete todo")
    public void sendRequestDeleteTodo() {SerenityRest.when().delete(GorestAPI.DELETE_TODOS);
    }

    @Given("Delete todo with invalid id {string}")
    public void deleteTodoWithInvalidId(String id) {
        SerenityRest.given();
        gorestAPI.deleteTodoInvalid(id);
    }


}
