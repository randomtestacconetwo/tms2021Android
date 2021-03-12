package com.tms.store.handler;

import com.tms.store.writer.ReportWriter;

public abstract class MenuSelectionExceptionHandler implements MenuSelectionHandler {
    private final ReportWriter writer;

    protected MenuSelectionExceptionHandler(ReportWriter writer) {
        this.writer = writer;
    }

    protected void handleException(Exception e) {
        writer.writeError(e.getMessage());
    }

    public ReportWriter getWriter() {
        return writer;
    }
}
