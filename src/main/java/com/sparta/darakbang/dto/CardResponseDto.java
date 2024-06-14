package com.sparta.darakbang.dto;

import com.sparta.darakbang.entity.Card;
import lombok.Getter;

@Getter
public class CardResponseDto { // (클라이언트가) 원하는 데이터만 반환

    private Long id;
    private String cardNumber;

    public CardResponseDto(Card card) {
        this.id = card.getId();
        this.cardNumber = card.getCardNumber();
    }
}
