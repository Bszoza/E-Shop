package pl.figurant.myshopcomplete.domain.api;
import pl.figurant.myshopcomplete.domain.user.UserDao;

import java.util.List;

public class UserInfoService {
    private final UserDao userDao = new UserDao();

    public UserInfo getUserInfo(String username) {
        UserInfo userInfo = userDao.getUserInfo(username);
        return userInfo;
    }

    public List<UserOrderHistoryInfo> getUserOrderHistoryInfo(String mail) {
        List <UserOrderHistoryInfo> userOrderHistoryInfo = userDao.getUserOrderHistory(mail);
        return userOrderHistoryInfo;
    }
}
