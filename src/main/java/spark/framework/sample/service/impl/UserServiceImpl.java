package spark.framework.sample.service.impl;

import com.google.inject.Singleton;
import spark.framework.sample.bean.Result;
import spark.framework.sample.bean.User;
import spark.framework.sample.jdbc.DBHelper;
import spark.framework.sample.service.UserService;

import java.util.Date;

@Singleton
public class UserServiceImpl implements UserService {

    @Override
    public Result getAll() {
        return new Result(true, DBHelper.queryList("SELECT * FROM user"));
    }

    @Override
    public Result getUser(int id) {
        return new Result(true, DBHelper.queryRow("SELECT * FROM user WHERE id = ?", id));
    }

    @Override
    public Result save(User user) {
        return new Result(true, DBHelper.insert("INSERT INTO user(name,age,address,createdAt) VALUES(?,?,?,?)", true,
                user.getName(),
                user.getAge(),
                user.getAddress(),
                new Date()
        ));
    }

    @Override
    public Result delete(int id) {
        return new Result(true, DBHelper.executeSQL("DELETE FROM user WHERE id = ?", id));
    }

    @Override
    public Result update(User user) {
        return new Result(true, DBHelper.executeSQL("UPDATE user SET name=?,age=?,address=? WHERE id=?",
                user.getName(),
                user.getAge(),
                user.getAddress(),
                user.getId()
        ));
    }
}
