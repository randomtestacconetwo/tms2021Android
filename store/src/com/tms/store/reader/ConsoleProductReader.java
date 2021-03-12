package com.tms.store.reader;

import com.tms.store.exception.InvalidProductDataException;
import com.tms.store.model.Product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleProductReader implements ProductReader {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Product read() throws InvalidProductDataException {
        System.out.println("Enter id, name, type, price");
        try {
            Product p = new Product(scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextInt());
            if (p.getPrice() <= 0) {
                throw new InvalidProductDataException("Invalid data. Price should be more then 0");
            }
            return p;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw new InvalidProductDataException("Invalid data. Unable to read product info");
        }
    }

    @Override
    public int readId() throws InvalidProductDataException {
        System.out.println("Enter id");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw new InvalidProductDataException("Invalid data. Unable to read product id");
        }
    }

    @Override
    public int readCount() throws InvalidProductDataException {
        System.out.println("Enter count");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw new InvalidProductDataException("Invalid data. Unable to read product count");
        }
    }
}
