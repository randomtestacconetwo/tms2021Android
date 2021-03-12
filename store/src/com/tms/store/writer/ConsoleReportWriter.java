package com.tms.store.writer;

public class ConsoleReportWriter implements ReportWriter {
    @Override
    public void write(String report) {
        System.out.println(report);
    }

    @Override
    public void writeError(String report) {
        System.err.println(report);
    }
}
