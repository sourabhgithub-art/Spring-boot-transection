package com.transaction.demo.Controller;

import com.transaction.demo.dto.FlightBookingAcknowledgement;
import com.transaction.demo.dto.FlightBookingRequest;
import com.transaction.demo.service.FlightBookibgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class bookFlightTicket {
    @Autowired
    private FlightBookibgService flightBookibgService;
    @PostMapping("/bookingTicket")
    public FlightBookingAcknowledgement bookingTicket(@RequestBody FlightBookingRequest req){
        return flightBookibgService.bookTicket(req);
    }
}
