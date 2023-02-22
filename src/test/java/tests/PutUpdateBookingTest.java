package tests;

import helpers.RestfulBookerHelper;
import io.restassured.response.Response;
import models.response.PostBookingResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PutUpdateBookingTest {
    RestfulBookerHelper m_helper = new RestfulBookerHelper();

    @Test
    public void UpdateBookingTest(){
        Response response = m_helper.updateBooking(PostBookingBodyTest.getBookingid());

        Assert.assertEquals(response.as(PostBookingResponse.class).getBooking().getFirstname(), "Alex");
        Assert.assertEquals(response.as(PostBookingResponse.class).getBooking().getLastname(), "De Souza");
        Assert.assertEquals(response.as(PostBookingResponse.class).getBooking().getAdditionalneeds(), "Football field");
        Assert.assertEquals(response.as(PostBookingResponse.class).getBooking().getTotalprice(), 100);
        Assert.assertFalse(response.as(PostBookingResponse.class).getBooking().isDepositpaid());
        Assert.assertEquals(response.as(PostBookingResponse.class).getBooking().getBookingdates().getCheckin(), "2023-06-06");
        Assert.assertEquals(response.as(PostBookingResponse.class).getBooking().getBookingdates().getCheckout(), "2023-06-12");

        response.then().statusCode(200);
    }
}
