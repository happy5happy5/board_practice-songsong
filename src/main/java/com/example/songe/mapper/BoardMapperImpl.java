package com.example.songe.mapper;

import com.example.songe.model.Board;

import java.util.List;

public class BoardMapperImpl implements BoardMapper{


    private final BoardMapper boardMapper;

    public BoardMapperImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }


    @Override
    public List<Board> getBoards(int offset, int pageSize) {
        return boardMapper.getBoards(offset, pageSize);
    }

    @Override
    public Integer getTotalBoardCount() {
        return boardMapper.getTotalBoardCount();
    }
}
