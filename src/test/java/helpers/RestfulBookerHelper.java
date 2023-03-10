package helpers;

import client.RestClient;
import io.restassured.response.Response;
import models.request.PostAuthBody;
import models.request.PostBookingBody;
import util.PropertyUtil;

import java.util.HashMap;

public class RestfulBookerHelper extends RestClient {

    private static final String CREATED_BOOKING_ID = PropertyUtil.getProperty("bookingID", "bookingID.property");
    private static final String TOKEN_ID = PropertyUtil.getProperty("tokenID", "token.property");

    public RestfulBookerHelper() {
        super("https://restful-booker.herokuapp.com");
    }
    public Response postAuthentication(){
        PostAuthBody tokenBody =  PostAuthBody.builder().username("admin").password("password123").build();

        return post("/auth", null, null, tokenBody);
    }
    public Response postBooking(){
        PostBookingBody.BookingDates innerDateBody = PostBookingBody.BookingDates.builder().checkin("2023-09-07")
                                                                                    .checkout("2023-09-16").build();

        PostBookingBody bookingBody = PostBookingBody.builder().firstname("Lewis").lastname("Hamilton").totalprice(150)
                                    .depositpaid(true).bookingdates(innerDateBody).additionalneeds("Smoker room").build();

        return post("/booking", null, null, bookingBody);
    }
    public Response getAllBookingID(){
        return get("/booking", null, null, null);
    }
    public Response getBookingWithID(){
        return get("/booking/" + CREATED_BOOKING_ID, null,null,null);
    }
    public Response updateBooking(){
        PostBookingBody.BookingDates innerDateBody = PostBookingBody.BookingDates.builder().checkin("2023-06-06")
                .checkout("2023-06-12").build();

        PostBookingBody updateBody = PostBookingBody.builder().firstname("Alex").lastname("De Souza").totalprice(100)
                .depositpaid(false).bookingdates(innerDateBody).additionalneeds("Football field").build();

      //  Map<String, Object> headers = new HashMap<>();
      //  headers.put("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=");

        System.out.println(headers());
        return put("/booking/" + CREATED_BOOKING_ID, null, headers(), updateBody);
    }
    public Response deleteBooking(){
        //  Map<String, Object> headers = new HashMap<>();
        // headers.put("Cookie", "token=" + PostAuthenticationTest.getTokenID());

        return delete("/booking/" + CREATED_BOOKING_ID, null, headers(), null);
    }

    public HashMap<String, Object> headers(){
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("Cookie", "token=" + TOKEN_ID);

        return headers;
    }
}
