package pl.figurant.myshopcomplete.domain.api;

import org.apache.commons.codec.digest.DigestUtils;
import pl.figurant.myshopcomplete.domain.user.User;
import pl.figurant.myshopcomplete.domain.user.UserDao;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();

    public void registerUser(UserRegistration userRegistration) {
        User userToSave = UserMapper.map(userRegistration);
        //userDao.save(userToSave);
        hashPasswordWithSha256(userToSave);
        userDao.save(userToSave);
    }

    public List<String> getemails() {
        List<String> emails = new ArrayList<>();
        emails=userDao.getEmails();
        return emails;
    }

    public List<String> getUsernames() {
        List<String> usernames = new ArrayList<>();
        usernames=userDao.getUsernames();
        return usernames;
    }


    private void hashPasswordWithSha256(User user) {
        String sha256Password = DigestUtils.sha256Hex(user.getPassword());
        user.setPassword(sha256Password);
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
