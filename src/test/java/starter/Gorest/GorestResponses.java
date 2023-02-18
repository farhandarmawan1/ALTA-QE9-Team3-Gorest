package starter.Gorest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

public class GorestResponses {

    public static final String FIRST_NAME = "data.first_name[0]";
    public static final String LAST_NAME = "data.last_name[0]";
    public static String PAGE = "page";
    public static String JOB = "job";
    public static String TOKEN_USER = "token";
    public static String DATA_ID = "data_id";
    public static String EMAIL2 = "data.email";
    public static String TITLE_TODO = "title";
    public static String DUE_ON_TODO = "due_on";
    public static String STATUS_TODO = "status";
    public static String ID = "id";
    public static String MESSAGE = "message";
    public static String NAME = "name";
    public static String EMAIL = "email";
    public static String GENDER = "gender";
    public static String STATUS = "status";
    public static  String NAME1 = "[0]['field']";
    public static String MESSAGE1 = "[0]['message']";
    public static  String NAME2 = "[0]['field']";
    public static String MESSAGE2 = "[0]['message']";
    public static String ERROR = "message";
    public static String USER_ID = "user_id";
    public static String TITLE = "title";
    public static String BODY = "body";
    public static String FIELD = "field";
    public static String ID2 = "[0]['id']";
    public static String POST_ID = "post_id";

}