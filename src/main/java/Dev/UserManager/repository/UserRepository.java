package dev.usermanager.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import dev.usermanager.model.User;

@Repository
public class UserRepository
{
    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);
    private final List<User> users = new ArrayList<>();

    public List<User> findAll()
    {
        return users;
    }

    public Optional<User> findByUsername(String Username)
    {
        return users.stream().filter(u ->
             u.getUsername().toLowerCase()
             .equals(Username.toLowerCase())).
             findFirst();
    }

    public void save(User user)
    {
        users.add(user);
        logger.info("Registered User: User --> '{}' Password --> '{}' Status --> Success", user.getUsername(), user.getPassword());
    }
}
