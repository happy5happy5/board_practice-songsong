package com.example.songe.controller;

import com.example.songe.model.Board;
import com.example.songe.model.BoardsDTO;
import com.example.songe.service.BoardService;
import com.example.songe.utils.Statics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        System.out.println("[Controller GET /list]  getBoards() called");
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

    // Controller
    @GetMapping("/view/{id}")
    public String viewBoard(@PathVariable Long id, Model model, @RequestParam(name = "error", required = false) String error) {
        System.out.println("[Controller GET /board/view/{id}]  viewBoard() called");
        Board board = boardService.getBoardById(id); // boardService에서 해당 게시물 가져오기

        model.addAttribute("board", board);
        model.addAttribute("error", error);

        return "board/view";
    }

    // Controller
    @GetMapping("/edit/{id}")
    public String editBoard(@PathVariable Long id, Model model, @RequestParam(name = "error", required = false) String error ) {
        Board board = boardService.getBoardById(id); // boardService에서 해당 게시물 가져오기
        model.addAttribute("board", board);
        model.addAttribute("error", error);
        return "board/edit";
    }


    @PostMapping("/edit/{id}")
    public String updateBoard(@PathVariable Long id, Board updatedBoard, @RequestParam("password_old") String password) {

        // 비밀번호 확인을 서비스에서 처리
        if (boardService.checkPassword(id, password)) {
            // 비밀번호가 일치하면 게시물 삭제 후 목록 페이지로 리다이렉트
            boardService.updateBoard(id, updatedBoard);
            return "redirect:/board/view/{id}";
        } else {
            // 비밀번호가 일치하지 않으면 오류 메시지와 함께 삭제 페이지로 다시 이동
            return "redirect:/board/edit/{id}?error=invalidPassword";
        }
//        boardService.updateBoard(id, updatedBoard); // boardService에서 게시물 업데이트 처리
//        return "redirect:/board/view/{id}"; // 수정 후 상세보기 페이지로 이동
    }

    @PostMapping("/delete/{id}")
    public String deleteBoard(@PathVariable Long id, @RequestParam("password") String password) {
        // 비밀번호 확인을 서비스에서 처리
        if (boardService.checkPassword(id, password)) {
            // 비밀번호가 일치하면 게시물 삭제 후 목록 페이지로 리다이렉트
            boardService.deleteBoard(id);
            return "redirect:/board/list";
        } else {
            // 비밀번호가 일치하지 않으면 오류 메시지와 함께 삭제 페이지로 다시 이동
            return "redirect:/board/view/{id}?error=invalidPassword";
        }
    }

    @GetMapping("/create")
    public String createBoard() {
        System.out.println("[Controller GET /board/create]  createBoard() called");
        return "board/create";
    }

    @PostMapping("/create")
    public String createBoard(Board board) {
        System.out.println("[Controller POST /board/create]  createBoard() called");
        boardService.createBoard(board);
        return "redirect:/board/list";
    }
}
