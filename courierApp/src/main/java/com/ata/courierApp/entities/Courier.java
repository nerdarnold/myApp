package com.ata.courierApp.entities;

import com.ata.courierApp.entities.abstracts.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Schema(description = "Courier model")
@Table(name = "couriers")
@Entity
@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Courier extends BaseEntity
{
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "courier")
    private List<Shift> shiftList;

    @OneToMany(mappedBy = "courier")
    private List<Payment> paymentList;
}
