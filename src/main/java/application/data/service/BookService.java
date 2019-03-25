package application.data.service;

import application.data.model.Book;
import application.data.repository.BookRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private static final Logger logger = LogManager.getLogger(BookService.class);


    @Autowired
    private BookRepository bookRepository;

    public Book findOne(int bookId) {
        return bookRepository.findOne(bookId);
    }


    public List<Book> getListAllBooks() {
        try {
            return bookRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ArrayList<>();
        }
    }

    public Page<Book> getListBookByCategoryOrBookNameContaining(Pageable pageable, Integer categoryId, String bookName){
        return bookRepository.getListBookByCategoryOrBookNameContaining(pageable,categoryId,bookName);
    }



}
