package com.ata.courierApp.business.concretes;

import com.ata.courierApp.business.abstracts.ShiftService;
import com.ata.courierApp.entities.Shift;
import com.ata.courierApp.repositories.ShiftRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ShiftServiceImpl implements ShiftService
{
    private final ShiftRepository shiftRepository;

    public ShiftServiceImpl(ShiftRepository shiftRepository)
    {
        this.shiftRepository = shiftRepository;
    }

    public Optional<Shift> findById(String id)
    {
        return this.shiftRepository.findById(id);
    }
}
