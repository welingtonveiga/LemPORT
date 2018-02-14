package webapi;

import com.google.gson.Gson;
import lemma.Lemmatizer;
import org.slf4j.Logger;
import partofspeech.POSTagger;
import token.Tokenizer;
import webapi.filters.RequestLogger;
import webapi.resources.lemma.LemmaApi;
import webapi.resources.lemma.TextBodyParser;

import static spark.Spark.*;

public class App {

    private  static final Logger log = org.slf4j.LoggerFactory.getLogger(App.class);


    public static void main(String[] args) {

        try {

            final Gson gson = new Gson();

            final LemmaApi api = new LemmaApi(
                    new Lemmatizer(),
                    POSTagger.build(),
                    Tokenizer.build()
            );

            path("/lemmas", () -> {

                before("", new RequestLogger());
                before("", new TextBodyParser());

                post("", api::lemmatize, gson::toJson);
            });

        } catch (Exception e) {
            log.error("Sorry :( Failure running Web Api setup...", e);
        }
    }
}
