package com.impact.Inventory.exception;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorInfo {

	String errorMessage;

	Integer errorCode;

	LocalDateTime timestamp;

}
