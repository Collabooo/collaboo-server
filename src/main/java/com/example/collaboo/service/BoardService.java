// BoardService.java
package com.example.collaboo.service;

import com.example.collaboo.domain.Board;
import com.example.collaboo.dto.BoardDTO;
import com.example.collaboo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public void createBoard(BoardDTO boardDTO) {
        Board board = new Board();
        board.setTitle(boardDTO.getTitle());
        board.setCategory(boardDTO.getCategory());
        board.setCode(boardDTO.getCode());
        board.setDescription(boardDTO.getDescription());

        boardRepository.save(board);
    }
}
