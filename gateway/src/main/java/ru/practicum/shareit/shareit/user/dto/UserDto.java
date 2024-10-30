package ru.practicum.shareit.shareit.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ru.practicum.shareit.shareit.validation.Marker;

@Data
public class UserDto {
    Long id;
    @NotNull(groups = Marker.AddUser.class)
    String name;
    @NotNull(groups = Marker.AddUser.class)
    @Email
    String email;
}