import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        String data = scan.nextLine();
        System.out.println(calc(data));
    }

          public static String calc(String input) throws IOException {
          String[] arr = input.split(" ");

                int first = 0;
                boolean Rom1 = false;
                boolean Arab1 = false;

                if (arr.length > 3) {
                    throw new IOException();
                }


                switch (arr[0]) {
                    case "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X":
                        Roman roman1;
                        roman1 = Roman.valueOf(arr[0]);
                        first = Integer.parseInt(roman1.getConvers());
                        Rom1 = true;
                        break;

                    case "1", "2", "3", "4", "5", "6", "7", "8", "9", "10":
                        first = Integer.parseInt(arr[0]);
                        Arab1 = true;
                        break;
                    default:
                        throw new IOException();
                }

                int second = 0;
                boolean Rom2 = false;
                boolean Arab2 = false;

                switch (arr[2]) {
                    case "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X":
                        Roman roman2;
                        roman2 = Roman.valueOf(arr[2]);
                        second = Integer.parseInt(roman2.getConvers());
                        Rom2 = true;
                        break;

                    case "1", "2", "3", "4", "5", "6", "7", "8", "9", "10":
                        second = Integer.parseInt(arr[2]);
                        Arab2 = true;
                        break;
                    default:
                        throw new IOException();
                }

                String operator = arr[1];
                int result = 0;
                String plus = "+";
                String minus = "-";
                String div = "/";
                String mult = "*";

                if (operator.equals(plus)) {
                    result = first + second;
                } else if (operator.equals(minus)) {
                    result = first - second;
                } else if (operator.equals(div)) {
                    result = first / second;
                } else if (operator.equals(mult)){
                    result = first * second;
                }else throw new IOException();

                String[] rom = {"0","I","II","III","IV","V","VI","VII","VII","IX","X","XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX","XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX","XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL","XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L","LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX","LX","LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX","LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX","LXXXI","LXXXII","XC","C"};

                if (Rom1 == true && Rom2 == true && result == 0) {
                    throw new IOException();
                } else if (Rom1 == true && Arab2 == true) {
                    throw new IOException();
                } else if (Rom2 == true && Arab1 == true) {
                    throw new IOException();
                }

                String resultRow = String.valueOf(result);
                if (Rom1 == true && Rom2 == true) {
                    resultRow = rom[result];
                }
            return resultRow;
            }
        }

