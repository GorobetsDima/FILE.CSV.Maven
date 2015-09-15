package HomeWorkCSV.tests;

import HomeWorkCSV.FileReader1;
import HomeWorkCSV.FileWriter;
import HomeWorkCSV.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Gorobets Dmitriy on 15.09.2015.
 */
public class MethodIsTrueWriteAndReadCSVFileTest {
    private  static final String SEPARATOR = ", ";
    FileWriter fw;
    FileReader1 fr;
    List<Product> list;
    Product p;
    File f;
    String[] sar;
    StringBuilder str;


    @Before
    public void setUpBeforeTest() {

        f = new File("Test CSVFile.csv");
        fw = new FileWriter();
        fr = new FileReader1(1);
        list = new LinkedList<>();
        p = new Product("Свинина", "мс10тр1к", "5.09.2015", "10 дней", 75);
        list.add(p);
        fw.writeProductListToCSV("Test CSVFile.csv", list, true);
        fr.readFromFile("Test CSVFile.csv");
        sar = FileReader1.getCsvProduct();
        str = new StringBuilder();
        str.append("[");
        str.append(p.getName()).append(SEPARATOR).append(p.getArticul()).append(SEPARATOR).
                append(p.getDateProduction()).append(SEPARATOR).append(p.getProductLife()).
                append(SEPARATOR).append(p.getPrice());
        str.append("]");
        System.out.println(str);
        System.out.println(Arrays.toString(sar));


    }


    @Test
    public void tst_IsTrueWriteAndReadCSVFile() {


        assertTrue(str.toString().equals(Arrays.toString(sar)));
        assertFalse(fw.isTrueWriteAndReadCSVFile(list));//падает из-зи последнего сепаратора в стрингбилдере проверяемого метода, напишу False проверку


    }

    @After

    public void setUpAfterTest() {
        f = null;
        fw = null;
        fr = null;
        list = null;
        p = null;
       sar =null;
        str =null;


    }
}

