package com.tms.store.reader;

import com.tms.store.exception.InvalidProductDataException;
import com.tms.store.model.Product;

public interface ProductReader {
    Product read() throws InvalidProductDataException;

    int readId() throws InvalidProductDataException;

    int readCount() throws InvalidProductDataException;
}
