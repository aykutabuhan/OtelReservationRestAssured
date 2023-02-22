package tests;

import helpers.RestfulBookerHelper;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetBookingTest {

    RestfulBookerHelper m_helper = new RestfulBookerHelper();
/*
    @Test
    public void getBookingTest(){
        Response response = m_helper.getBookingWithID(GetAllBookingIDTest.getAllBookingID(43));
        response.then().statusCode(200);
    }

 */
    @Test
    public void getCreatedBookingTest(){
        Response response = m_helper.getBookingWithID(PostBookingBodyTest.getBookingid());
        response.then().statusCode(200);
    }
}
