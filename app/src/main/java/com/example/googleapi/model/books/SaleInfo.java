package com.example.googleapi.model.books;

public class SaleInfo {
//    private Country country;
    private Saleability saleability;
    private boolean isEbook;
//    private SaleInfoListPrice listPrice;
    private SaleInfoListPrice retailPrice;
    private String buyLink;
//    private Offer[] offers;


    public Saleability getSaleability() {
        return saleability;
    }

    public void setSaleability(Saleability saleability) {
        this.saleability = saleability;
    }

    public boolean isEbook() {
        return isEbook;
    }

    public void setEbook(boolean ebook) {
        isEbook = ebook;
    }

    public SaleInfoListPrice getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(SaleInfoListPrice retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getBuyLink() {
        return buyLink;
    }

    public void setBuyLink(String buyLink) {
        this.buyLink = buyLink;
    }
}
