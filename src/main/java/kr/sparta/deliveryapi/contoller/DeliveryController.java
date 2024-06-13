package kr.sparta.deliveryapi.contoller;

import kr.sparta.deliveryapi.model.Delivery;
import kr.sparta.deliveryapi.model.enumtype.DeliveryStatus;
import kr.sparta.deliveryapi.model.Food;
import kr.sparta.deliveryapi.model.Parcel;
import kr.sparta.deliveryapi.service.FoodDeliveryServiceImpl;
import kr.sparta.deliveryapi.service.ParcelDeliveryServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeliveryController {
    private final FoodDeliveryServiceImpl foodDeliveryService;
    private final ParcelDeliveryServiceImpl parcelDeliveryService;

    public DeliveryController(FoodDeliveryServiceImpl foodDeliveryService, ParcelDeliveryServiceImpl parcelDeliveryService) {
        this.foodDeliveryService = foodDeliveryService;
        this.parcelDeliveryService = parcelDeliveryService;
    }

    @PostMapping("/food/{foodId}")
    public String deliverFood(@PathVariable Long foodId) {
        Delivery delivery = foodDeliveryService.delivery(foodId);
        return delivery.getName() + " 배달이 시작되었습니다. 추적 번호: " + delivery.getTrackingNumber();
    }

    @GetMapping("/food/{trackingNumber}")
    public DeliveryStatus trackFood(@PathVariable String trackingNumber) {
        return foodDeliveryService.track(trackingNumber);
    }

    @PostMapping("/parcel/{parcelId}")
    public String deliverParcel(@PathVariable Long parcelId) {
        Delivery delivery = parcelDeliveryService.delivery(parcelId);
        return "택배 배달이 시작되었습니다. 물품명: " + delivery.getName() + ", 추적 번호: " + delivery.getTrackingNumber();
    }

    @GetMapping("/parcel/{trackingNumber}")
    public DeliveryStatus trackParcel(@PathVariable String trackingNumber) {
        return parcelDeliveryService.track(trackingNumber);
    }

    @GetMapping("/foods")
    public List<Food> getAllFoods() {
        return foodDeliveryService.getAllObject();
    }

    @GetMapping("/parcels")
    public List<Parcel> getAllParcels() {
        return parcelDeliveryService.getAllObject();
    }
}

