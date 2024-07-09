package UnitTest.PostBooking;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class BookingDates {
    @SerializedName("checkin")
    @JsonProperty
    private Date checkIn;

    @SerializedName("checkout")
    @JsonProperty
    private Date checkOut;

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

}
