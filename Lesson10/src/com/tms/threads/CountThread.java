package com.tms.threads;

import com.tms.CommonResource;

public class CountThread extends Thread {
    private final CommonResource resource;

    public CountThread(String name, CommonResource resource) {
        super(name);
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.increment();
    }
}
