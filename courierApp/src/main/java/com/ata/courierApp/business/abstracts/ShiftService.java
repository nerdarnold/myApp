package com.ata.courierApp.business.abstracts;

import com.ata.courierApp.entities.Shift;

import java.util.Optional;

public interface ShiftService
{
    Optional<Shift> findById(String id);
}
