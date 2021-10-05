package com.devsuperior.bds04.controllers.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String fiedlName;
	private String message;
	
	public FieldMessage() {
	}

	public FieldMessage(String fiedlName, String message) {
		super();
		this.fiedlName = fiedlName;
		this.message = message;
	}

	public String getFiedlName() {
		return fiedlName;
	}

	public void setFiedlName(String fiedlName) {
		this.fiedlName = fiedlName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}