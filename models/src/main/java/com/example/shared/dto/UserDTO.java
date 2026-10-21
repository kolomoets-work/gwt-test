package com.example.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data // Генерирует геттеры, сеттеры, equals, hashCode и toString
@NoArgsConstructor // Обязательно для GWT RPC (нужен пустой конструктор)
@AllArgsConstructor // Дополнительный конструктор со всеми полями
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String email;
}