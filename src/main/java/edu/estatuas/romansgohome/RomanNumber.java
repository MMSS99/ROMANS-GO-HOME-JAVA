package edu.estatuas.romansgohome;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumber {
    private final String roman;

    public RomanNumber(String roman) {
        this.roman = roman;
    }

    public String cleanJunk(){
        return roman.replaceAll("[^MDCLXVI]", "");
    }

    public int toDecimal(){
        String romanClean = cleanJunk();
        int decimal = 0;
        Pattern pattern = Pattern.compile("(CM)*(CD)*(XC)*(XL)*(IX)*(IV)*");
        Matcher matcher = pattern.matcher(romanClean);

        ArrayList<String> restas = new ArrayList<>();
        while (matcher.find()) {
            if (!matcher.group().isEmpty()) {
                restas.add(matcher.group());
            }
        }

        String positivos = romanClean;
        StringBuilder negativos = new StringBuilder();
        if (!restas.isEmpty()) {
            for (String resta : restas) {
                positivos = positivos.replace(resta, "");
                negativos.append(resta);
            }

            boolean restando = true;
            for (String numero : negativos.toString().split("")){
                decimal += (!restando) ?  (RomanSymbols.valueOf(numero).getValue()) : -(RomanSymbols.valueOf(numero).getValue());
                restando = !restando;
            }
        }

        if (!positivos.isEmpty()) {
            for (String numero : positivos.split("")) {
                decimal += (RomanSymbols.valueOf(numero).getValue());
            }
        }

        return decimal;
    }

}
