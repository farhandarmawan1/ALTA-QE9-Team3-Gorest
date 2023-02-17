package starter.Gorest;


import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Gorest.Utils.Constant;

import java.io.File;

public class GorestAPI {
    public static final String GET_SINGLE_LIST_TODOS_ID = Constant.BASE_URL + "/{todos}";
    public static final String GET_SINGLE_LIST_TODOS_USER_ID = Constant.BASE_URL + "/{todos}";
    public static final String CREATE_TODOS = Constant.BASE_URL + "/{todos}";
    public static final String POST_CREATE_TODOS = Constant.BASE_URL + "/{todos}";
    public static final String DELETE_TODOS = Constant.BASE_URL + "/todos/{id}";
    public static final String UPDATE_TODO = Constant.BASE_URL + "/{todos}";
    public static String GET_LIST_USERS = Constant.BASE_URL + "/{users}";
    public static String GET_LIST_USERS_PAGE = Constant.BASE_URL + "/users?page={id}";
    public static String GET_LIST_TODOS = Constant.BASE_URL + "/{todos}";



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

    @Step("Get Single List Todos with Id")
    public void getSingleListTodoswithId(int id) {
        SerenityRest.given().pathParam("id" ,id);
    }

    @Step("Get Single List Todos With User Id")
    public void getSingleListTodosWithUserId(int userId) {
        SerenityRest.given().pathParam("userid" ,userId);
    }


    public void getSingleListTodoswithInvalidId(String id) {
        SerenityRest.given()
                .pathParam("id",id);
    }

    public void deleteTodoInvalid(String id) {
        SerenityRest.given()
            .pathParam("id",id);
    }

    public void deleteTodo(String todo) { SerenityRest.given().pathParam("todo" ,todo);
    }


    public void updatetodowithvalidstatus(String todo) { SerenityRest.given().pathParam("todo" ,todo);
    }

    @Step("Post Create Todo")
    public void postCreateTodo(String todo,File json) { SerenityRest.given()
            .pathParam("todo", todo)
            .contentType(ContentType.JSON).body(json);
    }

    public void updatetodowithinvalid(String zzzz) { SerenityRest.given().pathParam("zzzz", zzzz);
    }
}