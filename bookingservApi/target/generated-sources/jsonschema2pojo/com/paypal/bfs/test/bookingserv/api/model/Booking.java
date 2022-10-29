
package com.paypal.bfs.test.bookingserv.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Booking resource
 * <p>
 * Booking resource object
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@JsonPropertyOrder({
    "id",
    "first_name",
    "last_name",
    "date_of_birth",
    "checkin_datetime",
    "checkout_datetime",
    "total_price",
    "deposit",
    "address"
})
public class Booking {

    /**
     * Booking id
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Booking id")
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Integer id;
    /**
     * First name
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("first_name")
    @JsonPropertyDescription("First name")
    @Size(min = 1, max = 255)
    private String firstName;
    /**
     * Last name
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("last_name")
    @JsonPropertyDescription("Last name")
    @Size(min = 1, max = 255)
    private String lastName;
    /**
     * DOB
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("date_of_birth")
    @JsonPropertyDescription("DOB")
    @Size(min = 1, max = 20)
    private String dateOfBirth;
    /**
     * Checking datetime
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("checkin_datetime")
    @JsonPropertyDescription("Checking datetime")
    @Size(min = 1, max = 50)
    private String checkinDatetime;
    /**
     * Checkout datetime
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("checkout_datetime")
    @JsonPropertyDescription("Checkout datetime")
    @Size(min = 1, max = 50)
    private String checkoutDatetime;
    /**
     * total price
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("total_price")
    @JsonPropertyDescription("total price")
    private Integer totalPrice;
    /**
     * Checking date
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("deposit")
    @JsonPropertyDescription("Checking date")
    private Integer deposit;
    /**
     * Address Object
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("address")
    @JsonPropertyDescription("Address Object")
    @OneToOne
    @Valid
    private Address address;

    /**
     * Booking id
     * 
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * Booking id
     * 
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * First name
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    /**
     * First name
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Last name
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    /**
     * Last name
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * DOB
     * (Required)
     * 
     */
    @JsonProperty("date_of_birth")
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * DOB
     * (Required)
     * 
     */
    @JsonProperty("date_of_birth")
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Checking datetime
     * (Required)
     * 
     */
    @JsonProperty("checkin_datetime")
    public String getCheckinDatetime() {
        return checkinDatetime;
    }

    /**
     * Checking datetime
     * (Required)
     * 
     */
    @JsonProperty("checkin_datetime")
    public void setCheckinDatetime(String checkinDatetime) {
        this.checkinDatetime = checkinDatetime;
    }

    /**
     * Checkout datetime
     * (Required)
     * 
     */
    @JsonProperty("checkout_datetime")
    public String getCheckoutDatetime() {
        return checkoutDatetime;
    }

    /**
     * Checkout datetime
     * (Required)
     * 
     */
    @JsonProperty("checkout_datetime")
    public void setCheckoutDatetime(String checkoutDatetime) {
        this.checkoutDatetime = checkoutDatetime;
    }

    /**
     * total price
     * (Required)
     * 
     */
    @JsonProperty("total_price")
    public Integer getTotalPrice() {
        return totalPrice;
    }

    /**
     * total price
     * (Required)
     * 
     */
    @JsonProperty("total_price")
    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Checking date
     * (Required)
     * 
     */
    @JsonProperty("deposit")
    public Integer getDeposit() {
        return deposit;
    }

    /**
     * Checking date
     * (Required)
     * 
     */
    @JsonProperty("deposit")
    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    /**
     * Address Object
     * (Required)
     * 
     */
    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    /**
     * Address Object
     * (Required)
     * 
     */
    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Booking.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("firstName");
        sb.append('=');
        sb.append(((this.firstName == null)?"<null>":this.firstName));
        sb.append(',');
        sb.append("lastName");
        sb.append('=');
        sb.append(((this.lastName == null)?"<null>":this.lastName));
        sb.append(',');
        sb.append("dateOfBirth");
        sb.append('=');
        sb.append(((this.dateOfBirth == null)?"<null>":this.dateOfBirth));
        sb.append(',');
        sb.append("checkinDatetime");
        sb.append('=');
        sb.append(((this.checkinDatetime == null)?"<null>":this.checkinDatetime));
        sb.append(',');
        sb.append("checkoutDatetime");
        sb.append('=');
        sb.append(((this.checkoutDatetime == null)?"<null>":this.checkoutDatetime));
        sb.append(',');
        sb.append("totalPrice");
        sb.append('=');
        sb.append(((this.totalPrice == null)?"<null>":this.totalPrice));
        sb.append(',');
        sb.append("deposit");
        sb.append('=');
        sb.append(((this.deposit == null)?"<null>":this.deposit));
        sb.append(',');
        sb.append("address");
        sb.append('=');
        sb.append(((this.address == null)?"<null>":this.address));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
