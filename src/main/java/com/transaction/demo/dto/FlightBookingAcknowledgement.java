package com.transaction.demo.dto;

import com.transaction.demo.model.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingAcknowledgement {
    private String status;
    private double totalFair;
    private String pnrNo;
    private PassengerInfo passengerInfo;
}
