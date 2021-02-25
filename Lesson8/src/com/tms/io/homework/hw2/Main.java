package com.tms.io.homework.hw2;

import com.tms.io.input.TmsReader;
import com.tms.io.input.TmsScannerFileReader;
import com.tms.io.output.TmsFileWriter;
import com.tms.io.output.TmsWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        TmsReader reader = createReader(new Scanner(System.in));
        String text = new String(reader.readAll());
        TextFormatter tf = new TextFormatter();
        String result = tf.convertText(text);
        TmsWriter writer = new TmsFileWriter("Lesson8/resources/hw2_out.txt");
        writer.write(result);
    }

    private static TmsReader createReader(Scanner scanner) {
        try {
            return new TmsScannerFileReader(scanner.nextLine());
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            return createReader(scanner);
        }
    }
}
