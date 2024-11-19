package com.ata.courierApp.business.concretes;

import com.ata.courierApp.business.abstracts.OperationService;
import com.ata.courierApp.repositories.OperationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OperationServiceImpl implements OperationService
{
    private final OperationRepository operationRepository;

    public OperationServiceImpl(OperationRepository operationRepository)
    {
        this.operationRepository = operationRepository;
    }
}
