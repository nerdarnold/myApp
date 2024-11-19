package com.ata.courierApp.entities;

import com.ata.courierApp.entities.abstracts.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "Payment for Courier model")
@Table(name = "payments")
@Entity
@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment extends BaseEntity
{
    @OneToOne
    @JoinColumn(name = "shift_id")
    private Shift shift;

    @ManyToOne
    @JoinColumn(name = "courier_id")
    private Courier courier;

    @Column(name = "payment_amount")
    private BigDecimal paymentAmount;

    @Column(name = "date")
    private LocalDate date;

}
