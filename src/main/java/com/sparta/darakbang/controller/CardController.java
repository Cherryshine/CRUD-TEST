package com.sparta.darakbang.controller;


import com.sparta.darakbang.dto.CardRequestDto;
import com.sparta.darakbang.dto.CardResponseDto;
import com.sparta.darakbang.entity.Card;
import com.sparta.darakbang.service.CardService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    // create
    @PostMapping("/cards") // http://localhost:8080/api/cards POST
    public ResponseEntity<Card> createCard(@RequestBody CardRequestDto request) {
        // { cardNumber:" 16자리 "}
        return ResponseEntity.ok(cardService.createCard(request));
    }

    // read
    @GetMapping("/cards")
    public ResponseEntity<List<CardResponseDto>> getCards() {
        return ResponseEntity.ok(cardService.getCards());
    }

    @GetMapping("/cards/{cardId}")
    public ResponseEntity<CardResponseDto> getCard(@PathVariable Long cardId) {
        return ResponseEntity.ok(cardService.getCard(cardId));
    }

    // update
    @PutMapping("/cards/{cardId}")
    public ResponseEntity<CardResponseDto> updateCard(@PathVariable Long cardId, @RequestBody CardRequestDto request) {
        cardService.updateCard(cardId, request);
        return ResponseEntity.ok(cardService.getCard(cardId));
    }

    // delete
    @DeleteMapping("/cards/{cardId}")
    public ResponseEntity<Void> delete(@PathVariable Long cardId) {
        cardService.deleteCard(cardId);
        return ResponseEntity.noContent().build();
    }

}
