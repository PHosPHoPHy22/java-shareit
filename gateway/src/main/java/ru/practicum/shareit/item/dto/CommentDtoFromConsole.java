package ru.practicum.shareit.item.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CommentDtoFromConsole {
    @NotEmpty
    private String text;
    private long userId;
    private long itemId;
}