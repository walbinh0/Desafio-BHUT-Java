package br.com.projetobhut.helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataFormat {

	public static String DataParaString(Date date) {

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String dataFormatada = dateFormat.format(date);
		return dataFormatada;
	}
}
