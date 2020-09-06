package com.ssafy.waple.error;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.ssafy.waple.error.exception.ErrorCode;

public class ErrorResponse {
	private String message;
	private int status;
	private List<FieldError> errors;
	private String code;

	protected ErrorResponse() {
	}

	private ErrorResponse(final ErrorCode code, final List<FieldError> errors) {
		this.message = code.getMessage();
		this.status = code.getStatus();
		this.errors = errors;
		this.code = code.getCode();
	}

	private ErrorResponse(final ErrorCode code) {
		this.message = code.getMessage();
		this.status = code.getStatus();
		this.errors = new ArrayList<>();
		this.code = code.getCode();
	}

	public static ErrorResponse of(final ErrorCode code, final BindingResult bindingResult) {
		return new ErrorResponse(code, FieldError.of(bindingResult));
	}

	public static ErrorResponse of(final ErrorCode code) {
		return new ErrorResponse(code);
	}

	public static ErrorResponse of(final ErrorCode code, final List<FieldError> errors) {
		return new ErrorResponse(code, errors);
	}

	public static ErrorResponse of(MethodArgumentTypeMismatchException e) {
		final String value = e.getValue() == null ? "" : e.getValue().toString();
		final List<ErrorResponse.FieldError> errors = ErrorResponse.FieldError.of(e.getName(), value, e.getErrorCode());
		return new ErrorResponse(ErrorCode.INVALID_TYPE_VALUE, errors);
	}

	public String getMessage() {
		return message;
	}

	public int getStatus() {
		return status;
	}

	public List<FieldError> getErrors() {
		return errors;
	}

	public String getCode() {
		return code;
	}

	public static class FieldError {
		private String field;
		private String value;
		private String reason;

		protected FieldError() {
		}

		private FieldError(final String field, final String value, final String reason) {
			this.field = field;
			this.value = value;
			this.reason = reason;
		}

		public static List<FieldError> of(final String field, final String value, final String reason) {
			List<FieldError> fieldErrors = new ArrayList<>();
			fieldErrors.add(new FieldError(field, value, reason));
			return fieldErrors;
		}

		private static List<FieldError> of(final BindingResult bindingResult) {
			final List<org.springframework.validation.FieldError> fieldErrors = bindingResult.getFieldErrors();
			return fieldErrors.stream()
				.map(error -> new FieldError(
					error.getField(),
					error.getRejectedValue() == null ? "" : error.getRejectedValue().toString(),
					error.getDefaultMessage()))
				.collect(Collectors.toList());
		}

		public String getField() {
			return field;
		}

		public String getValue() {
			return value;
		}

		public String getReason() {
			return reason;
		}
	}
}
