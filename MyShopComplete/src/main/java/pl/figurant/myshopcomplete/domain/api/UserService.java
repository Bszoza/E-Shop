package pl.figurant.myshopcomplete.domain.api;

import pl.figurant.myshopcomplete.domain.user.User;
import pl.figurant.myshopcomplete.domain.user.UserDao;

import java.time.LocalDateTime;

public class UserService {
    private UserDao userDao = new UserDao();

    public void registerUser(UserRegistration userRegistration) {
        User userToSave = UserMapper.map(userRegistration);
        userDao.save(userToSave);
    }

    private static class UserMapper {
        static User map(UserRegistration userRegistration) {
            return new User(
                    userRegistration.getName(), userRegistration.getLastName(),
                    userRegistration.getEmail(), userRegistration.getPassword(),
                    userRegistration.getUsername(), LocalDateTime.now()
            );
        }
    }
}
