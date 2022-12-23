// Importing input output class

import java.io.Serializable;

public class Range implements Serializable {
    private String label;
    private int[] interval = {0, 0};

    public Range(String label, int[] interval) {
        this.label = label;
        this.interval = interval;
    }

    public String toString() {
        //pour afficher l'object de type "A -> {0, 6}"
        return this.label + " -> {" + this.interval[0] + ", " + this.interval[1] + "}";
    }

    public int size() {
        return this.interval[1] - this.interval[0];
    }

    public String getLabel() {
        return label;
    }

    public int[] getInterval() {
        return interval;
    }
}
