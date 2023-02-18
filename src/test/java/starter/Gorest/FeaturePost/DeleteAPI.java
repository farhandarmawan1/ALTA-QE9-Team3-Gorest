package starter.Gorest.FeaturePost;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Gorest.Utils.Constant;

public class DeleteAPI extends Constant {
    public static String DELETE_USER_POST = BASE_URL + "/posts/{id}";
    public static String DELETE_USER_PREVIOUSLY = BASE_URL + "/posts/{id}";
    public static String DELETE_USER_INVALID = BASE_URL + "/{feature}/{id}";
    public static String DELETE_USER_NOPARAMETER = BASE_URL + "/posts";
    public static String TOKEN = "c5fff42859baa2dbd051ff5064ed750c4d453f8624416d1d78c33b67a74d2f1c";

    @Step("Delete user valid parameter")
    public void deleteValidUser(int id){
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("id", id);
    }

    @Step("Delete previously user")
    public void deleteValidPreUser(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Delete user without parameter id")
    public void deleteNoIdUser(){
        SerenityRest.given();
    }

    @Step("Delete user invalid parameter")
    public void deleteInvalidUser(String id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Delete user invalid feature")
    public void deleteInvalidFeature(String feature, int id){
        SerenityRest.given().pathParam("feature", feature).pathParam("id", id);
    }
}
