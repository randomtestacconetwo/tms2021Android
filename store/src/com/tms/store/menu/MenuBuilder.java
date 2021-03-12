package com.tms.store.menu;

import com.tms.store.Accounting;
import com.tms.store.Shop;
import com.tms.store.handler.accounting.CalculateAvgProductPriceByTypeHandler;
import com.tms.store.handler.accounting.CalculateAvgProductPriceHandler;
import com.tms.store.handler.accounting.GetProductTypesHandler;
import com.tms.store.handler.accounting.GetTotalProductsCountHandler;
import com.tms.store.handler.shop.*;
import com.tms.store.model.ProductOrder;
import com.tms.store.reader.ProductReader;
import com.tms.store.writer.ReportWriter;

public class MenuBuilder {
    private final Shop shop;
    private final Accounting accounting;
    private final ProductReader reader;
    private final ReportWriter writer;

    public MenuBuilder(Shop shop, Accounting accounting, ProductReader reader, ReportWriter writer) {
        this.shop = shop;
        this.accounting = accounting;
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * @return Menu tree for shop application. Contains shop operations, accounting operations
     */
    public MenuTree buildShopTree() {
        //main menu
        MenuTree rootNode = new MenuTree("Choose option", null);
        rootNode.addChild(new MenuTree("0: Add product", rootNode, new AddProductHandler(shop, reader, writer)));
        rootNode.addChild(new MenuTree("1: Edit product", rootNode, new EditProductHandler(shop, reader, writer)));
        rootNode.addChild(new MenuTree("2: Remove product", rootNode, new RemoveProductHandler(shop, reader, writer)));
        MenuTree displayNode = new MenuTree("3: DisplayProducts product", rootNode);
        rootNode.addChild(displayNode);
        rootNode.addChild(new MenuTree("4: Buy product", rootNode, new BuyProductHandler(shop, reader, writer)));
        rootNode.addChild(new MenuTree("5: Add product quantity", rootNode, new AddProductQuantityHandler(shop, reader, writer)));
        MenuTree accountingNode = new MenuTree("6: Accounting", rootNode);
        rootNode.addChild(accountingNode);

        //display products menu
        displayNode.addChild(new MenuTree("0: By price ascending", displayNode,
                new DisplayProductsHandler(shop, ProductOrder.PRICE_ASC, writer)));
        displayNode.addChild(new MenuTree("1: By price descending", displayNode,
                new DisplayProductsHandler(shop, ProductOrder.PRICE_DESC, writer)));
        displayNode.addChild(new MenuTree("2: By natural order", displayNode,
                new DisplayProductsHandler(shop, ProductOrder.LINKED, writer)));

        //accounting menu
        accountingNode.addChild(new MenuTree("0: Get product types", accountingNode, new GetProductTypesHandler(accounting, writer)));
        accountingNode.addChild(new MenuTree("1: Get total products count", accountingNode, new GetTotalProductsCountHandler(accounting, writer)));
        accountingNode.addChild(new MenuTree("2: Get avg product price", accountingNode, new CalculateAvgProductPriceHandler(accounting, writer)));
        accountingNode.addChild(new MenuTree("3: Get avg product price by type", accountingNode, new CalculateAvgProductPriceByTypeHandler(accounting, writer)));
        return rootNode;
    }
}
