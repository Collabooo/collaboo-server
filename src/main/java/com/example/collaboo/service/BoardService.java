// BoardService.java
package com.example.collaboo.service;

import com.example.collaboo.domain.Board;
import com.example.collaboo.dto.BoardDTO;
import com.example.collaboo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<BoardDTO> getAllBoards() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    private BoardDTO convertToResponseDTO(Board board) {
        BoardDTO responseDTO = new BoardDTO();
        responseDTO.setTitle(board.getTitle());
        responseDTO.setCategory(board.getCategory());
        responseDTO.setCode(board.getCode());
        responseDTO.setDescription(board.getDescription());
        return responseDTO;
    }
    public void updateBoard(Long boardId, BoardDTO boardDTO) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));
        board.setTitle(boardDTO.getTitle());
        board.setCategory(boardDTO.getCategory());
        board.setCode(boardDTO.getCode());
        board.setDescription(boardDTO.getDescription());

        boardRepository.save(board);
    }
    public void deleteBoard(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));
        boardRepository.delete(board);
    }
}
