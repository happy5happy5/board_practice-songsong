package com.example.songe.mapper;

import com.example.songe.model.Board;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {



    @Select("SELECT * FROM board ORDER BY id DESC LIMIT #{offset}, #{pageSize}")
    List<Board> getBoards(int offset, int pageSize);

    @Select("SELECT COUNT(*) FROM board")
    Integer getTotalBoardCount();
}
