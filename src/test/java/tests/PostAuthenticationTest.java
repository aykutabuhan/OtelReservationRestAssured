package tests;

import helpers.RestfulBookerHelper;
import io.restassured.response.Response;
import models.response.PostAuthResponse;
import org.testng.annotations.Test;
import util.PropertyUtil;

import java.io.IOException;

public class PostAuthenticationTest {

    RestfulBookerHelper m_helper = new RestfulBookerHelper();

    @Test
    public void postAuthenticationTest() throws IOException {
        Response response = m_helper.postAuthentication();
    //    ms_tokenID = response.as(PostAuthResponse.class).getToken();
        PropertyUtil.setProperty("token.property", "tokenID", response.as(PostAuthResponse.class).getToken());
    //  ms_tokenID = response.jsonPath().getString("token");
        response.then().statusCode(200);
    }
}
