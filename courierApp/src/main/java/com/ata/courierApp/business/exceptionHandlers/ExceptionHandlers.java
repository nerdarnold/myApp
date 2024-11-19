package com.ata.courierApp.business.exceptionHandlers;

import com.ata.courierApp.common.results.ErrorDataResult;
import com.ata.courierApp.common.results.ErrorResult;
import com.ata.courierApp.common.results.Result;
import com.ata.courierApp.common.results.ResultMessage;
import com.ata.courierApp.common.utilities.exceptions.BusinessException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlers
{
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Result> handleBusinessException(BusinessException businessException)
    {
        return ResponseEntity.badRequest().body(new ErrorDataResult<>(businessException.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Result> handleGlobalException(Exception exception)
    {
        return ResponseEntity.badRequest().body(new ErrorDataResult<>(exception.getMessage()));
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Result> handleValidException(MethodArgumentNotValidException methodArgumentNotValidException)
    {
        //Validation error mesajlarını mapliyoruz.
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError fieldError : methodArgumentNotValidException.getBindingResult()
                                                                    .getFieldErrors())
        {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(new ErrorDataResult<Map<String, String>>(validationErrors, ResultMessage.BAD_INPUT.toString()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Result> handleEntityNotFoundException(EntityNotFoundException entityNotFoundException)
    {
        return !(entityNotFoundException.getMessage()
                                        .isBlank()) ? ResponseEntity.badRequest().body(new ErrorResult(entityNotFoundException.getMessage())) : ResponseEntity.badRequest().body(new ErrorResult("Böyle bir varlık bulunamadı"));
    }
}
