package com.desafio.uno.gdd.fecha.model.service;

import com.desafio.uno.gdd.fecha.dto.RequestFecha;
import com.desafio.uno.gdd.fecha.dto.ResponseFecha;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
@Slf4j
public class IFechaServiceImpl implements IFechaService{

	@Override
	public ResponseFecha ingresoRangoFechas(RequestFecha requestFecha) throws ParseException {
		log.info("[IFechaServiceImpl] - metodo ingresoRangoFechas Service {}" + requestFecha);

		ResponseFecha rf = new ResponseFecha();
		List<LocalDate> fechas = getListaEntreFechas(requestFecha);

		rf.setId(requestFecha.getId());
		rf.setFechaCreacion(LocalDate.parse(requestFecha.getFechaCreacion()).withDayOfMonth(1).toString());
		rf.setFechaFin(LocalDate.parse(requestFecha.getFechaFin()).withDayOfMonth(1).toString());
		rf.setFechasFaltantes(fechasRandom(fechas));

		return rf;
	}

	public List<LocalDate> getListaEntreFechas(RequestFecha requestFecha) throws ParseException {
		log.info("[IFechaServiceImpl] - metodo getListaEntreFechas Service obteniendo fechas dentro de los rangos {}" + requestFecha);

		LocalDate fechaInicio = LocalDate.parse(requestFecha.getFechaCreacion()).withDayOfMonth(1);
		LocalDate fechaFin = LocalDate.parse(requestFecha.getFechaFin()).withDayOfMonth(1);
		List<LocalDate> fechas = new ArrayList<LocalDate>();
		List<LocalDate> fechasExcluidas = requestFecha.getFechas();

		long diferenciaMeses = ChronoUnit.MONTHS.between(fechaInicio, fechaFin.plusMonths(-1));

		for(int i = 1; i <= diferenciaMeses; i++){
			LocalDate localDate = fechaInicio.plusMonths(i);
			fechas.add(localDate);
		}
		fechas.removeIf(fecha -> fechasExcluidas.contains(fecha));
		
        return fechas;
    }


	public List<LocalDate> fechasRandom (List<LocalDate> listRandom){
		log.info("[IFechaServiceImpl] - metodo fechasRandom Service {}" + listRandom);

		List<LocalDate> fechaRandom = new ArrayList<LocalDate>();
		int count = 0;
		for (int i = 0; i < listRandom.size(); i++)
		{
			count = count+1;
			int index = (int)(Math.random() * listRandom.size());
			fechaRandom.add(listRandom.get(i).withDayOfMonth(1));

			if (count == 100){
				break;
			}
		}
		return fechaRandom;
	}

}
