package dev.usermanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.usermanager.repository.UserRepository;
import dev.usermanager.model.User;

@Service
public class UserService
{
    private final UserRepository repo;

    public UserService(UserRepository repo)
    {
        this.repo = repo;
    }

    public Optional<User> register(String username, String password)
    {
        Optional<User> found = repo.findByUsername(username);

        if (found.isPresent()) {
            return found;
        }

        repo.save(new User(username, password));

        return Optional.empty();
    }

    public List<User> getUsers()
    {
        return repo.findAll();
    }

    public String LoginUser(String username, String password)
    {
        Optional<User> userOptional = repo.findByUsername(username);

        if (!userOptional.isPresent()) {
            return "Username doesn't exists";
        }

        User user = userOptional.get();

         if (!user.getPassword().equals(password)) {
            return "Password doesn't match the username";
        }

        return null;
    }
}
