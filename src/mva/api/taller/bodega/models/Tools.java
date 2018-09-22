package mva.api.taller.bodega.models;


import java.util.regex.Pattern;

public class Tools {
    public static final String SIGNO_DECIMAL = ".";
    public static String getLocationsOnIn(String locations) {
        String result = "";

        if (locations != null && locations.compareToIgnoreCase("X") != 0) {
            String[] partials = locations.split("_");
            result = " AND TRIM(A.Lmaisl) IN (";
            String invalues = "";
            for (String part : partials) {
                invalues += " '" + part + "',";
            }
            invalues = invalues.substring(0, invalues.length() - 1) + ")";
            result = result + invalues;
        }
        return result;
    }

    public static String cleanString(String value) {
        return (value != null && !value.isEmpty()) ? value.trim() : "";
    }



    public static String formatNumberToJDE(String number, int decimales, String signo)
    {
        String result = "";
        String separador = Pattern.quote(signo);
        String parts[] = number.split(separador);
        String entero =  parts.length>0?parts[0]:"0";
        String fraccion = parts.length>1?parts[1]:"0";
        result = entero + intToString(fraccion,decimales);
        return result;
   }


    public static String intToString(String num, int digits) {
        String output = num==null?"":num.trim();
        while (output.length() < digits) output += "0";
        return output;
    }

}
