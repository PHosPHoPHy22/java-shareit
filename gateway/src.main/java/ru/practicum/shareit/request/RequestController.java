package java.ru.practicum.shareit.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.ru.practicum.shareit.request.dto.RequestDto;

@Controller
@RequestMapping(path = "/requests")
@RequiredArgsConstructor
@Slf4j
@Validated
public class RequestController {
    private final RequestClient requestClient;

    @PostMapping
    public ResponseEntity<Object> createRequest(@Positive @RequestHeader("X-Sharer-User-Id") long userId,
                                                @RequestBody @Valid RequestDto requestDto) {
        return requestClient.createRequest(userId,requestDto);
    }

    @GetMapping
    public ResponseEntity<Object> getRequests(@Positive @RequestHeader("X-Sharer-User-Id") long userId) {
        return requestClient.getRequests(userId);
    }

    @GetMapping("{requestId}")
    public ResponseEntity<Object> getRequestById(@Positive @RequestHeader("X-Sharer-User-Id") long userId, @PathVariable Long requestId) {
        return requestClient.getRequestById(userId,requestId);
    }
}