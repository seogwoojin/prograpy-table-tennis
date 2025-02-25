package com.prography.tabletennis.global.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
  private Integer code;
  private String message;
  private T result;

  private ApiResponse(Integer code, String message, T data) {
    this.code = code;
    this.message = message;
    this.result = data;
  }

  public static <T> ApiResponse<T> success(T data) {
    return new ApiResponse<>(ReturnCode.SUCCESS.getCode(), ReturnCode.SUCCESS.getMessage(), data);
  }

  public static <T> ApiResponse<T> success() {
    return success(null);
  }

  public static <T> ApiResponse<T> fail(ReturnCode returnCode) {
    return new ApiResponse<>(returnCode.getCode(), returnCode.getMessage(), null);
  }

  public static <T> ApiResponse<T> error(ReturnCode returnCode) {
    return new ApiResponse<>(returnCode.getCode(), returnCode.getMessage(), null);
  }
}
