package application.model.viewmodel.common;

import java.util.Date;
import java.util.List;

public class BookVM {
    private int id;
    private String categoryName;
    private String name;
    private String shortDesc;
    private String mainImage;
    private Double price;
    private Date createdDate;
    private int publishedYear;
    private Double discount;
    private List<BookVM> bookImageVMList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public List<BookVM> getBookImageVMList() {
        return bookImageVMList;
    }

    public void setBookImageVMList(List<BookVM> bookImageVMList) {
        this.bookImageVMList = bookImageVMList;
    }
}
