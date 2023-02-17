package starter.Gorest.FeaturePost.JsonPlace;

import starter.Gorest.Utils.Constant;

public class JsonSchema extends Constant {
    public static String GET_LIST_SCHEMA = JSON_SCHEMA_POST + "GetListSchemaPost.json";
    public static String GET_SINGLE_SCHEMA = JSON_SCHEMA_POST + "GetSingleSchemaPost.json";
    public static String GET_SINGLE_SCHEMA_ERROR = JSON_SCHEMA_POST + "ErrorMessageSchemaPost.json";
    public static String DELETE_SCHEMA_ERROR = JSON_SCHEMA_POST + "ErrorMessageSchemaPost.json";
    public static String PUT_VALID_USER = JSON_SCHEMA_POST + "ValidSendDataSchema.json";
    public static String UNREGISTERED_ID = JSON_SCHEMA_POST + "UnregisteredIdErrorSchema.json";
    public static String POST_EMPTY_DATA = JSON_SCHEMA_POST + "ErrorMessageEmptyJsonData.json";
    public static String NOT_INPUTTING_IDUSER = JSON_SCHEMA_POST + "ErrorNotInputtingId_userSchema.json";
}
