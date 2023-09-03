package com.example.songe.controller;

import com.example.songe.model.Board;
import com.example.songe.model.BoardsDTO;
import com.example.songe.service.BoardService;
import com.example.songe.utils.Statics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;


    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public String getBoards(Model model, @RequestParam(name = "page", defaultValue = "1") int page) {
        int pageSize = Statics.PAGE_SIZE.getValue(); // PAGE_SIZE를 사용하여 페이지당 게시물 수 가져오기
        int blockSize = Statics.BLOCK_SIZE.getValue(); // BLOCK_SIZE를 사용하여 블록당 페이지 수 가져오기
        int totalPosts = boardService.getTotalBoardCount(); // 전체 게시물 수
        // 페이지 관련 정보 계산
        int totalPages = (int) Math.ceil((double) totalPosts / pageSize);
//        현재 페이지에 따라 시작 페이지와 끝 페이지 계산
        int startPage = (page - 1) / blockSize * blockSize + 1;
        int endPage = Math.min(startPage + blockSize, totalPages);

        // 현재 페이지에 해당하는 게시물 목록 가져오기
        List<Board> boards = boardService.getBoards(page, pageSize);


        // BoardsDTO를 생성하여 데이터를 담아서 모델에 추가
        BoardsDTO boardsDTO = new BoardsDTO(boards, page, totalPages, startPage, endPage);
        model.addAttribute("boardsDTO", boardsDTO);
//zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz
        return "board/list"; // Thymeleaf 템플릿 파일의 경로를 반환합니다.
    }


}
