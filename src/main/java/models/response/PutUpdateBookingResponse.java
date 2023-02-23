package models.response;

import lombok.Data;

@Data
public class PutUpdateBookingResponse {

    private String firstname;
    private String additionalneeds;
    private PostBookingResponse.Booking.Bookingdates bookingdates;
    private int totalprice;
    private boolean depositpaid;
    private String lastname;

    @Data
    public static class Bookingdates {
        private String checkin;
        private String checkout;
    }
}
