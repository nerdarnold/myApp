package com.ata.courierApp.common.results;

import lombok.Getter;

public class Result {
    private boolean success;
    @Getter
    private String message;

    public Result(boolean success){
        this.success = success;
        this.message = success ? ResultMessage.SUCCESS.toString() : ResultMessage.FAIL.toString();
    }

    public Result(boolean success, String message){
        this(success);
        this.message = message;
    }


    public boolean isSuccess(){
        return this.success;
    }

}

