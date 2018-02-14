package webapi.filters;

import org.slf4j.Logger;
import spark.Filter;
import spark.Request;
import spark.Response;

import java.util.Date;

public class RequestLogger implements Filter {

    private  static final Logger log = org.slf4j.LoggerFactory.getLogger(RequestLogger.class);

    private static final String LOG_FORMAT = "%s %s";

    @Override
    public void handle(Request request, Response response) throws Exception {

        log.info(String.format(LOG_FORMAT, new Date(), request.url()));

    }
}
