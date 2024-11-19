package com.ata.courierApp.repositories;

import com.ata.courierApp.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,String>
{
}
