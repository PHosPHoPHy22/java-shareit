package ru.practicum.shareit.user.repository;

import org.springframework.stereotype.Repository;
import ru.practicum.shareit.user.model.User;

import java.util.*;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private final Map<Long, User> users = new HashMap<>();
    private final Set<String> emails = new HashSet<>();

    private long id = 0;

    public long generateId() {
        return ++id;
    }

    @Override
    public User create(User user) {
        users.put(user.getId(), user);
        emails.add(user.getEmail());
        return user;
    }

    @Override
    public Optional<User> getById(long userId) {
        return Optional.ofNullable(users.get(userId));
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void deleteById(long userId, User user) {
        emails.remove(user.getEmail());
        users.remove(userId);
    }

    @Override
    public Set<String> getEmails() {
        return emails;
    }
}