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
    public List<Board> getReplies(Long parent_board_id) {
        return boardMapper.getReplies(parent_board_id);
    }

    @Override
    public Integer getTotalBoardCount() {
        return boardMapper.getTotalBoardCount();
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

    @Override
    public List<Board> getBoardsByParentBoardId(Long id) {
        return boardMapper.getBoardsByParentBoardId(id);
    }

}
