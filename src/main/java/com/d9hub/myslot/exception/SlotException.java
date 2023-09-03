package com.d9hub.myslot.exception;

public class SlotException extends Exception{

private static final long serialVersionUID = 1L;
	
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public SlotException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public SlotException() {
		super();
	}

}
