import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static char operation;
    static int result;

    public static void main (String[] args) {
        System.out.println("Введите выражение");
        String str = scanner.nextLine();
        char[] under_char = new char[10];
        for (int i = 0; i < str.length(); i++) {
            under_char[i] = str.charAt(i);
            if (under_char[i] == '+') {
                operation = '+';
            }
            if (under_char[i] == '-') {
                operation = '-';
            }
            if (under_char[i] == '*') {
                operation = '*';
            }
            if (under_char[i] == '/') {
                operation = '/';
            }
        }
        String under_charString = String.valueOf(under_char);
        String[] blacks = under_charString.split("[+-/*]");
        String str1 = blacks[0];
        String str2 = blacks[1];
        String str3 = str2.trim();

        if (NumRoman.romanToNumber(str1) != -1) {
            number1 = NumRoman.romanToNumber(str1);
            number2 = NumRoman.romanToNumber(str3);
            result = calculated(number1, number2, operation);
            String resultRoman = NumRoman.convertNumToRoman(result);
            System.out.println(resultRoman);
        } else {
            number1 = Integer.parseInt(str1);
            number2 = Integer.parseInt(str3);
            result = calculated(number1, number2, operation);
            System.out.println(result);
        }

    }

    public static int calculated(int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                throw new IllegalArgumentException("Не верный знак");
        }
        return result;
    }
}

