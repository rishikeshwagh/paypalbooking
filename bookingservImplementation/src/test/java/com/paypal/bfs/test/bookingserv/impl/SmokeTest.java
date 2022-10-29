package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

@DataJpaTest
@ComponentScan("com.paypal.bfs.test.bookingserv")
public class SmokeTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookingResource bookingResource;

    @Test
    public void testSaveNewBooking() {
        Booking booking = new Booking();
        booking.setFirstName("Kundan");
        booking.setLastName("Dey");
        booking.setDeposit(3000);
        booking.setTotalPrice(6000);
        booking.setDateOfBirth("02-13-1990");
        booking.setCheckinDatetime("02-13-1990");
        booking.setCheckoutDatetime("02-13-1990");

        Address address = new Address();
        address.setCity("Bangalore");
        address.setLine1("Maratahalli");
        address.setState("Karnataka");
        address.setZipCode(560066);
        booking.setAddress(address);
        entityManager.persist(address);
        bookingResource.create(booking);

        for( Booking booking1: (List<Booking>)bookingResource.listBookings().getBody()){
            if(booking1.getFirstName().equals("Kundan")){
                assertThat(booking1.getDeposit()).isEqualTo(3000);
                assertThat(booking1.getLastName()).isEqualTo("Dey");
                assertThat(booking1.getAddress().getCity()).isEqualTo("Bangalore");
                return;
            }
        }
        fail();
    }


}
