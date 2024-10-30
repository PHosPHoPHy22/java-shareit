package ru.practicum.shareit.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ru.practicum.shareit.validation.Marker;

@Data
public class UserDto {
    private Long id;
    @NotNull(groups = Marker.AddUser.class)
    private String name;
    @NotNull(groups = Marker.AddUser.class)
    @Email
    private String email;
}