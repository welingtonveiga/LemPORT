package token;

import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Tokenizer {

    private static final String DEFAULT_LOCATION = "/resources/models/pt-token.bin";
    private final TokenizerME tokenizer;

    public static Tokenizer build(){
        Tokenizer tokenizer;
        try (InputStream is = Tokenizer.class.getResourceAsStream(DEFAULT_LOCATION)) {
            tokenizer = new Tokenizer(is);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return tokenizer;
    }

    public Tokenizer(InputStream is){
        try {
            TokenizerModel model = new TokenizerModel(is);
            this.tokenizer = new TokenizerME(model);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String[] tokenize(String value) {
        return tokenizer.tokenize(value);
    }
}
