package com.transaction.demo.service;

import com.transaction.demo.dto.FlightBookingAcknowledgement;
import com.transaction.demo.dto.FlightBookingRequest;
import com.transaction.demo.model.PassengerInfo;
import com.transaction.demo.model.PaymentInfo;
import com.transaction.demo.repository.PassengerInfoRepository;
import com.transaction.demo.repository.PaymentInfoRepository;
import com.transaction.demo.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class FlightBookibgService {
   @Autowired
    private PaymentInfoRepository paymentInfoRepository;
   @Autowired
   private PassengerInfoRepository passengerInfoRepository;
  @Transactional
   public FlightBookingAcknowledgement bookTicket(FlightBookingRequest request){
        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();
       PaymentUtils.validateCredentials(paymentInfo.getAccountNo(),passengerInfo.getFare());
       paymentInfo.setPassengerId(passengerInfo.getPId());
       paymentInfo.setAmount(passengerInfo.getFare());
       paymentInfoRepository.save(paymentInfo);

      return new FlightBookingAcknowledgement ("Success", passengerInfo.getFare(), UUID.randomUUID().toString(),passengerInfo);
    }
}
