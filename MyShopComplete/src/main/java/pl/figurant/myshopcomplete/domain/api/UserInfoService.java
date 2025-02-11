package pl.figurant.myshopcomplete.domain.api;
import pl.figurant.myshopcomplete.domain.user.UserDao;

public class UserInfoService {
    private final UserDao userDao = new UserDao();

    public UserInfo getUserInfo(String username) {
        UserInfo userInfo = userDao.getUserInfo(username);
        return userInfo;
    }
}
