package tests;

import helpers.RestfulBookerHelper;
import io.restassured.response.Response;
import models.response.PostBookingResponse;
import models.response.PutUpdateBookingResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PutUpdateBookingTest {
    RestfulBookerHelper m_helper = new RestfulBookerHelper();

    @Test
    public void UpdateBookingTest(){
        Response response = m_helper.updateBooking(PostBookingBodyTest.getBookingid());

        Assert.assertEquals(response.as(PutUpdateBookingResponse.class).getFirstname(), "Alex");
        Assert.assertEquals(response.as(PutUpdateBookingResponse.class).getLastname(), "De Souza");
        Assert.assertEquals(response.as(PutUpdateBookingResponse.class).getAdditionalneeds(), "Football field");
        Assert.assertEquals(response.as(PutUpdateBookingResponse.class).getTotalprice(), 100);
        Assert.assertFalse(response.as(PutUpdateBookingResponse.class).isDepositpaid());
        Assert.assertEquals(response.as(PutUpdateBookingResponse.class).getBookingdates().getCheckin(), "2023-06-06");
        Assert.assertEquals(response.as(PutUpdateBookingResponse.class).getBookingdates().getCheckout(), "2023-06-12");

        response.then().statusCode(200);
    }
}
