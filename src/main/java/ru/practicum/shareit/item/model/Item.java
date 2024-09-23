package ru.practicum.shareit.item.model;

import lombok.Data;
import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.user.model.User;

@Data
public class Item extends ItemDto {
    private long id;
    private String name;
    private String description;
    private Boolean available;
    private User owner;
}