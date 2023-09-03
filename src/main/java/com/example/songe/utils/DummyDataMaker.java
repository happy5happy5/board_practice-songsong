package com.example.songe.utils;

import com.example.songe.mapper.BoardMapper;
import com.example.songe.model.Board;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Component
public class DummyDataMaker implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;
    private final BoardMapper boardMapper;
//    private static final int PAGE_SIZE = Statics.PAGE_SIZE.getValue();
    private static final Long TR = (long) Statics.DUMMY_DATA_SIZE.getValue();
//    private static final int BATCH_SIZE = TR.intValue();
    private static final int BATCH_SIZE2 = TR.intValue();

    @Autowired
    public DummyDataMaker(JdbcTemplate jdbcTemplate, BoardMapper boardMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.boardMapper = boardMapper;
    }

    @Override
    public void run(String... args){
        if (boardMapper.getTotalBoardCount() < 100) {
            List<Board> boards = new ArrayList<>();
            for (int i = 1; i <= TR; i++) {
                Board board = new Board();
                board.setId(i);
                board.setWriter("writer" + i);
                board.setPassword("password" + i);
                board.setTitle("title" + i);
                board.setContent("content" + i);
                boards.add(board);
            }
            batchInsertBoards(boards);
            System.out.println("DummyDataMaker.run");
        }

    }


    private void batchInsertBoards(List<Board> boards) {
        String sql = "INSERT INTO board (id, writer, password, title, content) VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(@NotNull PreparedStatement preparedStatement, int i) throws SQLException {
                Board board = boards.get(i);
                preparedStatement.setLong(1, board.getId());
                preparedStatement.setString(2, board.getWriter());
                preparedStatement.setString(3, board.getPassword());
                preparedStatement.setString(4, board.getTitle());
                preparedStatement.setString(5, board.getContent());
            }

            @Override
            public int getBatchSize() {
                return BATCH_SIZE2;
            }
        });
    }
}
