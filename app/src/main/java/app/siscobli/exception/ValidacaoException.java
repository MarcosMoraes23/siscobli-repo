package app.siscobli.exception;

import app.siscobli.dto.BasicResponseDTO;

public class ValidacaoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private BasicResponseDTO basicResponse;

	public ValidacaoException(BasicResponseDTO basicResponse) {
		this.basicResponse = basicResponse;
	}
	
	public ValidacaoException(BasicResponseDTO basicResponse, Throwable t) {
		super(t);
		this.basicResponse = basicResponse;
	}

	public BasicResponseDTO getBasicResponse() {
		return basicResponse;
	}

}
