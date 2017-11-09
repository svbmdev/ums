package com.course.ums.ws;

import org.json.JSONObject;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * Created by vh on 11/2/17.
 */
public abstract class JSONRoute implements Route {

    @Override
    public Object handle(Request request, Response response) {
        JSONObject result;

        try {
            JSONObject jsonRequest = request.body().isEmpty() ? null : new JSONObject(request.body());
            result = handleJSONRequest(jsonRequest);
        } catch (Exception e) {
            result = new JSONObject();
            result.put("error", e.getMessage());
        }

        response.header("Content-Type", "application/json; charset=UTF-8");
        return result;
    }

    public abstract JSONObject handleJSONRequest(JSONObject request) throws Exception;

}
