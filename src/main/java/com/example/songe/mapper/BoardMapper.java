package com.example.songe.mapper;

import com.example.songe.model.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {



    @Select("SELECT * FROM board ORDER BY id DESC LIMIT #{offset}, #{pageSize}")
    List<Board> getBoards(int offset, int pageSize);

    @Select("SELECT COUNT(*) FROM board")
    Integer getTotalBoardCount();

    @Select("SELECT * FROM board WHERE id = #{id}")
    Board getBoardById(Long id);

    @Update("UPDATE board SET title = #{updatedBoard.title},writer=#{updatedBoard.writer} ,content = #{updatedBoard.content},password=#{updatedBoard.password} WHERE id = #{id}")
    void updateBoard(Long id, Board updatedBoard);

    @Select("SELECT COUNT(*) FROM board WHERE id = #{id} AND password = #{password}")
    boolean checkPassword(Long id, String password);

    @Delete("DELETE FROM board WHERE id = #{id}")
    void deleteBoard(Long id);

    @Insert("INSERT INTO board (writer, password, title, content) VALUES (#{writer}, #{password}, #{title}, #{content})")
    void createBoard(Board board);
}
