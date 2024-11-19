package com.ata.courierApp.common.results;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public enum ResultMessage {

    SUCCESS("Ok."),
    FAIL("An error has been occoured."),
    CREATED("Successfully created."),
    BAD_INPUT("Bad Input"),
    REQUESTBODY_CHECK("Bad Request");
    private String message;

    public String toString(){
        return this.message;
    }
}






