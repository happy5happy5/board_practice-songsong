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
}
