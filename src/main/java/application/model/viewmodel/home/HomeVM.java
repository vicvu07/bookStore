package application.model.viewmodel.home;

import application.model.viewmodel.common.BookVM;
import application.model.viewmodel.common.CategoryVM;

import java.util.Date;
import java.util.List;

public class HomeVM {
    private List<BookVM> bookVMList;
    private List<CategoryVM> categoryVMList;
    private String keyWord;

    public List<BookVM> getBookVMList() {
        return bookVMList;
    }

    public void setBookVMList(List<BookVM> bookVMList) {
        this.bookVMList = bookVMList;
    }

    public List<CategoryVM> getCategoryVMList() {
        return categoryVMList;
    }

    public void setCategoryVMList(List<CategoryVM> categoryVMList) {
        this.categoryVMList = categoryVMList;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
