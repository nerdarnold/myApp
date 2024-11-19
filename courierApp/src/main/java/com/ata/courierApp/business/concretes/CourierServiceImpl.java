package com.ata.courierApp.business.concretes;

import com.ata.courierApp.business.abstracts.CourierService;
import com.ata.courierApp.business.abstracts.PaymentService;
import com.ata.courierApp.business.abstracts.ShiftService;
import com.ata.courierApp.business.dto.responses.*;
import com.ata.courierApp.common.utilities.mappers.ModelMapperBusiness;
import com.ata.courierApp.entities.Courier;
import com.ata.courierApp.entities.Operation;
import com.ata.courierApp.entities.Payment;
import com.ata.courierApp.entities.Shift;
import com.ata.courierApp.repositories.CourierRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CourierServiceImpl implements CourierService
{
    private final CourierRepository courierRepository;
    private final ModelMapperBusiness modelMapperBusiness;
    private final ShiftService shiftService;
    private final PaymentService paymentService;

    public CourierServiceImpl(
            CourierRepository courierRepository,
            ModelMapperBusiness modelMapperBusiness,
            ShiftService shiftService,
            PaymentService paymentService)
    {
        this.courierRepository = courierRepository;
        this.modelMapperBusiness = modelMapperBusiness;
        this.shiftService = shiftService;
        this.paymentService = paymentService;
    }

    @Override
    public PostCalculatePaymentByShiftResponse postCalculatePaymentByShift(String courierId, String shiftId)
    {
        Courier courier = this.courierRepository.findById(courierId)
                                                .orElseThrow(() -> new EntityNotFoundException("Courier not found"));
        Shift shift = this.shiftService.findById(shiftId)
                                       .orElseThrow(() -> new EntityNotFoundException("Shift not found."));

        Operation operation = shift.getOperation();
        BigDecimal packagePayment = operation.getPackageRate()
                                             .multiply(BigDecimal.valueOf(shift.getPackageCount()));
        BigDecimal hourlyPayment = operation.getHourlyRate()
                                            .multiply(BigDecimal.valueOf(shift.getHoursWorked()));
        BigDecimal totalPayment = packagePayment.add(hourlyPayment);


        Payment paymentToSave = Payment.builder()
                                       .shift(shift)
                                       .courier(shift.getCourier())
                                       .paymentAmount(totalPayment)
                                       .date(LocalDate.now())
                                       .build();
        this.paymentService.save(paymentToSave);

        return this.modelMapperBusiness.forResponse()
                                       .map(paymentToSave, PostCalculatePaymentByShiftResponse.class);
    }

    @Override
    public GetAllPaymentsByCourierResponse getAllPaymentsByCourier(String courierId)
    {
        Courier courier = this.courierRepository.findById(courierId)
                                                .orElseThrow(() -> new EntityNotFoundException("Courier not found"));
        GetAllPaymentsByCourierResponse getAllPaymentsByCourierResponse = new GetAllPaymentsByCourierResponse();

        getAllPaymentsByCourierResponse.setCourierId(courierId);

        BigDecimal totalPayment = BigDecimal.ZERO;
        List<ShiftPaymentsResponse> shiftPaymentsResponseList = new ArrayList<>();
        for (Shift shift : courier.getShiftList())
        {
            totalPayment = totalPayment.add(shift.getPayment()
                                                 .getPaymentAmount());
            ShiftPaymentsResponse shiftPaymentsResponse = this.modelMapperBusiness.forResponse()
                                                                                  .map(shift, ShiftPaymentsResponse.class);
            shiftPaymentsResponseList.add(shiftPaymentsResponse);
        }

        getAllPaymentsByCourierResponse.setShiftList(shiftPaymentsResponseList);
        getAllPaymentsByCourierResponse.setTotalPayment(totalPayment);

        return getAllPaymentsByCourierResponse;
    }

    @Override
    public GetAllShiftsByCourierResponse getAllShiftsByCourier(String courierId)
    {
        Courier courier = this.courierRepository.findById(courierId)
                                                .orElseThrow(() -> new EntityNotFoundException("Courier not found"));
        GetAllShiftsByCourierResponse getAllShiftsByCourierResponse = new GetAllShiftsByCourierResponse();
        getAllShiftsByCourierResponse.setCourierId(courierId);
        List<ShiftsByCourierResponse> shiftsByCourierResponseList = courier.getShiftList()
                                                                           .stream()
                                                                           .map(x -> this.modelMapperBusiness.forResponse()
                                                                                                             .map(x, ShiftsByCourierResponse.class))
                                                                           .toList();
        getAllShiftsByCourierResponse.setShiftsByCourierResponseList(shiftsByCourierResponseList);
        return getAllShiftsByCourierResponse;
    }
}
