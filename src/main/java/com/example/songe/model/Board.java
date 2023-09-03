package com.example.songe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    private Long id;
    private String title;
    private String writer;
    private String content;
    private String password;
    private Long parent_board_id;
    private Long parent_id;
    private Integer level;
    private Boolean is_deleted;
    private String created_time;
    private String updated_time;

    private List<Board> replies;

    public Board(Boolean is_deleted, Long id, String title, String writer, String content, String password) {
        this.is_deleted = is_deleted;
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.password = password;
    }




}
