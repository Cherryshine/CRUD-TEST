package com.sparta.darakbang.entity;


import com.sparta.darakbang.dto.CardRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor // 기본생성자 생성 (엔티티는 기본생성자 필요)

public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardNumber;

    public Card(CardRequestDto requestDto) {
        this.cardNumber = requestDto.getCardNumber();
    }

    public void update(CardRequestDto requestDto){
        this.cardNumber = requestDto.getCardNumber();
    }
}
