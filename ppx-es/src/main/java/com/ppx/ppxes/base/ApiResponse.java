package com.ppx.ppxes.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
    private int code;
    private String message;
    private Object data;
    private boolean more;

    public ApiResponse() {
        this.code = Status.SUCCESS.code;

    }

    public ApiResponse(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ApiResponse ofMessage(int code, String message) {
        return new ApiResponse(code, message, null);
    }

    public static ApiResponse ofSuccess(Object data) {
        return new ApiResponse(Status.SUCCESS.code, Status.SUCCESS.standardMessage, data);
    }

    public static ApiResponse ofStatus(Status status) {
        return new ApiResponse(status.code, status.standardMessage, null);
    }

    /**
     *
     */
    public enum Status {
        SUCCESS(200, "OK"),//
        BAD_REQUEST(400, "BAD"),//
        INTERNAL_SERVER_ERROR(500, "Unknown internal error"),
        NOT_VALID_PARAM(40005, "Not valid param"),

        ;
        private int code; // s
        private String standardMessage;// sdf

        Status(int code, String standardMessage) {
            this.code = code;
            this.standardMessage = standardMessage;
        }
    }
}
