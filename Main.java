import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();
        System.out.println("Введите выражение, числа до 10 и оператор (+, -, *, /). Например: 1 + 1. Также можно использовать римские числа! (I, V, X)");
        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine();
        System.out.println(calculator.calc(input));
    }
}

class Calculator {
    public String calc(String input) throws Exception {
        String[] splitText = input.split(" ");
        boolean rome = false;
        int letter1, letter2;

        int countLetters = 0;

        for (int i = 0; i < 3; i += 2) {
            try {
                Integer.parseInt(splitText[i]);
            } catch (NumberFormatException e) {
                rome = true;
                countLetters++;
            }
        }

        if (countLetters == 1) {
            throw new Exception("Числовой формат не складывается.");
        }

        letter1 = getLetter(splitText[0]);
        letter2 = getLetter(splitText[2]);
        int result = getResult(letter1, letter2, splitText[1]);
        String output = null;

        if (rome) {
            if (letter1 > 10 || letter1 < 0 || letter2 > 10 || letter2 < 0) {
                throw new Exception("Римские числа должны быть в диапазоне между 0 и 10.");
            } else if (result > 10) {
                String resultRoman = convertNumToRoman(result);
                output = resultRoman;
            } else output = getRomeNumber(result);
        } else if (!rome) {
            if (letter1 > 10 || letter1 < 0 || letter2 > 10 || letter2 < 0) {
                throw new Exception("Арабские числа должны быть в диапазоне между 0 и 10.");
            } else {
                output = String.valueOf(getLetter(String.valueOf(result)));
            }
        } 
        return output;
    }

    public Integer getLetter(String letter) throws Exception {
        int integer;

        try {
            integer = Integer.parseInt(letter);
        } catch (Exception e) {
            switch (letter.toLowerCase(Locale.ROOT)) {
                case "i":
                    integer = 1;
                    break;
                case "ii":
                    integer = 2;
                    break;
                case "iii":
                    integer = 3;
                    break;
                case "iv":
                    integer = 4;
                    break;
                case "v":
                    integer = 5;
                    break;
                case "vi":
                    integer = 6;
                    break;
                case "vii":
                    integer = 7;
                    break;
                case "viii":
                    integer = 8;
                    break;
                case "ix":
                    integer = 9;
                    break;
                case "x":
                    integer = 10;
                    break;
                default:
                    throw new Exception("Арабское число > 10");
            }
        }
        return integer;
    }

    public String getRomeNumber(int num) throws Exception {
        String romeNum;
        switch (num) {
            case 1:
                romeNum = "I";
                break;
            case 2:
                romeNum = "II";
                break;
            case 3:
                romeNum = "III";
                break;
            case 4:
                romeNum = "IV";
                break;
            case 5:
                romeNum = "V";
                break;
            case 6:
                romeNum = "VI";
                break;
            case 7:
                romeNum = "VII";
                break;
            case 8:
                romeNum = "VIII";
                break;
            case 9:
                romeNum = "IX";
                break;
            case 10:
                romeNum = "X";
                break;
            default:
                throw new Exception("Римское число <= 0.");
        }
        return romeNum;
    }

    public static String convertNumToRoman(int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
    }

    public Integer getResult(int letter1, int letter2, String s) throws Exception {
        int result;
        switch (s) {
            case "+":
                result = letter1 + letter2;
                break;
            case "-":
                result = letter1 - letter2;
                break;
            case "*":
                result = letter1 * letter2;
                break;
            case "/":
                result = letter1 / letter2;
                break;
            default:
                throw new Exception("Неверный формат операции.");
        }

        return result;
    }
}