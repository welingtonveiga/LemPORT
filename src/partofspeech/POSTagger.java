package partofspeech;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class POSTagger {

    private static final String DEFAULT_LOCATION = "/resources/models/pt-pos-maxent.bin";

    private final POSTaggerME tagger;

    public static POSTagger build(){
        POSTagger tagger;

        try (InputStream is = POSTagger.class.getResourceAsStream(DEFAULT_LOCATION)) {
            tagger = new POSTagger(is);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return tagger;
    }

    public POSTagger(InputStream is){
        try {
            POSModel model = new POSModel(is);
            this.tagger = new POSTaggerME(model);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String[] tag(String[] tokens) {
        return tagger.tag(tokens);
    }
}
