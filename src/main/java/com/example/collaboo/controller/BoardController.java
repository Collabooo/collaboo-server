// BoardController.java
package com.example.collaboo.controller;

import com.example.collaboo.dto.BoardDTO;
import com.example.collaboo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/boards")
@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/")
    public ResponseEntity<String> createBoard(@RequestBody BoardDTO boardDTO) {
        try {
            boardService.createBoard(boardDTO);
            return ResponseEntity.ok("게시판 글이 성공적으로 작성되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("게시판 글 작성 중 오류가 발생했습니다.");
        }
    }

    @GetMapping("/lists")
    public ResponseEntity<List<BoardDTO>> getAllBoards() {
        List<BoardDTO> boards = boardService.getAllBoards();
        return ResponseEntity.ok(boards);
    }

    @PutMapping("/{boardId}")
    public ResponseEntity<String> updateBoard(@PathVariable Long boardId, @RequestBody BoardDTO boardDTO) {
        try {
            boardService.updateBoard(boardId, boardDTO);
            return ResponseEntity.ok("게시글이 성공적으로 수정되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("게시글 수정 중 오류가 발생했습니다.");
        }
    }
}
