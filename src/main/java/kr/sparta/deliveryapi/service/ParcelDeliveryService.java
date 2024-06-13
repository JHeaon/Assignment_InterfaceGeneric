package kr.sparta.deliveryapi.service;

import kr.sparta.deliveryapi.model.Delivery;
import kr.sparta.deliveryapi.model.Parcel;
import kr.sparta.deliveryapi.model.enumtype.DeliveryStatus;

import java.util.List;

public abstract class ParcelDeliveryService implements DeliveryService<Parcel>{
    @Override
    public abstract Delivery delivery(Long Id);

    @Override
    public abstract String generateTrackingNo(String description);

    @Override
    public abstract DeliveryStatus track(String trackingNumber);

    @Override
    public abstract List<Parcel> getAllObject();
}
