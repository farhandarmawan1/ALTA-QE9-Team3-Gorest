package starter.Gorest.Utils;

import java.io.File;

public class Constant {
    public static final String BASE_URL = "https://gorest.co.in/public/v2";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQ_BODY_USER = DIR+"/src/test/resources/JSON/ReqBody/FeatureUser/";
    public static final String JSON_REQ_BODY_POST= DIR+"/src/test/resources/JSON/ReqBody/FeaturePost/";
    public static final String JSON_REQ_BODY_COMMENT= DIR+"/src/test/resources/JSON/ReqBody/FeatureComment/";
    public static final String JSON_REQ_BODY_TODOS= DIR+"/src/test/resources/JSON/ReqBody/FeatureTodos/";
    public static final String JSON_SCHEMA_USER = DIR+"/src/test/resources/JSON/JsonSchema/FeatureUser/";
    public static final String JSON_SCHEMA_TODOS = DIR+"/src/test/resources/JSON/JsonSchema/FeatureTodos/";
    public static final String JSON_SCHEMA_SINGLE_LIST_TODO = DIR+"/src/test/resources/JSON/JsonSchema/FeatureTodos/";
    public static final String JSON_REQ_CREATE_TODO = DIR+"/src/test/resources/JSON/ReqBody/FeatureTodos/";
    public static final String JSON_SCHEMA_POST = DIR+"/src/test/resources/JSON/JsonSchema/FeaturePost/";
    public static final String JSON_SCHEMA_COMMENT= DIR+"/src/test/resources/JSON/JsonSchema/FeatureComment/";
}