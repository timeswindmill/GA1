package gene;

import junit.framework.Assert;
import org.junit.Test;

public class DnaTest {


    @Test
    public void testCreateDna() throws Exception {

        Dna newSimpleDna = SimpleDnaHelper.INSTANCE.createRandomDna();
        Assert.assertNotNull(newSimpleDna);

        int[] startString = {1, 3, 5, 7, 9};
        SimpleDna newSimpleDna2 = SimpleDnaHelper.INSTANCE.createDnaFromString(startString);
        double hash2 = newSimpleDna2.getHash();
        Assert.assertEquals(25.0, hash2);

    }


    @Test
    public void testCombineDna() throws Exception {

        int[] startString1 = {1, 3, 5, 7, 9};
        int[] startString2 = {2, 4, 6, 8, 10};

        SimpleDna newSimpleDna1 = SimpleDnaHelper.INSTANCE.createDnaFromString(startString1);
        double hash1 = newSimpleDna1.getHash();
        Assert.assertEquals(25.0, hash1);

        SimpleDna newSimpleDna2 = SimpleDnaHelper.INSTANCE.createDnaFromString(startString2);
        double hash2 = newSimpleDna2.getHash();
        Assert.assertEquals(30.0, hash2);

        SimpleDna combined = SimpleDnaHelper.INSTANCE.createDnaFromCombined(newSimpleDna1, newSimpleDna2);
        Assert.assertNotNull(combined);

        double combinedHash = combined.getHash();

        Assert.assertTrue(combinedHash != hash1);
        Assert.assertTrue(combinedHash != hash2);

    }

    @Test
    public void testReadWriteData() throws Exception {

        SimpleDna dna1 = SimpleDnaHelper.INSTANCE.createRandomDna();
        SimpleDna dna2 = SimpleDnaHelper.INSTANCE.createRandomDna();
        SimpleDna dna3 = SimpleDnaHelper.INSTANCE.createRandomDna();
        SimpleDna[] bestDna = {dna1, dna2, dna3};

        String fileName = "./testData.dat";

        SimpleDnaHelper.INSTANCE.writeToFile(bestDna, fileName);

        // now read it back

        SimpleDna[] newDnaArray = SimpleDnaHelper.INSTANCE.readFromFile(fileName);

        Assert.assertEquals(dna1, newDnaArray[0]);
        Assert.assertEquals(dna2, newDnaArray[1]);
        Assert.assertEquals(dna3, newDnaArray[2]);


    }


}
