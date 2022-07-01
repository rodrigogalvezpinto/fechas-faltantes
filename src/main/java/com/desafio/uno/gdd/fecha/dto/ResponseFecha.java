package com.desafio.uno.gdd.fecha.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class ResponseFecha {
	
	private Long id;
    private String fechaCreacion;
    private String fechaFin;
    private List<LocalDate> fechasFaltantes;

}
