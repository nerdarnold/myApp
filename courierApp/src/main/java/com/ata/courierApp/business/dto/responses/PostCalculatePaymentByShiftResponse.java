package com.ata.courierApp.business.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostCalculatePaymentByShiftResponse
{
    private String courierId;
    private String shiftId;
    private String paymentAmount;
}
