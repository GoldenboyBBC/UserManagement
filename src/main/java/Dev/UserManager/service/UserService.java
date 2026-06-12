package Dev.UserManager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import Dev.UserManager.repository.UserRepository;
import Dev.UserManager.model.User;

@Service
public class UserService
{
    private final UserRepository repo;

    public UserService(UserRepository repo)
    {
        this.repo = repo;
    }

    public User register(String username, String password)
    {
        User found = repo.FindByUsername(username);

        if (found != null) return found;

        repo.save(new User(username, password));

        return null;
    }

    public List<User> getUsers()
    {
        return repo.findAll();
    }

    public String LoginUser(String username, String password)
    {
        User user = repo.FindByUsername(username);

        if (user == null)
            return "Username doesn't exists";

         if (!user.getPassword().equals(password))
            return "Password doesn't match the username";

        return null;
    }
}
