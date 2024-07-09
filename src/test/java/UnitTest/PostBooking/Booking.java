package UnitTest.PostBooking;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Booking {

    @SerializedName("firstname")
    @JsonProperty
    private String firstName;

    @SerializedName("lastname")
    @JsonProperty
    private String lastName;

    @SerializedName("totalprice")
    @JsonProperty
    private int totalPrice;

    @SerializedName("depositpaid")
    @JsonProperty
    private boolean depositPaid;

    @SerializedName("bookingdates")
    @JsonProperty
    private BookingDates bookingDates;

    @SerializedName("additionalneeds")
    @JsonProperty
    private String additionalNeeds;

    public String getAdditionalNeeds() {
        return additionalNeeds;
    }

    public void setAdditionalNeeds(String additionalNeeds) {
        this.additionalNeeds = additionalNeeds;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean getDepositPaid() {
        return depositPaid;
    }

    public void setDepositPaid(boolean depositPaid) {
        this.depositPaid = depositPaid;
    }

    public BookingDates getBookingDates() {
        return bookingDates;
    }

    public void setBookingDates(BookingDates bookingDates) {
        this.bookingDates = bookingDates;
    }


}
