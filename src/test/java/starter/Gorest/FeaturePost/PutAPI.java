package starter.Gorest.FeaturePost;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Gorest.Utils.Constant;

import java.io.File;

public class PutAPI extends Constant {
    public static String PUT_VALID_USER = BASE_URL + "/posts/{id}";
    public static String PUT_INVALID_USER = BASE_URL + "/posts/{id}";
    public static String TOKEN = "c5fff42859baa2dbd051ff5064ed750c4d453f8624416d1d78c33b67a74d2f1c";

    @Step("Update valid user")
    public void updateValidUser(int id, File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Update invalid user")
    public void updateInvalidUser(String id, File json){
        SerenityRest.given()
                .header("Authorization", TOKEN)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
}
