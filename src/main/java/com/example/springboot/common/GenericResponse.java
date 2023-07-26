package com.example.springboot.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * Hold data for generic responses.
 *
 * @author Maneesha
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse {

    private HttpStatus status;

    private String message;

    private String responseCode;

    private Object response;

}
