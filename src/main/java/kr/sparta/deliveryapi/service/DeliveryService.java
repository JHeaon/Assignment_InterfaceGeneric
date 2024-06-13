package kr.sparta.deliveryapi.service;

import kr.sparta.deliveryapi.model.Delivery;
import kr.sparta.deliveryapi.model.enumtype.DeliveryStatus;

import java.util.List;

public interface DeliveryService <T>{
    Delivery delivery(Long Id);
    String generateTrackingNo(String description);
    DeliveryStatus track(String trackingNumber);
    List<T> getAllObject();
}
