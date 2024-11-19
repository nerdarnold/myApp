package com.ata.courierApp.business.dto.responses;

import com.ata.courierApp.entities.Shift;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllShiftsByCourierResponse
{
    private String courierId;
    @JsonProperty(value = "shifts")
    List<ShiftsByCourierResponse> shiftsByCourierResponseList;
}
