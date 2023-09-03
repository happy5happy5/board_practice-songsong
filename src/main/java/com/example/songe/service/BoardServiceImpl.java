package com.example.songe.service;

import com.example.songe.model.Board;
import com.example.songe.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Autowired
    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }


    @Override
    public Integer getTotalBoardCount() {
        return boardMapper.getTotalBoardCount();
    }

    @Override
    public List<Board> getBoards(int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        return boardMapper.getBoards(offset, pageSize);
    }

    @Override
    public Board getBoardById(Long id) {
        return boardMapper.getBoardById(id);
    }

    @Override
    public void updateBoard(Long id, Board updatedBoard) {
        boardMapper.updateBoard(id, updatedBoard);
    }

    @Override
    public boolean checkPassword(Long id, String password) {
        return boardMapper.checkPassword(id, password);
    }

    @Override
    public void deleteBoard(Long id) {
        boardMapper.deleteBoard(id);
    }

    @Override
    public void createBoard(Board board) {
        boardMapper.createBoard(board);
    }
}
