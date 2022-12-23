import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
// Importing input output class
import java.io.Serializable;

public class Marching implements Serializable {
    private Range[] ranges;

    public Marching(Range[] ranges) {
        this.ranges = ranges;
    }

    public List<String> marchingLabels(int item) {

        List<Range> collections = Arrays.asList(this.ranges);
        SparkConf sparkConf = new SparkConf().setAppName("element to RDD")
                .setMaster("local[3]").set("spark.executor.memory", "2g");
        //on fixé le nb de partition a 3 dans le spark config en haut dans notre cas, mais on pourra personnaliser pour de meilleure resultat)

        // start a spark context
        JavaSparkContext sc = new JavaSparkContext(sparkConf);
        sc.setLogLevel("WARN");
        // parallelizsé la collection en deux partitions (par default ici)
        JavaRDD<Range> rdd = sc.parallelize(collections);
        List<String> rangeLabels = rdd.filter(
                new Function<Range, Boolean>() {
                    public Boolean call(Range R) {
                        return (R.getInterval()[0] <= item && R.getInterval()[1] > item);
                    }
                })
                .map(R -> R.getLabel()).collect();

        System.out.println("Nombre de partitions : " + rdd.getNumPartitions());
        rangeLabels.forEach(element -> {
            System.out.println(element);
        });
        sc.close();
        return rangeLabels;
    }

    public static void main(String[] args) {
        System.out.println("=====main function=====");
        int[] a = {0, 6};
        int[] b = {5, 7};
        Range[] ranges = {new Range("A", a), new Range("B", b)}; //(A -> {0, 6}, B -> {5, 7})
        Marching maching = new Marching(ranges);
        List<String> result = maching.marchingLabels(4);
        System.out.println(result);
    }

}
