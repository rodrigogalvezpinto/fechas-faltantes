package com.desafio.uno.gdd.fecha.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RequestFecha implements Serializable{
	//modificar
	private Long id;
    private String fechaCreacion;
    private String fechaFin;
    private List<LocalDate> fechas;

}
