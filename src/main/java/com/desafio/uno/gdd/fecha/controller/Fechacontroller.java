package com.desafio.uno.gdd.fecha.controller;


import com.desafio.uno.gdd.fecha.dto.RequestFecha;
import com.desafio.uno.gdd.fecha.dto.ResponseFecha;
import com.desafio.uno.gdd.fecha.model.service.IFechaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;



@RestController
@RequestMapping("api/v1/fechas")
@Slf4j
public class Fechacontroller {
	
	private Map<String, Object> response;
	
	private final IFechaService iFechaService;
	
	public Fechacontroller(IFechaService iFechaService) {
		this.iFechaService = iFechaService;
	}

	@PostMapping("/ingresar")
	public ResponseEntity<ResponseFecha> ingresoFechas(@RequestBody RequestFecha requestFecha ) throws ParseException {
		try{
			log.info("[CONTROLLER] - Generando ingreso Request con body {}" + requestFecha);

			if (requestFecha == null){
				return new ResponseEntity<>(null,HttpStatus.BAD_GATEWAY);
			}

			return new ResponseEntity<>(iFechaService.ingresoRangoFechas(requestFecha),HttpStatus.OK);

		}catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
