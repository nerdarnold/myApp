package com.ata.courierApp.business.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShiftPaymentsResponse
{
    private String shiftId;
    @JsonProperty(value = "date")
    private LocalDate paymentDate;
    private Integer packageCount;
    private Integer hoursWorked;
    private String operationId;
    private BigDecimal paymentAmount;

}
