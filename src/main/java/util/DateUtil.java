package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dayvson on 26/03/2017.
 */
public class DateUtil {

    public static String getDataFormatada(Date date){
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

    public static String getMesFormatado(Integer mes){
        switch (mes){
            case 1: return "Janeiro";
            case 2: return "Fevereiro";
            case 3: return "Março";
            case 4: return "Abril";
            case 5: return "Maio";
            case 6: return "Junho";
            case 7: return "Julho";
            case 8: return "Agosto";
            case 9: return "Setembro";
            case 10: return "Outubro";
            case 11: return "Novembro";
            case 12: return "Dezembro";
        }
        return "";
    }

}
