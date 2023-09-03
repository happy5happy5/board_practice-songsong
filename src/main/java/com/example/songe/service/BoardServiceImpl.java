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
        List<Board> boards = boardMapper.getBoards(offset, pageSize);
        for (Board board : boards) {
            board.setReplies(boardMapper.getReplies(board.getId()));
        }
        return boards;
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
        Board boardByid = boardMapper.getBoardById(id);
        Long parent_board_id = boardByid.getParent_board_id();
        List<Board> boards = boardMapper.getBoardsByParentBoardId(id);
        List<Board> boards_parent = boardMapper.getBoardsByParentBoardId(parent_board_id);

        boolean canDelete = true;
        for (Board board : boards_parent) {
            if (!board.getIs_deleted()){
                canDelete = false;
                break;
            }
        }

        for (Board board : boards) {
            if (!board.getIs_deleted()){
                canDelete = false;
                break;
            }
        }

        if (canDelete) {
            boardMapper.deleteBoard(id);
        }else{
            boardMapper.updateBoard(id, new Board(true, id, "삭제되었습니다", "삭제되었습니다", "삭제되었습니다", "삭제되었습니다"));
        }
    }

    @Override
    public void createBoard(Board board) {
        boardMapper.createBoard(board);
    }
}
