package com.mastercraft.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseStructure<T> {
	private int status;
	private String message;
	private T data;
}
