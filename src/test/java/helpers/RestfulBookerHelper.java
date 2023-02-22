package helpers;

import client.RestClient;
import io.restassured.response.Response;
import models.request.PostAuthBody;
import models.request.PostBookingBody;
import tests.PostAuthenticationTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestfulBookerHelper extends RestClient {

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

        Map<String, Object> headers = new HashMap<>();
        headers.put("token", PostAuthenticationTest.getTokenID());
        return post("/booking", null, null, bookingBody);
    }
    public Response getAllBookingID(){
        return get("/booking", null, null, null);
    }
    public Response getBookingWithID(int indexID){
        return get("/booking/" + indexID, null,null,null);
    }
    public Response updateBooking(int indexID){
        PostBookingBody.BookingDates innerDateBody = PostBookingBody.BookingDates.builder().checkin("2023-06-06")
                .checkout("2023-06-12").build();

        PostBookingBody updateBody = PostBookingBody.builder().firstname("Alex").lastname("De Souza").totalprice(100)
                .depositpaid(false).bookingdates(innerDateBody).additionalneeds("Football field").build();

        Map<String, Object> headers = new HashMap<>();
        headers.put("token", PostAuthenticationTest.getTokenID());
        return put("/booking/" + indexID, null, headers, updateBody);
    }
}
