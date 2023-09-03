package com.example.songe.service;

import com.example.songe.model.Board;

import java.util.List;

public interface BoardService {



    Integer getTotalBoardCount();

    List<Board> getBoards(int page, int pageSize);
}
