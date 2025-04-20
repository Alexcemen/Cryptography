package cryptography.actions.bruteForce;

import java.util.Objects;

public class ResultKey {
    int key;
    char delimiter;

    public ResultKey(int key, char delimiter) {
        this.key = key;
        this.delimiter = delimiter;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ResultKey resultKey = (ResultKey) o;
        return key == resultKey.key && delimiter == resultKey.delimiter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, delimiter);
    }
}
