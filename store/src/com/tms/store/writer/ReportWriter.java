package com.tms.store.writer;

public interface ReportWriter {
    void write(String report);
    void writeError(String report);
}
