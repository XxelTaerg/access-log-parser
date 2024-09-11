import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите 1-е число: ");
        int firstNumber = new Scanner(System.in).nextInt();

        System.out.println("Введите 2-е число: ");
        int secondNumber = new Scanner(System.in).nextInt();

        System.out.println("сумма: " + (firstNumber + secondNumber) );
        System.out.println("разность: " + (firstNumber - secondNumber) );
        System.out.println("произведение: " + (firstNumber * secondNumber) );
        double division = (double)firstNumber/secondNumber;
        System.out.println("частное : " + division );


    }
}
