package tests;

import helpers.RestfulBookerHelper;
import io.restassured.response.Response;
import models.response.PostBookingResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.PropertyUtil;

import java.io.IOException;

public class PostBookingBodyTest {
    RestfulBookerHelper m_helper = new RestfulBookerHelper();

    @Test
    public void postBookingTest() throws IOException {
        Response response = m_helper.postBooking();
    //    Assert.assertEquals(response.jsonPath().getJsonObject("booking.firstname"), "Lewis");
    //    Assert.assertEquals(response.jsonPath().getJsonObject("booking.bookingdates.checkin"), "2023-09-07");
        Assert.assertEquals(response.as(PostBookingResponse.class).getBooking().getFirstname(), "Lewis");
        Assert.assertEquals(response.as(PostBookingResponse.class).getBooking().getBookingdates().getCheckin(), "2023-09-07");

        PropertyUtil.setProperty("bookingID.property", "bookingID", response.as(PostBookingResponse.class)
                .getBookingid());

        response.then().statusCode(200);
    }
}
