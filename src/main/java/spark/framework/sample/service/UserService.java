package spark.framework.sample.service;

import com.google.inject.ImplementedBy;
import spark.framework.sample.bean.Result;
import spark.framework.sample.bean.User;
import spark.framework.sample.service.impl.UserServiceImpl;

@ImplementedBy(UserServiceImpl.class)
public interface UserService {

    Result getAll();

    Result getUser(int id);

    Result save(User user);

    Result delete(int id);

    Result update(User user);
}
