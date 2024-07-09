package UnitTest.PostBooking;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class Booking_BuilderMethod {
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

    public Booking_BuilderMethod(BookingBuilder bookingBuilder) {
        this.firstName = bookingBuilder.firstname;
        this.lastName = bookingBuilder.lastname;
        this.totalPrice = bookingBuilder.totalPrice;
        this.depositPaid = bookingBuilder.depositPaid;
        this.bookingDates = bookingBuilder.bookingDates;
        this.additionalNeeds = bookingBuilder.additionalNeeds;
    }

    public static class BookingBuilder{
        String firstname;
        String lastname;
        int totalPrice;
        boolean depositPaid;
        BookingDates bookingDates;
        String additionalNeeds;

        public BookingBuilder withFirstName(String firstName){
            this.firstname = firstName;
            return this;
        }

        public BookingBuilder withLastName(String lastName){
            this.lastname = lastName;
            return this;
        }

        public BookingBuilder withTotalPrice(int totalPrice){
            this.totalPrice = totalPrice;
            return this;
        }

        public BookingBuilder withDepositPaid(boolean depositPaid){
            this.depositPaid = depositPaid;
            return this;
        }

        public BookingBuilder withBookingDates(BookingDates bookingDates){
            this.bookingDates = bookingDates;
            return this;
        }

        public BookingBuilder withAdditionalNeeds(String additionalNeeds){
            this.additionalNeeds = additionalNeeds;
            return this;
        }

        public Booking_BuilderMethod build(){
            return new Booking_BuilderMethod(this);
        }

    }
}
