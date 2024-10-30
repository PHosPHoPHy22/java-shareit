package ru.practicum.shareit.shareit.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.util.DefaultUriBuilderFactory;
import ru.practicum.shareit.shareit.client.BaseClient;
import ru.practicum.shareit.shareit.request.dto.ItemRequestDtoFromConsole;

@Service
public class RequestClient extends BaseClient {
    private static final String API_PREFIX = "/requests";

    @Autowired
    public RequestClient(@Value("${shareit-server.url}") String serverUrl, RestTemplateBuilder builder) {
        super(
                builder
                        .uriTemplateHandler(new DefaultUriBuilderFactory(serverUrl + API_PREFIX))
                        .requestFactory(() -> new HttpComponentsClientHttpRequestFactory())
                        .build()
        );
    }

    public ResponseEntity<Object> addItemRequestJpa(ItemRequestDtoFromConsole itemRequestDtoFromConsole, Long userId) {
        return post("", userId, itemRequestDtoFromConsole);
    }

    public ResponseEntity<Object> getItemRequestsUserId(Long userId) {
        return get(userId);
    }

    public ResponseEntity<Object> getItemRequestsAll(Long userId) {
        return get("/all", userId);
    }

    public ResponseEntity<Object> getItemRequestId(Long requestId, Long userId) {
        return get("/" + requestId, userId);
    }
}