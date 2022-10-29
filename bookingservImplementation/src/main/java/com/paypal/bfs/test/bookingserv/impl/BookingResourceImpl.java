package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.repo.BookingRepo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookingResourceImpl implements BookingResource {

    private static final Log LOGGER = LogFactory.getLog(BookingResourceImpl.class);

    @Autowired
    private BookingRepo bookingRepo;

    @Override
    public ResponseEntity<Booking> create(@Valid Booking booking) {
        try{
            booking = bookingRepo.saveAndFlush(booking);
        }catch(Exception e){
            LOGGER.error(e);
            new ResponseEntity(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(booking, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity listBookings() {
        try{
            List<Booking> bookings = bookingRepo.findAll();
            return new ResponseEntity<>(bookings,HttpStatus.ACCEPTED);
        }catch(Exception e){
            LOGGER.error(e);
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
