package com.ata.courierApp.webApi.controllers;

import com.ata.courierApp.business.abstracts.CourierService;
import com.ata.courierApp.business.dto.responses.GetAllPaymentsByCourierResponse;
import com.ata.courierApp.business.dto.responses.GetAllShiftsByCourierResponse;
import com.ata.courierApp.business.dto.responses.PostCalculatePaymentByShiftResponse;
import com.ata.courierApp.common.results.Result;
import com.ata.courierApp.common.results.SuccessDataResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Courier Controller", description = "Courier Web API")
@RestController
@RequestMapping("/couriers")
public class CourierController
{
    private final CourierService courierService;

    public CourierController(CourierService courierService)
    {
        this.courierService = courierService;
    }

    @Operation(summary = "Calculate the payment for a shift and POST it For the Courier", responses = {@ApiResponse(responseCode = "200", description = "OK"), @ApiResponse(responseCode = "400", description = "Fail")})
    @PostMapping("/{courierId}/shifts")
    public ResponseEntity<Result> postCalculatePaymentAndPostByShift(
            @PathVariable @Valid @NotBlank String courierId, @RequestParam @Valid @NotBlank String shiftId)
    {
        PostCalculatePaymentByShiftResponse postCalculatePaymentByShiftResponse = this.courierService.postCalculatePaymentByShift(courierId, shiftId);
        return ResponseEntity.ok()
                             .body(new SuccessDataResult<>(postCalculatePaymentByShiftResponse));
    }

    @Operation(summary = "Get All PaymentDTO For Courier", responses = {@ApiResponse(responseCode = "200", description = "OK"), @ApiResponse(responseCode = "400", description = "Fail")})
    @GetMapping("/{courierId}/payments")
    public ResponseEntity<Result> getAllPaymentsByCourier(
            @PathVariable @Valid @NotBlank String courierId)
    {
        GetAllPaymentsByCourierResponse getAllPaymentsByCourierResponse = this.courierService.getAllPaymentsByCourier(courierId);
        return ResponseEntity.ok()
                             .body(new SuccessDataResult<>(getAllPaymentsByCourierResponse));
    }

    @Operation(summary = "Get All ShiftDTO For Courier", responses = {@ApiResponse(responseCode = "200", description = "OK"), @ApiResponse(responseCode = "400", description = "Fail")})
    @GetMapping("/{courierId}/shifts")
    public ResponseEntity<Result> getAllShiftsByCourier(
            @PathVariable @Valid @NotBlank String courierId)
    {
        GetAllShiftsByCourierResponse getAllShiftsByCourierResponse = this.courierService.getAllShiftsByCourier(courierId);
        return ResponseEntity.ok()
                             .body(new SuccessDataResult<>(getAllShiftsByCourierResponse));
    }
}
