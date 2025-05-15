package edu.estatuas.romansgohome;

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
        String[] romanSplit = romanClean.split("(CM)*(CD)*(XC)*(XL)*(IX)*(IV)*");

        // https://stackoverflow.com/questions/4662215/how-to-extract-a-substring-using-regex

        for(String operation : romanSplit){
            {
                try{
                    decimal += (RomanSymbols.valueOf(operation).getValue());
                } catch (IllegalArgumentException noResta) {

                    for(String numero : operation.split("")){
                        decimal += (RomanSymbols.valueOf(numero).getValue());
                    }
                }
            }
        }

        return decimal;
    }

}
