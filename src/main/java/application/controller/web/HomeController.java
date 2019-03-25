package application.controller.web;

import application.data.model.Book;
import application.data.model.Category;
import application.data.service.BookService;
import application.data.service.CategoryService;
import application.model.viewmodel.common.BookVM;
import application.model.viewmodel.common.CategoryVM;
import application.model.viewmodel.home.HomeVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/")
    public String home(Model model,
                       @Valid @ModelAttribute("bookname") BookVM bookName,
                       @RequestParam(name = "categoryId", required = false) Integer categoryId,
                       @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                       @RequestParam(name = "size", required = false, defaultValue = "12") Integer size,
                       @RequestParam(name = "sortByPrice", required = false) String sort,
                       HttpServletResponse response,
                       HttpServletRequest request) {

        HomeVM vm = new HomeVM();
        /**
         * set list categoryVM
         */
        List<Category> categoryList = categoryService.getListAllCategories();
        List<CategoryVM> categoryVMList = new ArrayList<>();

        for (Category category : categoryList) {
            CategoryVM categoryVM = new CategoryVM();
            categoryVM.setId(category.getId());
            categoryVM.setName(category.getName());
            categoryVM.setShortDesc(category.getShortDesc());
            category.setCreatedDate(category.getCreatedDate());
            categoryVMList.add(categoryVM);
        }

        /**
         * set list bookVM
         */
        Sort sortable = new Sort(Sort.Direction.ASC, "id");
        if (sort != null) {
            if (sort.equals("ASC")) {
                sortable = new Sort(Sort.Direction.ASC, "price");
            } else {
                sortable = new Sort(Sort.Direction.DESC, "price");
            }
        }

        Pageable pageable = new PageRequest(page, size, sortable);

        Page<Book> bookPage = null;

        if (categoryId != null) {
            bookPage = bookService.getListBookByCategoryOrBookNameContaining(pageable, categoryId, null);
            Category category = categoryService.findOne(categoryId);
            vm.setKeyWord(category.getName());
        } else if (bookName.getName() != null && !bookName.getName().isEmpty()) {
            bookPage = bookService.getListBookByCategoryOrBookNameContaining(pageable, null, bookName.getName().trim());
            vm.setKeyWord("Find with key: " + bookName.getName());
        } else {
            bookPage = bookService.getListBookByCategoryOrBookNameContaining(pageable, null, null);
        }

        List<BookVM> bookVMList = new ArrayList<>();

        for (Book book : bookPage.getContent()) {
            BookVM bookVM = new BookVM();
            if (book.getCategory() == null) {
                bookVM.setCategoryName("Unknown");
            } else {
                bookVM.setCategoryName(book.getCategory().getName());
            }
            bookVM.setId(book.getId());
            bookVM.setName(book.getName());
            bookVM.setMainImage(book.getMainImage());
            bookVM.setPrice(book.getPrice());
            bookVM.setShortDesc(book.getShortDesc());
            bookVM.setCreatedDate(book.getCreatedDate());
            bookVM.setDiscount(book.getDiscount());
            bookVM.setPublishedYear(book.getPublishedYear());

            bookVMList.add(bookVM);
        }

        /**
         * set vm
         */


        vm.setCategoryVMList(categoryVMList);
        vm.setBookVMList(bookVMList);


        model.addAttribute("vm", vm);
       /* model.addAttribute("page", bookPage);*/


        return "/home";

    }

}
   