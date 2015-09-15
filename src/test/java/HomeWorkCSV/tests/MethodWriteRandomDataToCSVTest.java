package HomeWorkCSV.tests;

import HomeWorkCSV.FileReader1;
import HomeWorkCSV.FileWriter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import static org.junit.Assert.*;

/**
 * Created by Gorobets Dmitriy on 15.09.2015.
 */
public class MethodWriteRandomDataToCSVTest {
    PrintWriter randomWriteToCSV;
    File file;
    boolean appendToFile;
    String destinationFileName = "Test CSVFile.csv";
    FileWriter fw;
    FileReader1 fr;
    StringBuilder featureRandomProducts;


    @Before
    public void setUpBefore() throws FileNotFoundException {
        fr = new FileReader1(1);
        fw = new FileWriter();
        file = new File(destinationFileName);
        randomWriteToCSV = new PrintWriter(new FileOutputStream(file, appendToFile));
        featureRandomProducts = new StringBuilder();


    }

    @Test
    public void tst_File_Exist_True() {
        assertTrue(destinationFileName, file.exists());

    }

    @Test
    public void tst_File_Exist_False() {
        assertFalse(destinationFileName, !file.exists());

    }

    @Test
    public void tst_File_IsFile() {
        assertTrue(file.isFile());
    }

    @Test
    public void tst_File_GetName() {
        assertTrue(file.getName().equals("Test CSVFile.csv"));
    }

    @Test
    public void tst_File_Length() {
        assertTrue(file.length() == 0);
    }

    @Test
    public void tst_FileLength_NotNull_AfterWrite_True() {
        fw.writeToCSVRandomData("Test CSVFile.csv", 1);
        randomWriteToCSV.print(featureRandomProducts);
        randomWriteToCSV.flush();
        randomWriteToCSV.close();

        assertTrue(file.length() != 0);
    }

    @Test
    public void tst_FileLength_Null_AfterWrite_False() {
        fw.writeToCSVRandomData("Test CSVFile.csv", 1);
        randomWriteToCSV.print(featureRandomProducts);
        randomWriteToCSV.flush();
        randomWriteToCSV.close();

        assertFalse(file.length() == 0);
    }

    @Test
    public void tst_File_CanWrite() {

        assertTrue(file.canWrite());
    }

    @Test
    public void tst_File_CanRead() {

        assertTrue(file.canRead());
    }

    @Test
    public void tst_RandomWriteToCSV_True() {
        randomWriteToCSV.print("dghdjkhdfgbn");
        randomWriteToCSV.flush();
        randomWriteToCSV.close();
        assertTrue(file.length() != 0);
    }

    @Test
    public void tst_RandomWriteToCSV_WithoutFlushAndClose_False() {
        randomWriteToCSV.print("dghdjkhdfgbn");

        assertFalse(file.length() != 0);
    }

    @Test
    public void tst_WriteToStringBuilder_True() {
        featureRandomProducts.append("dghdjkhdfgbn");

        assertTrue(featureRandomProducts.length() != 0);
    }

    @Test
    public void tst_DeleteFromStringBuilder_True() {
        featureRandomProducts.append("dghdjkhdfgbn");
        featureRandomProducts.delete(0, 12);

        assertTrue(featureRandomProducts.length() == 0);
    }

    @Test
    public void tst_StringBuilderEqualsToStr_True() {
        featureRandomProducts.append("dghdjkhdfgbn");

        assertTrue(featureRandomProducts.toString().equals("dghdjkhdfgbn"));
    }


    @After

    public void setUpAfter() {
        file = null;
        randomWriteToCSV = null;
        fw = null;
    }

}
