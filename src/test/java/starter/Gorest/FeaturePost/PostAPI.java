package starter.Gorest.FeaturePost;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Gorest.Utils.Constant;

import java.io.File;

public class PostAPI extends Constant {
    public static String POST_VALID_USER = BASE_URL + "/posts";

    public static String TOKEN = "c5fff42859baa2dbd051ff5064ed750c4d453f8624416d1d78c33b67a74d2f1c";

    @Step("Update valid user")
    public void postValidUser(File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }
}
