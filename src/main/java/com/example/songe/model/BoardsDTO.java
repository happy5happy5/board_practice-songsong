package com.example.songe.model;

import com.example.songe.utils.Statics;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BoardsDTO {

    private List<Board> boards;
    private int currentPage;  // 현재 페이지
    private int totalPages;   // 전체 페이지 수
//    시작 페이지
    private int startPage;
//    끝 페이지
    private int endPage;

    private final int pageSize = Statics.PAGE_SIZE.getValue();
    private final int blockSize = Statics.BLOCK_SIZE.getValue();

    private int nextPage;
    private int prevPage;

    public BoardsDTO(List<Board> boards, int currentPage, int totalPages, int startPage, int endPage) {
        this.boards = boards;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.startPage = startPage;
        this.endPage = endPage;
        this.nextPage = Math.min(currentPage + blockSize, totalPages);
        this.prevPage = Math.max(currentPage - blockSize, 1);
    }


}
