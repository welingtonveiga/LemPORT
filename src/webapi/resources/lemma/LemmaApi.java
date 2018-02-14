package webapi.resources.lemma;

import lemma.Lemmatizer;
import partofspeech.POSTagger;
import spark.Request;
import spark.Response;
import token.Tokenizer;

import java.util.Objects;

public class LemmaApi {

    private final Lemmatizer lemmatizer;

    private final POSTagger tagger;

    private final Tokenizer tokenizer;

    public LemmaApi(Lemmatizer lemmatizer, POSTagger tagger, Tokenizer tokenizer) {
        Objects.requireNonNull(lemmatizer, "Lemmatizer should not be null!");
        Objects.requireNonNull(tagger, "Tagger should not be null!");
        Objects.requireNonNull(tokenizer, "Tokenizer should not be null!");

        this.lemmatizer = lemmatizer;
        this.tagger = tagger;
        this.tokenizer = tokenizer;
    }


    public Object lemmatize(Request request, Response response) throws Exception {

        Text text = request.attribute("text");

        String[] tokens = tokenizer.tokenize(text.getValue());

        String[] lemmas = lemmatizer.lemmatize(tokens, tagger.tag(tokens));

        return new Lemma(lemmas);
    }


}
