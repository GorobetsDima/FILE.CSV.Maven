package HomeWorkCSV.tests;

import HomeWorkCSV.FileReader1;
import HomeWorkCSV.FileWriter;
import HomeWorkCSV.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Gorobets Dmitriy on 15.09.2015.
 */
public class MethodWriteProductListToCSVTest {
    List<Product> list;
    Product p;
    PrintWriter writeToCSV;
    File file;
    boolean appendToFile;
    String destinationFileName = "Test CSVFile.csv";
    FileWriter fw;
    FileReader1 fr;


    @Before
    public void setUpBefore() throws FileNotFoundException {
        fr = new FileReader1(1);
        fw = new FileWriter();
        list = new LinkedList<>();
        file = new File(destinationFileName);
        writeToCSV = new PrintWriter(new FileOutputStream(file, appendToFile));
        p = new Product();
        p.setPrice(10);
        p.setProductLife("12");
        p.setDateProduction("3.4.3");
        p.setArticul("3234");
        p.setName("milk");

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

        writeToCSV.print(fw.rowToCsv(p));
        writeToCSV.flush();
        writeToCSV.close();

        assertTrue(file.length() != 0);
    }

    @Test
    public void tst_FileLength_Null_AfterWrite_False() {

        writeToCSV.print(fw.rowToCsv(p));
        writeToCSV.flush();
        writeToCSV.close();

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
    public void tst_WriteToCSV_True() {
        writeToCSV.print("dghdjkhdfgbn");
        writeToCSV.flush();
        writeToCSV.close();
        assertTrue(file.length()!=0);
    }
    @Test
    public void tst_WriteToCSV_WithoutFlushAndClose_False() {
        writeToCSV.print("dghdjkhdfgbn");

        assertFalse(file.length()!=0);
    }



    @After

    public void setUpAfter() {
        list = null;
        p = null;
        file = null;
        writeToCSV = null;
        fw = null;
    }

}
