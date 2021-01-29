package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookDataRepository bookDataRepository;

    @Autowired
    private BookDataDaoImpl bookDataDaoImpl;


    //全件検索
    public List<BookData> findAll(){
        return bookDataRepository.findAll();
    }

    //該当のID見つける
    public Optional<BookData> findById(long isbn) {
        return bookDataRepository.findById(isbn);
    }

    //保存
    public BookData save(BookData bookData) {
        return bookDataRepository.saveAndFlush(bookData);
    }

    //検索
    public List<BookData> search(String genre, String author, String title){

        List<BookData> result = new ArrayList<BookData>();

        //すべてブランクだった場合は全件検索する
        if ("".equals(genre) && "".equals(author) && "".equals(title)){
            result = bookDataRepository.findAll();
        }
        else {
            //上記以外の場合、BookDataDaoImplのメソッドを呼び出す
            result = bookDataDaoImpl.search(genre, author, title);
        }
        return result;
    }
}
