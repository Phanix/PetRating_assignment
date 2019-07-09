package hantaro.com.petagram.restApi;

public final class ConstantesRestApi {

    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "15879182927.b778c42.d99b17e02c274872ac04568e9be6257d";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";
    public static final String KEY_KEY_USER_PERFIL = "users/self/";
    public static final String URL_GET_USER_PERFIL = KEY_KEY_USER_PERFIL + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    //https://api.instagram.com/v1/users/self/?access_token=15879182927.b778c42.d99b17e02c274872ac04568e9be6257d


}
