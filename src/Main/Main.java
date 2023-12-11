package Main;

import java.util.Locale;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

class Calculator {
    public double calculateWin(double betAmount, int rolledNumber) {

        if (rolledNumber < 3) {
            return betAmount * 1.25;
        } else if (rolledNumber >= 3 && rolledNumber <= 7) {
            double winAmount = betAmount * 1.25;
            double commission = winAmount * 0.05;
            return winAmount - commission;
        } else {
            double winAmount = betAmount * 2;
            double commission = winAmount * 0.1;
            return winAmount - commission;
        }

    }
    public int rollDice() {

        Random random = new Random();
        return random.nextInt(10) + 1; // Генерируем число от 1 до 10

    }
}

// Класс наследования
    class Game extends Calculator {
        
    }

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        Game game = new Game();

        double betAmount ; // Ставка
        int rolledNumber = game.rollDice() ; // Число, которое выпало

        System.out.println("Input your bet: "); //Ввод значения;

        try {  //Использование исключения при вводе не числа;
            betAmount = scanner.nextDouble();
        } catch (InputMismatchException e){
            System.out.println("Invalid input. Please enter a valid number.");
            return;
        }

        System.out.println("Your lucky number: " + rolledNumber);

        double winAmount = game.calculateWin(betAmount, rolledNumber);
        System.out.println("Winning amount: " + winAmount);

    }
}

