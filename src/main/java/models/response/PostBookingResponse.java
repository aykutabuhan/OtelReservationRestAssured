package models.response;

import lombok.Builder;
import lombok.Data;
@Data
public class PostBookingResponse {
    private Booking booking;
    private int bookingid;

    @Data
    public static class Booking{
        private String firstname;
        private String additionalneeds;
        private Bookingdates bookingdates;
        private int totalprice;
        private boolean depositpaid;
        private String lastname;

        @Data
        public static class Bookingdates{
            private String checkin;
            private String checkout;
        }
    }
}