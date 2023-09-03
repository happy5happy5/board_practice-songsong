package com.example.songe.service;

import com.example.songe.model.Board;

import java.util.List;

public interface BoardService {



    Integer getTotalBoardCount();

    List<Board> getBoards(int page, int pageSize);

    Board getBoardById(Long id);

    void updateBoard(Long id, Board updatedBoard);

    boolean checkPassword(Long id, String password);

    void deleteBoard(Long id);

    void createBoard(Board board);
}
