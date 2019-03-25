package application.data.repository;

import application.data.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book,Integer> {
    @Query("select count(p.id) from dbo_book p")
    long getTotalBooks();

    @Query("SELECT p FROM dbo_book p " +
            "WHERE (:categoryId IS NULL OR (p.categoryId = :categoryId))" +
            "AND (:bookName IS NULL OR UPPER(p.name) LIKE CONCAT('%',UPPER(:bookName),'%'))")
    Page<Book> getListBookByCategoryOrBookNameContaining(Pageable pageable, @Param("categoryId") Integer categoryId, @Param("bookName") String bookName);

}
