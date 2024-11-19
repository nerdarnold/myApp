package com.ata.courierApp.entities;

import com.ata.courierApp.entities.abstracts.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "Operation model for Shift")
@Table(name = "operations")
@Entity
@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation extends BaseEntity
{
    @Column(name = "package_rate")
    private BigDecimal packageRate;

    @Column(name = "hourly_rate")
    private BigDecimal hourlyRate;

    @OneToMany(mappedBy = "operation")
    private List<Shift> shiftList;
}
