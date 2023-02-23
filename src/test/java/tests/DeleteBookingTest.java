package tests;

import helpers.RestfulBookerHelper;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class DeleteBookingTest {

    RestfulBookerHelper m_helper = new RestfulBookerHelper();

    @Test
    public void deleteBooking(){
        Response response = m_helper.deleteBooking(PostBookingBodyTest.getBookingid());

        response.then().statusCode(201);
    }
}
