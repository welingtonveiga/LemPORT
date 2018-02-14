package webapi.resources.lemma;

import java.util.Arrays;
import java.util.List;

public class Lemma {

    private final List<String> lemmas;

    public Lemma(String[] lemmas) {
        this.lemmas = Arrays.asList(lemmas);
    }

    public List<String> getLemmas() {
        return lemmas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lemma lemma = (Lemma) o;

        return lemmas.equals(lemma.lemmas);
    }

    @Override
    public int hashCode() {
        return lemmas.hashCode();
    }

    @Override
    public String toString() {
        return "Lemma{" +
                "lemmas=" + lemmas +
                '}';
    }
}
