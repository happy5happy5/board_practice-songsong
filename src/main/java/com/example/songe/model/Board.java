package com.example.songe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    private Integer id;
    private String title;
    private String writer;
    private String content;
    private String password;
    private Integer level;
    private Integer parent_id;
    private String created_time;
    private String updated_time;
}
