package com.laza.BookLibrary.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class UserDto {
    private int id;
    private String user_name;
    private String email;
    private String password;

}
