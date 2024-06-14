package calc_project;

import java.util.List;
public class Calculations {
    public int operation(String operator, int firstArg, int secondArg){
        switch (operator) {
            case "+":
                firstArg += secondArg;
                break;
            case "-":
                firstArg -= secondArg;
                break;
            case "/":
                firstArg /= secondArg;
                break;
            case "*":
                firstArg *= secondArg;
                break;
        }
        return firstArg;
    }

    public String joinDigits(List<String> array){
        String digit = "";
        for (int j = 0; j<array.size();j++){
            digit += array.get(j);}
        return digit;
    }
}