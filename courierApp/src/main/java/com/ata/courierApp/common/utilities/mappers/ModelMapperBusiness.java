package com.ata.courierApp.common.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperBusiness {
    ModelMapper forRequest();
    ModelMapper forResponse();
}
