package com.ata.courierApp.business.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPaymentsByCourierResponse
{
    private String courierId;
    private BigDecimal totalPayment;
    @JsonProperty(value = "shiftPayments")
    private List<ShiftPaymentsResponse> shiftList;
}
