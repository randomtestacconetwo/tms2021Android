package com.tms.store;

import com.tms.store.exception.UnknownMenuOptionSelectedException;
import com.tms.store.menu.MenuBuilder;
import com.tms.store.menu.MenuTree;
import com.tms.store.reader.ProductReader;
import com.tms.store.reader.UserInputReader;
import com.tms.store.writer.ReportWriter;

public class StoreApplication {
    private final Shop shop;
    private final Accounting accounting;
    private final ProductReader productReader;
    private final ReportWriter writer;
    private final UserInputReader userInputReader;

    public StoreApplication(Shop shop, Accounting accounting,
                            ProductReader productReader, ReportWriter writer, UserInputReader userInputReader) {
        this.shop = shop;
        this.accounting = accounting;
        this.productReader = productReader;
        this.writer = writer;
        this.userInputReader = userInputReader;
    }

    public void start() {
        MenuTree tree = new MenuBuilder(shop, accounting, productReader, writer).buildShopTree();
        while (tree != null) {
            tree.handle();
            String input = userInputReader.readUserInput();
            try {
                tree = tree.select(input);
            } catch (UnknownMenuOptionSelectedException e) {
                writer.writeError(e.getMessage());
            }
            if (tree != null) {
                if (!tree.hasChildren()) {
                    tree.handle();
                    tree = tree.getParent();
                }
            }
        }
    }
}
