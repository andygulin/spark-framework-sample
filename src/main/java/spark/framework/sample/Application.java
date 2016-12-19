package spark.framework.sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import spark.Spark;
import spark.framework.sample.bean.User;
import spark.framework.sample.service.UserService;

public class Application {
    public static void main(String[] args) {
        Spark.port(8080);

        Injector injector = Guice.createInjector();
        UserService userService = injector.getInstance(UserService.class);

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();

        Spark.get("/user/get/:id", (request, response) ->
                userService.getUser(Integer.parseInt(request.params(":id"))), gson::toJson);

        Spark.get("/user/all", (request, response) ->
                userService.getAll(), gson::toJson);

        Spark.put("/user/insert", (request, response) ->
                userService.save(gson.fromJson(request.body(), User.class)), gson::toJson);

        Spark.delete("/user/delete/:id", (request, response) ->
                userService.delete(Integer.parseInt(request.params(":id"))), gson::toJson);

        Spark.put("/user/update", (request, response) ->
                userService.update(gson.fromJson(request.body(), User.class)), gson::toJson);
    }
}
