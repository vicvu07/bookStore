package application.data.service;

import application.data.repository.BookImageRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookImageService {

    private static final Logger logger = LogManager.getLogger(BookImageService.class);

    @Autowired
    private BookImageService bookImageService;


}