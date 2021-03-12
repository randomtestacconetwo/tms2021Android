package com.tms.store.handler;

import com.tms.store.menu.MenuTree;

public class PrintOptionsHandler implements MenuSelectionHandler {
    private final MenuTree node;

    public PrintOptionsHandler(MenuTree node) {
        this.node = node;
    }

    @Override
    public void handle() {
        node.getChildrenNames().forEach(System.out::println);
        System.out.println("Or print exit to go back or finish");
        System.out.println("---------------------\n");
    }
}
