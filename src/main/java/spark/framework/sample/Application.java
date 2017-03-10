package spark.framework.sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import spark.framework.sample.bean.User;
import spark.framework.sample.service.UserService;

import static spark.Spark.*;

public class Application {
    public static void main(String[] args) {
        port(8080);

        Injector injector = Guice.createInjector();
        UserService userService = injector.getInstance(UserService.class);

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();

        path("/user", () -> {
            get("/get/:id", (req, res) -> {
                        res.type("application/json");
                        res.header("Content-Encoding", "gzip");
                        return userService.getUser(Integer.parseInt(req.params(":id")));
                    }
                    , gson::toJson);

            get("/all", (req, res) -> {
                        res.type("application/json");
                        res.header("Content-Encoding", "gzip");
                        return userService.getAll();
                    }
                    , gson::toJson);

            put("/insert", (req, res) -> {
                        res.type("application/json");
                        res.header("Content-Encoding", "gzip");
                        return userService.save(gson.fromJson(req.body(), User.class));
                    }
                    , gson::toJson);

            delete("/delete/:id", (req, res) -> {
                        res.type("application/json");
                        res.header("Content-Encoding", "gzip");
                        return userService.delete(Integer.parseInt(req.params(":id")));
                    }
                    , gson::toJson);

            put("/update", (req, res) -> {
                res.type("application/json");
                res.header("Content-Encoding", "gzip");
                return userService.update(gson.fromJson(req.body(), User.class));
            }, gson::toJson);
        });
    }
}
