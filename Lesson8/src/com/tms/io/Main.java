package com.tms.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tms.io.input.*;
import com.tms.io.model.Address;
import com.tms.io.model.Person;
import com.tms.io.output.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Main {
    private static final String RESOURCE_DIR = "Lesson8/resources/";
    private static final String INPUT_FILE = RESOURCE_DIR + "input.txt";
    private static final String OUTPUT_FILE = RESOURCE_DIR + "output.txt";
    private static final String WOLF_FILE = RESOURCE_DIR + "wolf.jpg";
    private static final String PERSON_JSON = RESOURCE_DIR + "Person.json";
    private static final String PERSON_DAT = RESOURCE_DIR + "person.data";

    private static final Person person = new Person(new Address("Blr", "Vtb"), 20, "Gleb", "Litvinov", "male");

    static {
        new File(WOLF_FILE).delete();
        new File(OUTPUT_FILE).delete();
        new File(PERSON_JSON).delete();
        new File(PERSON_DAT).delete();
    }

    public static void main(String[] args) throws IOException {
        Pattern pattern = Pattern.compile("(\\d+)([a-z]+)(\\d+)");
        Matcher matcher = pattern.matcher("111abasda222onetwothree");

        System.out.println(matcher.find());
        System.out.println(matcher.start());
        System.out.println(matcher.end());
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
        System.out.println(matcher.group(3));
        System.out.println(matcher.replaceAll("_WILDCARD_$2$3"));
        System.out.println(matcher.find());


//        doWork();
//        downloadFromInternet();
//        readWriteBinaryObject(person);
//        workingWithFiles();
//        readWriteToJSON(person);
//        workingWithArchives();
    }

    public static void doWork() throws IOException {
        System.out.println("FIS");
        TmsReader reader = new TmsFileInputStreamReader(INPUT_FILE);
        System.out.println(new String(reader.readAll()));
        printToConsoleLineByLine(reader);

        System.out.println("FileReader");
        reader = new TmsFileReader(INPUT_FILE);
        System.out.println(new String(reader.readAll()));
        printToConsoleLineByLine(reader);

        // reading using Scanner
        System.out.println("SCANNER");
        reader = new TmsScannerFileReader("input.txt");
        String all = new String(reader.readAll());
        System.out.println(all);

        int num = ((TmsScannerFileReader) reader).readInt();
        System.out.println(num);

//        what if not uncomment?
//        reader = new TmsScannerFileReader("input.txt");
        printToConsoleLineByLine(reader);

        // writing to the file using well-known PrintWriter
        TmsWriter writer = new TmsPrintWriterFileWriter(OUTPUT_FILE);
        writer.write("asdasdas\nsome text\n123 43 25.5\n");
        writer.write("text that\nwill overwrite text\nabove\n");

        writer = new TmsFileWriter(OUTPUT_FILE);
        writer.append("more text\n");
        writer = new TmsFileOutputStreamWriter(OUTPUT_FILE);
        writer.append("more more text");

//        what if uncomment?
//        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
//
    }

    public static void readWriteBinaryObject(Person p) throws IOException, ClassNotFoundException {
        System.out.println("BINARY OBJECT");
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("Lesson8/resources/person.data"));
        stream.writeObject(p);
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Lesson8/resources/person.data"));
        System.out.println(inputStream.readObject());
    }


    public static void downloadFromInternet() throws IOException {
        System.out.println("INTERNET");
        TmsReader reader = new TmsInputStreamUrlReader("https://www.imagetext.ru/pics_max/images_11886.jpg");
        byte[] image = reader.readAll();
        InputStream stream = new ByteArrayInputStream(image);
        Files.copy(stream, Paths.get(WOLF_FILE));
    }

    public static void readWriteToJSON(Person p) throws IOException {
        System.out.println("JSON");
        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
        File f = new File("Lesson8/resources/Person.json");

        mapper.writeValue(new File("Lesson8/resources/Person.json"), p);

        p = mapper.readValue(f, Person.class);
        System.out.println(p.toString());
    }

    public static void workingWithFiles() throws IOException {
        //create in memory
        File file = new File("");
        System.out.println(file.getAbsolutePath());
        file = new File("/Users/glitvinov");
        System.out.println(file.getAbsolutePath());
        file = new File("Lesson8");
        System.out.println(file.getAbsolutePath());
        file = new File("Lesson8/resources/tmp.txt");
        System.out.println(file.getAbsolutePath());
        file = new File("Lesson8", "anotherFile.txt");
        System.out.println(file.getAbsolutePath());
        file = new File(new File("Lesson8"), "tmp.txt");
        System.out.println(file.getAbsolutePath());

        //list files in dir
        System.out.println("List files in dir");
        file = new File("Lesson8").getAbsoluteFile();
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                System.out.print(f.getName());
                if (f.isDirectory()) {
                    System.out.print("\\");
                }
                System.out.print(", ");
            }
        }

        //delete create in filesystem + check if exists
        System.out.println("File " + file.getAbsolutePath() + " exists : " + file.exists());
        boolean result = file.createNewFile();
        System.out.println(result ? "File was created" : "File wasn't crated");
        System.out.println("File " + file.getAbsolutePath() + " exists : " + file.exists());
        result = file.delete();
        System.out.println(result ? "File was deleted" : "File wasn't deleted");
        System.out.println("File " + file.getAbsolutePath() + " exists : " + file.exists());
        file = new File(new File("Lesson8"), "resources");
        System.out.println("File " + file.getAbsolutePath() + " exists : " + file.exists());

        //rename
        file = new File("Lesson8/resources/test.txt");
        File renamed = new File("Lesson8/resources/test_renamed.txt");
        file.renameTo(renamed);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        renamed.renameTo(file);
        System.out.println("test.txt file size: " + file.length());
    }

    public static void workingWithArchives() throws IOException {
        System.out.println("ARCHIVES");
        //create archive and put couple files there
        try (ZipOutputStream outputStream = new ZipOutputStream(new FileOutputStream(RESOURCE_DIR + "tmp.zip"))) {
            ZipEntry entry = new ZipEntry("some_text.txt");
            outputStream.putNextEntry(entry);
            outputStream.write("some text".getBytes());
            outputStream.closeEntry();

            entry = new ZipEntry("another_text.txt");
            outputStream.putNextEntry(entry);
            outputStream.write("another text".getBytes());
            outputStream.closeEntry();
        }

        //read data from create archive
        try (ZipInputStream inputStream = new ZipInputStream(new FileInputStream(RESOURCE_DIR + "tmp.zip"))) {
            ZipEntry entry;
            while ((entry = inputStream.getNextEntry()) != null) {
                System.out.println("File name " + entry.getName());
                int b;
                StringBuilder builder = new StringBuilder();
                while ((b = inputStream.read()) != -1) {
                    builder.append((char) b);
                }
                System.out.println(builder.toString());
            }
        }
    }

    public static void printToConsoleLineByLine(TmsReader reader) throws IOException {
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            System.out.println("---------");
            System.out.println(line);
        }
    }

}
