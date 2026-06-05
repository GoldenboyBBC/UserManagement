package Dev.UserManager;

public class User 
{
    private static long counter = 1;

    private long id;
    private String username;
    private String password;

    public User(String username, String password)
    {
        this.id = counter++;

        this.username = username;
        this.password = password;
    }

    public long getId()
    {
        return id;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }
}
