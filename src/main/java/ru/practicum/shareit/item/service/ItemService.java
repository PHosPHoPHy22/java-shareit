package ru.practicum.shareit.item.service;

import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.item.dto.UpdateItemDto;

import java.util.List;

public interface ItemService {
    ItemDto create(ItemDto itemDto, long userId);

    ItemDto update(long itemId, UpdateItemDto itemDto, long userId);

    ItemDto getById(long itemId);

    List<ItemDto> allItemsFromUser(long userId);

    List<ItemDto> search(String text);
}