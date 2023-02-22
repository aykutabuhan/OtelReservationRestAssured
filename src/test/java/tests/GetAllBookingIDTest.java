package tests;

import helpers.RestfulBookerHelper;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.*;

public class GetAllBookingIDTest {

    RestfulBookerHelper m_helper = new RestfulBookerHelper();
    public static List<Integer> allBookingID;

    @Test
    public void getBookingIDTest(){
        Response response = m_helper.getAllBookingID();
        response.then().statusCode(200);

        allBookingID = response.jsonPath().getList("bookingid");

    }
    public static int getAllBookingID(int indexNO) {
        return allBookingID.get(indexNO);
    }

}
