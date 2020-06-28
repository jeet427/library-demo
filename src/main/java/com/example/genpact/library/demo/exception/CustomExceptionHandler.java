package com.example.genpact.library.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorResponseDTO> handleApplicationException(final Exception ex) {
		ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
		errorResponseDTO.setMessage("Internal Server Error");
		errorResponseDTO.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDTO);
	}

	@ExceptionHandler(value = ItemNotFoundException.class)
	public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(
			final ItemNotFoundException notFoundException) {
		ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
		errorResponseDTO.setMessage(notFoundException.getMessage());
		errorResponseDTO.setHttpStatus(HttpStatus.NOT_FOUND);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDTO);
	}

}
