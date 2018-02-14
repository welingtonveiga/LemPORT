package webapi.resources.lemma;

import com.google.gson.Gson;
import spark.Filter;
import spark.Request;
import spark.Response;

public class TextBodyParser implements Filter {

    private final Gson gson = new Gson();

    @Override
    public void handle(Request request, Response response) throws Exception {
        String body = request.body();
        request.attribute("text", gson.fromJson(body, Text.class));
    }
}
