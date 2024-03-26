// BoardController.java
package com.example.collaboo.controller;

import com.example.collaboo.dto.BoardDTO;
import com.example.collaboo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/boards")
    public ResponseEntity<String> createBoard(@RequestBody BoardDTO boardDTO) {
        try {
            boardService.createBoard(boardDTO);
            return ResponseEntity.ok("게시판 글이 성공적으로 작성되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("게시판 글 작성 중 오류가 발생했습니다.");
        }
    }

    @GetMapping("boards/lists")
    public ResponseEntity<List<BoardDTO>> getAllBoards() {
        List<BoardDTO> boards = boardService.getAllBoards();
        return ResponseEntity.ok(boards);
    }
}
