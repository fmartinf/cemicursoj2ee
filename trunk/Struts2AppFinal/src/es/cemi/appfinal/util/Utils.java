package es.cemi.appfinal.util;

import java.util.Calendar;
import java.util.Date;

public final class Utils {

	/**
     * Método que calcula la fecha y hora actual
     * 
     * @return la fecha y hora actual
     */
    public static Date getCurrentDate() {
    	return Calendar.getInstance().getTime();
    }
}
