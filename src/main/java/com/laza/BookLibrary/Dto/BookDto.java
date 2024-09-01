package com.laza.BookLibrary.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {
    private int id;
    private String title;
    private String auther;
    private String isbn;
    private int publishedYear;


}
