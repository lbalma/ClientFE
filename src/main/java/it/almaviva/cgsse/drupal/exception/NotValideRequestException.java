package it.almaviva.cgsse.drupal.exception;

public class NotValideRequestException extends Exception {

    public static final String EXCEPTION_MESSAGE_REQUEST_NULL = "Request is null";
    public static final String EXCEPTION_MESSAGE_INPUT_NAME_NULL_OR_EMPTY = "Input name null or empty";
    public static final String EXCEPTION_MESSAGE_INPUT_UUID_NULL_OR_EMPTY = "Input UUID null or empty";

    public NotValideRequestException(String message){
        super (message);
    }
}
