package com.example.demo;

import java.io.Serializable;
import java.util.List;

public interface BookDataDao extends Serializable {

    public List<BookData> search(String genre, String author, String title);
}
