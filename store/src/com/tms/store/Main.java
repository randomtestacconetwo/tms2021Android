package com.tms.store;

import com.tms.store.reader.ConsoleProductReader;
import com.tms.store.reader.ConsoleUserInputReader;
import com.tms.store.writer.ConsoleReportWriter;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        new StoreApplication(shop,
                new Accounting(shop),
                new ConsoleProductReader(),
                new ConsoleReportWriter(),
                new ConsoleUserInputReader()).start();
    }
}
