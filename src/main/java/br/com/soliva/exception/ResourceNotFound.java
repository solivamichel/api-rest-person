package br.com.soliva.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFound(String exception) {
		super(exception);
	}
}
