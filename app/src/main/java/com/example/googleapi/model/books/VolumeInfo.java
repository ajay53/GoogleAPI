package com.example.googleapi.model.books;

public class VolumeInfo {
    private String title;
    private String subtitle;
    private String[] authors;
    private String publisher;
    private String publishedDate;
    private String description;
//    private IndustryIdentifier[] industryIdentifiers;
//    private ReadingModes readingModes;
    private Long pageCount;
//    private PrintType printType;
    private String[] categories;
    private Long averageRating;
    private Long ratingsCount;
    private MaturityRating maturityRating;
    private boolean allowAnonLogging;
    private String contentVersion;
//    private PanelizationSummary panelizationSummary;
    private ImageLinks imageLinks;
    private Language language;
    private String previewLink;
    private String infoLink;
    private String canonicalVolumeLink;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPageCount() {
        return pageCount;
    }

    public void setPageCount(Long pageCount) {
        this.pageCount = pageCount;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public Long getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Long averageRating) {
        this.averageRating = averageRating;
    }

    public Long getRatingsCount() {
        return ratingsCount;
    }

    public void setRatingsCount(Long ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public MaturityRating getMaturityRating() {
        return maturityRating;
    }

    public void setMaturityRating(MaturityRating maturityRating) {
        this.maturityRating = maturityRating;
    }

    public boolean isAllowAnonLogging() {
        return allowAnonLogging;
    }

    public void setAllowAnonLogging(boolean allowAnonLogging) {
        this.allowAnonLogging = allowAnonLogging;
    }

    public String getContentVersion() {
        return contentVersion;
    }

    public void setContentVersion(String contentVersion) {
        this.contentVersion = contentVersion;
    }

    public ImageLinks getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(ImageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

    public String getInfoLink() {
        return infoLink;
    }

    public void setInfoLink(String infoLink) {
        this.infoLink = infoLink;
    }

    public String getCanonicalVolumeLink() {
        return canonicalVolumeLink;
    }

    public void setCanonicalVolumeLink(String canonicalVolumeLink) {
        this.canonicalVolumeLink = canonicalVolumeLink;
    }
}
