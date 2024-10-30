package ru.practicum.shareit.booking.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingDtoFromConsole {
    @NotNull
    private Long itemId;
    @NotNull
    @FutureOrPresent
    private LocalDateTime start;
    @NotNull
    @FutureOrPresent
    private LocalDateTime end;

    @AssertTrue(message = "Начало бронирования не должно совпадать с концом бронирования")
    public boolean isStartEqualsEnd() {
        return !start.equals(end);
    }

    @AssertTrue(message = "Начало бронирования не должно быть позже конца бронирования")
    public boolean isStartBeforeEnd() {
        return start.isBefore(end);
    }
}