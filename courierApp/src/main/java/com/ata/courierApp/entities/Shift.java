package com.ata.courierApp.entities;

import com.ata.courierApp.entities.abstracts.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Schema(description = "Shift of a courier")
@Table(name = "shifts")
@Entity
@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Shift extends BaseEntity
{
    @ManyToOne
    @JoinColumn(name = "operation_id")
    private Operation operation;

    @ManyToOne
    @JoinColumn(name = "courier_id")
    private Courier courier;

    @OneToOne(mappedBy = "shift")
    private Payment payment;

    @Column
    private LocalDate date;

    @Column(name = "package_count")
    private Integer packageCount;

    @Column(name = "hours_worked")
    private Integer hoursWorked;
}
