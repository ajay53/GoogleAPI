package com.example.googleapi.utility;

import com.example.googleapi.model.books.Item;
import com.example.googleapi.model.books.Saleability;

public class Util {

    public static String getPrice(Item item) {
        if (item.getSaleInfo().getSaleability() == Saleability.FOR_SALE) {
            return "₹ " + item.getSaleInfo().getRetailPrice().getAmount();
        }
        return "Not For Sale";
    }
}
