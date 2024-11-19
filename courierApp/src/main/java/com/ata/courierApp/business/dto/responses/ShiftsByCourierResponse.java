package com.ata.courierApp.business.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShiftsByCourierResponse
{
    private LocalDate date;
    private Integer packageCount;
    private Integer hoursWorked;
    private String operationId;
}
