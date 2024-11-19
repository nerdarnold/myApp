package com.ata.courierApp.business.abstracts;

import com.ata.courierApp.business.dto.responses.GetAllPaymentsByCourierResponse;
import com.ata.courierApp.business.dto.responses.GetAllShiftsByCourierResponse;
import com.ata.courierApp.business.dto.responses.PostCalculatePaymentByShiftResponse;

public interface CourierService
{
    PostCalculatePaymentByShiftResponse postCalculatePaymentByShift(String courierId, String shiftId);
    GetAllPaymentsByCourierResponse getAllPaymentsByCourier(String courierId);
    GetAllShiftsByCourierResponse getAllShiftsByCourier(String courierId);
}
