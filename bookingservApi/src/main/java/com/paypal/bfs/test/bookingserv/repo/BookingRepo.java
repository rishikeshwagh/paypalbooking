package com.paypal.bfs.test.bookingserv.repo;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Integer> {
}
