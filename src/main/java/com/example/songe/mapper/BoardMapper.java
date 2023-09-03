package com.example.songe.mapper;

import com.example.songe.model.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("SELECT * FROM board WHERE parent_board_id IS NULL ORDER BY id DESC LIMIT #{offset}, #{pageSize}")
    List<Board> getBoards(int offset, int pageSize);

    @Select("SELECT * FROM board WHERE parent_board_id = #{parent_board_id} ORDER BY level, id DESC")
    List<Board> getReplies(Long parent_board_id);

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

    @Insert("INSERT INTO board (writer, password, title, content ,parent_board_id,parent_id,level) VALUES (#{writer}, #{password}, #{title}, #{content},#{parent_board_id},#{parent_id},#{level})")
    void createBoard(Board board);

    @Select("SELECT * FROM board WHERE parent_board_id = #{id}")
    List<Board> getBoardsByParentBoardId(Long id);

}
