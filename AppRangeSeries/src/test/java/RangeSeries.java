import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RangeSeries {

    @Test
    public void TestMarchingLabels() {
        //Assert.assertTrue(true);
        int[] a = {0, 6};
        int[] b = {5, 7};
        Range[] ranges = {new Range("A", a), new Range("B", b)}; //(A -> {0, 6}, B -> {5, 7})
        Marching maching = new Marching(ranges);

        //test : pour item = 4
        List<String> result = maching.marchingLabels(4);
        assertEquals("verifier si 4 est que dans le range A", "A", result.get(0));

        //test 1: pour item = 2
        List<String> result1 = maching.marchingLabels(2);
        assertEquals("Test matchingLabels(2) -> [A]", "A", result1.get(0));

        //test 2: pour item = 5
        List<String> result2 = maching.marchingLabels(5);
        assertTrue("Test matchingLabels(5) -> [A, B]", (result2.contains("A") && result2.contains("B")));

        //test 3: pour item = 2
        List<String> result3 = maching.marchingLabels(6);
        assertEquals("Test matchingLabels(6) -> [B]", "B", result3.get(0));

        //test 4: pour item = 8
        List<String> result4 = maching.marchingLabels(8);
        assertEquals("Test matchingLabels(8) -> []", 0, result4.size());
    }

    @Test
    public void TestRangeNull() {
        int[] a = {0, 0};
        Range[] ranges = {new Range("A", a)};
        assertEquals("taille range = 0", 0, ranges[0].size());
    }

    @Test
    public void TestRangeGetLabel() {
        int[] a = {0, 6}; //"A -> {0, 6}"
        Range[] ranges = {new Range("A", a)};
        assertEquals("label name A", "A", ranges[0].getLabel());
    }

    @Test
    public void TestRangeGetInterval() {
        int[] a = {0, 6}; //"A -> {0, 6}"
        Range[] ranges = {new Range("A", a)};
        assertEquals("interval entry element = 0", 0, ranges[0].getInterval()[0]);
        assertEquals("interval second element = 6", 6, ranges[0].getInterval()[1]);
    }

    @Test
    public void TestRangeToString() {
        int[] a = {0, 6};
        Range[] ranges = {new Range("A", a)};
        assertEquals("afficher A -> {0, 6}", "A -> {0, 6}", ranges[0].toString());
    }
}
