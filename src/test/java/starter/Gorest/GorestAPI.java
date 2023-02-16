package starter.Gorest;


import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.Gorest.Utils.Constant;
public class GorestAPI {
    public static String GET_LIST_USERS = Constant.BASE_URL + "/{users}";
    public static String GET_LIST_USERS_PAGE = Constant.BASE_URL + "/users?page={id}";
    public static String GET_LIST_TODOS = Constant.BASE_URL + "/{todos}";
    public static String GET_SINGLE_USER = Constant.BASE_URL + "/users/{id}";

    @Step("Get single user")
    public void setGetSingleUser(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get list users")
    public void getListUsers(String users) {
        SerenityRest.given()
                .pathParam("users", users);
    }

    @Step("Get list users page")
    public void setGetListUsersPage(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
    @Step("Get list todos")
    public void getListTodos(String todos){
        SerenityRest.given().pathParam("todos", todos);
    }


}