package hantaro.com.petagram.restApi.model;

import hantaro.com.petagram.db.ConstantsDataBase;
import hantaro.com.petagram.restApi.ConstantesRestApi;
import retrofit2.Call;
import retrofit2.http.GET;

public interface EndpointsApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<ContactResponse> getRecentMedia();

}
