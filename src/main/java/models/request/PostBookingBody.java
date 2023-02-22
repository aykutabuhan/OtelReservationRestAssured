package models.request;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class PostBookingBody {

    private String firstname;
    private String additionalneeds;
    private BookingDates bookingdates;
    private int totalprice;
    private boolean depositpaid;
    private String lastname;

    @Data
    @Builder
    public static class BookingDates {
        private String checkin;
        private String checkout;
    }
}
