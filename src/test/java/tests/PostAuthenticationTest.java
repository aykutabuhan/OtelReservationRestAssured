package tests;

import helpers.RestfulBookerHelper;
import io.restassured.response.Response;
import models.response.PostAuthResponse;
import org.testng.annotations.Test;

public class PostAuthenticationTest {

    RestfulBookerHelper m_helper = new RestfulBookerHelper();
    public static String ms_tokenID; //  Property dosyasına set edilecek

    @Test
    public void postAuthenticationTest(){
        Response response = m_helper.postAuthentication();
        ms_tokenID = response.as(PostAuthResponse.class).getToken();
    //  ms_tokenID = response.jsonPath().getString("token");
        response.then().statusCode(200);
    }

    public static String getTokenID(){
        return ms_tokenID;
    }
}
