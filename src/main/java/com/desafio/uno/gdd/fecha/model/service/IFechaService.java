package com.desafio.uno.gdd.fecha.model.service;

import com.desafio.uno.gdd.fecha.dto.RequestFecha;
import com.desafio.uno.gdd.fecha.dto.ResponseFecha;

import java.text.ParseException;

public interface IFechaService {

	public ResponseFecha ingresoRangoFechas(RequestFecha requestFecha) throws ParseException;
}
