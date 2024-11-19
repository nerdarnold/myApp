package com.ata.courierApp.business.concretes;

import com.ata.courierApp.business.abstracts.PaymentService;
import com.ata.courierApp.entities.Payment;
import com.ata.courierApp.repositories.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService
{
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository)
    {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment save(Payment payment)
    {
        return this.paymentRepository.save(payment);
    }
}
