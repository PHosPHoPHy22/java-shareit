package ru.practicum.shareit.item.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.item.dto.ItemDtoForItemRequest;
import ru.practicum.shareit.item.dto.ItemDtoWithCommentAndDate;
import ru.practicum.shareit.item.model.Item;

import java.time.Instant;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {ItemMapperMapStructUtil.class}, imports = {
        Instant.class
})
public interface ItemMapperMapStruct {
    @Mapping(target = "request", qualifiedByName = {"ItemMapperMapStructUtil", "inRequestConvertor"}, source = "itemDto")
    @Mapping(target = "id", ignore = true)
    Item fromItemDto(ItemDto itemDto);

    @Mapping(target = "requestId", qualifiedByName = {"ItemMapperMapStructUtil", "requestConvertor"}, source = "request")
    ItemDto toItemDto(Item item);

    @Mapping(target = "requestId", qualifiedByName = {"ItemMapperMapStructUtil", "requestConvertor"}, source = "request")
    List<ItemDto> toItemDtoList(List<Item> itemList);

    @Mapping(target = "lastBooking", qualifiedByName = {"ItemMapperMapStructUtil", "getLastBooking"}, source = ("item"))
    @Mapping(target = "nextBooking", qualifiedByName = {"ItemMapperMapStructUtil", "getNearestBooking"}, source = "item")
    @Mapping(target = "request", qualifiedByName = {"ItemMapperMapStructUtil", "requestConvertor"}, source = "request")
    @Mapping(target = "comments", qualifiedByName = {"ItemMapperMapStructUtil", "getCommentsForItem"}, source = "id")
    ItemDtoWithCommentAndDate toItemDtoWithCommentAndDate(Item item);

    @Mapping(target = "lastBooking", qualifiedByName = {"ItemMapperMapStructUtil", "getLastBooking"}, source = "item")
    @Mapping(target = "nextBooking", qualifiedByName = {"ItemMapperMapStructUtil", "getNearestBooking"}, source = "item")
    @Mapping(target = "request", qualifiedByName = {"ItemMapperMapStructUtil", "requestConvertor"}, source = "request")
    @Mapping(target = "comments", qualifiedByName = {"ItemMapperMapStructUtil", "getCommentsForItem"}, source = "id")
    List<ItemDtoWithCommentAndDate> toItemsDtoWithCommentAndDate(List<Item> items);

    @Mapping(target = "itemId", expression = "java(item.getId())")
    @Mapping(target = "ownerId", expression = "java(item.getOwner().getId())")
    ItemDtoForItemRequest inItemDtoForItemRequest(Item item);
}