package gene;

import junit.framework.Assert;
import org.junit.Test;

public class DnaTest {


    @Test
    public void testCreateDna() throws Exception {

        Dna newSimpleDna = DnaHelper.createRandomSimpleDna();
        Assert.assertNotNull(newSimpleDna);

        long[] startString = {1L, 3L, 5L, 7L, 9L};
        SimpleDna newSimpleDna2 = DnaHelper.createSimpleDnaFromLongString(startString);
        double hash2 = newSimpleDna2.getHash();
        Assert.assertEquals(25.0, hash2);

    }


    @Test
    public void testCombineDna() throws Exception {

        long[] startString1 = {1L, 3L, 5L, 7L, 9L};
        long[] startString2 = {2L, 4L, 6L, 8L, 10L};

        SimpleDna newSimpleDna1 = DnaHelper.createSimpleDnaFromLongString(startString1);
        double hash1 = newSimpleDna1.getHash();
        Assert.assertEquals(25.0, hash1);

        SimpleDna newSimpleDna2 = DnaHelper.createSimpleDnaFromLongString(startString2);
        double hash2 = newSimpleDna2.getHash();
        Assert.assertEquals(30.0, hash2);

        SimpleDna combined = DnaHelper.createSimpleDnaFromCombined(newSimpleDna1, newSimpleDna2);
        Assert.assertNotNull(combined);

        double combinedHash = combined.getHash();

        Assert.assertTrue(combinedHash != hash1);
        Assert.assertTrue(combinedHash != hash2);

    }

    @Test
    public void testReadWriteData() throws Exception {

        SimpleDna dna1 = DnaHelper.createRandomSimpleDna();
        SimpleDna dna2 = DnaHelper.createRandomSimpleDna();
        SimpleDna dna3 = DnaHelper.createRandomSimpleDna();
        Dna[] bestDna = {dna1, dna2, dna3};

        String fileName = "./testData.dat";

        DnaHelper.writeToFile(bestDna, fileName);

        // now read it back

        Dna[] newDnaArray = DnaHelper.readFromFile(fileName);

        Assert.assertEquals(dna1, newDnaArray[0]);
        Assert.assertEquals(dna2, newDnaArray[1]);
        Assert.assertEquals(dna3, newDnaArray[2]);


    }


}
