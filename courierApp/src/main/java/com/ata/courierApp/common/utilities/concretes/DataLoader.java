package com.ata.courierApp.common.utilities.concretes;

import com.ata.courierApp.entities.Courier;
import com.ata.courierApp.entities.Operation;
import com.ata.courierApp.entities.Shift;
import com.ata.courierApp.repositories.CourierRepository;
import com.ata.courierApp.repositories.OperationRepository;
import com.ata.courierApp.repositories.PaymentRepository;
import com.ata.courierApp.repositories.ShiftRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DataLoader implements ApplicationRunner
{
    private final Logger LOG = LoggerFactory.getLogger(DataLoader.class);
    private final CourierRepository courierRepository;
    private final OperationRepository operationRepository;
    private final PaymentRepository paymentRepository;
    private final ShiftRepository shiftRepository;

    public DataLoader(
            CourierRepository courierRepository,
            OperationRepository operationRepository,
            PaymentRepository paymentRepository,
            ShiftRepository shiftRepository)
    {
        this.courierRepository = courierRepository;
        this.operationRepository = operationRepository;
        this.paymentRepository = paymentRepository;
        this.shiftRepository = shiftRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        List<Courier> courierList = Stream.of(Courier.builder()
                                                     .name("Ata")
                                                     .build(), Courier.builder()
                                                                      .name("Lorem")
                                                                      .build())
                                          .toList();

        List<Operation> operationList = Stream.of(Operation.builder()
                                                           .packageRate(new BigDecimal("1.5"))
                                                           .hourlyRate(new BigDecimal("1.3"))
                                                           .build())
                                              .toList();

        Courier courier = this.courierRepository.save(Courier.builder()
                                                             .name("Ata")
                                                             .build());

        Operation operation = this.operationRepository.save(Operation.builder()
                                                                     .packageRate(new BigDecimal("1.5"))
                                                                     .hourlyRate(new BigDecimal("1.3"))
                                                                     .build());

        Set<Shift> shiftSet = Stream.of(Shift.builder()
                                             .courier(courier)
                                             .operation(operation)
                                             .hoursWorked(8)
                                             .packageCount(30)
                                             .date(LocalDate.now().
                                                     minusDays(10))
                                             .build(),

                                        Shift.builder()
                                             .courier(courier)
                                             .operation(operation)
                                             .hoursWorked(12)
                                             .packageCount(40)
                                             .date(LocalDate.now()
                                                           .minusDays(11))
                                            .build(),
                                            Shift.builder()
                                                 .courier(courier)
                                                 .operation(operation)
                                                 .hoursWorked(10)
                                                 .packageCount(25)
                                                 .date(LocalDate.now()
                                                                .minusDays(12))
                                                 .build()
                                            )
                                    .collect(Collectors.toSet());

        this.shiftRepository.saveAll(shiftSet);
    }
}
