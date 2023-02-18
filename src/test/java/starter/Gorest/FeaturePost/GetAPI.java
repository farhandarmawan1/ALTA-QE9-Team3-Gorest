package starter.Gorest.FeaturePost;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Gorest.Utils.Constant;

public class GetAPI extends Constant {
    public static String GET_LIST = BASE_URL + "/posts";
    public static String GET_LIST_INVALID = BASE_URL + "/{feature}";
    public static String GET_LIST_PAGE = BASE_URL + "/posts?page={page}";
    public static String GET_SINGLE_USER = BASE_URL + "/posts/{id}";
    public static String GET_SINGLE_USER_INVALID = BASE_URL + "/{feature}/{id}";

    @Step("Get valid user")
    public void getList(){
        SerenityRest.given();
    }

    @Step("Get list invalid resources")
    public void getListInvalid(String feature){
        SerenityRest.given().pathParam("feature", feature);
    }

    @Step("Get list user with valid page")
    public void getListPage(int page){
        SerenityRest.given().pathParam("page", page);
    }

    @Step("Get list user with invalid page")
    public void getListPageInvalid(String page){
        SerenityRest.given().pathParam("page", page);
    }

    @Step("Get single user with valid parameter")
    public void getSingleUser(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get single user with invalid parameter")
    public void getSingleInvalidUser(String id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get single user with invalid parameter feature")
    public void getSingleInvalidUserFeature(String feature, int id){
        SerenityRest.given()
                .pathParam("feature", feature)
                .pathParam("id", id);
    }
}
