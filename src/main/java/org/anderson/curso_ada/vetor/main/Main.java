package org.anderson.curso_ada.vetor.main;

import org.anderson.curso_ada.vetor.implementation.Supermarket;
import org.anderson.curso_ada.vetor.implementation.SupermarketImpl;

import java.util.Scanner;

public class Main {

    private final static int SIZE = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        Supermarket supermarket = new SupermarketImpl(SIZE);

        do {
            System.out.println("Shopping list");
            System.out.println("1 - add");
            System.out.println("2 - print");
            System.out.println("3 - delete");
            System.out.println("4 - out");
            System.out.println("Enter the option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter the product name: ");
                    String item = scanner.next();
                    supermarket.add(item);
                    break;
                case 2:
                    supermarket.print();
                    break;
                case 3:
                    System.out.println("Enter the product index: ");
                    int index = scanner.nextInt();
                    supermarket.delete(index);
                    break;
                case 4:
                    System.out.println("Leaving the program...");
                    break;
                default:
                    System.out.println("Option invalid. Please choose again.");
            }
        } while (option != 4);

        scanner.close();
    }
}