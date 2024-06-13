package kr.sparta.deliveryapi.service;

import kr.sparta.deliveryapi.model.Delivery;
import kr.sparta.deliveryapi.model.Food;
import kr.sparta.deliveryapi.model.enumtype.DeliveryStatus;

import java.util.List;

public abstract class FoodDeliveryService implements DeliveryService<Food>{
    @Override
    public abstract Delivery delivery(Long Id);

    @Override
    public abstract String generateTrackingNo(String description);

    @Override
    public abstract DeliveryStatus track(String trackingNumber);

    @Override
    public abstract List<Food> getAllObject();
}
