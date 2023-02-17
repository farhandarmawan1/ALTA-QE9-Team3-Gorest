package starter.Gorest;


import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.Gorest.Utils.Constant;

import java.io.File;

public class GorestAPI {
    Faker faker = new Faker();
    String FIRSTNAME = faker.name().firstName();
    public static  String TOKEN = "7bf93ec8d77c033e571a1dbcb59e5985a4297bcbb530efb8698d25b22919d782";
    public static String GET_LIST_USERS = Constant.BASE_URL + "/{users}/";
    public static String GET_LIST_USERS_PAGE = Constant.BASE_URL + "/users?page={id}";
    public static String GET_LIST_TODOS = Constant.BASE_URL + "/{todos}";
    public static String GET_SINGLE_USER = Constant.BASE_URL + "/users/{id}";
    public static String POST_CREATE_USER = Constant.BASE_URL + "/{post}/";

    @Step("Token Authorization")
    public void setTOKEN (){
        SerenityRest.given()
                .header("Authorization","Bearer"+TOKEN);}
    @Step("Post Create New User")
    public void setPostCreateUser(String post) {
        SerenityRest.given().header("Authorization","Bearer "+TOKEN)
                .pathParam("post", post)
                .contentType("multipart/form-data")
                .multiPart("name", "ALTA GOREST")
                .multiPart("email", FIRSTNAME+"@gmail.com")
                .multiPart("gender", "male")
                .multiPart("status", "active");}

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