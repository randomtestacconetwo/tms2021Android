package com.tms.store.menu;

import com.tms.store.exception.UnknownMenuOptionSelectedException;
import com.tms.store.handler.MenuSelectionHandler;
import com.tms.store.handler.PrintOptionsHandler;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MenuTree {
    private final String name;
    private final MenuTree parent;
    private final MenuSelectionHandler handler;
    private List<MenuTree> children;

    public MenuTree(String name, MenuTree parent, MenuSelectionHandler handler) {
        this.handler = handler;
        this.name = name;
        this.parent = parent;
    }

    public MenuTree(String name, MenuTree parent) {
        this.handler = new PrintOptionsHandler(this);
        this.name = name;
        this.parent = parent;
    }

    public void addChild(MenuTree tree) {
        if (children == null) {
            children = new LinkedList<>();
        }
        children.add(tree);
    }

    public MenuTree select(String name) throws UnknownMenuOptionSelectedException {
        if ("exit".equalsIgnoreCase(name)) {
            return parent;
        }
        if (children == null) {
            return null;
        }
        for (MenuTree tree : children) {
            if (tree.name.startsWith(name)) {
                return tree;
            }
        }
        throw new UnknownMenuOptionSelectedException("There is no option " + name);
    }

    public void handle() {
        handler.handle();
    }

    public String getName() {
        return name;
    }

    public MenuTree getParent() {
        return parent;
    }

    public boolean hasChildren() {
        return children != null && !children.isEmpty();
    }

    public List<String> getChildrenNames() {
        return children.stream().map(node -> node.name).collect(Collectors.toList());
    }
}
