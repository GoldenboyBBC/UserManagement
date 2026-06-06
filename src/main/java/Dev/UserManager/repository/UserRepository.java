package Dev.UserManager.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import Dev.UserManager.model.User;

@Repository
public class UserRepository
{
    private final List<User> users = new ArrayList<>();

    public List<User> findAll()
    {
        return users;
    }

    public User FindByUsername(String Username)
    {
        return users.stream().filter(u -> u.getUsername().equals(Username)).findFirst().orElse(null);
    }

    public void save(User user)
    {
        users.add(user);
        System.out.println(String.format("Registered User: User -- > '%s' Password --> '%s' Status --> Success", user.getUsername(), user.getPassword()));
    }
}
