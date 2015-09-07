package HomeWorkCSV;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Gorobets Dmitriy on 06.09.2015.
 */
public class CSVSort implements CSVHolder {
    File fileCsv;
    public static final Comparator<Product> BY_NAME_COMPARATOR = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            int result;
            result = o1.getName().compareTo(o2.getName());

            return result;

        }
    };
    public static final Comparator<Product> BY_ARTICUL_COMPARATOR = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            int result;
            result = o1.getArticul().compareTo(o2.getArticul());

            return result;
        }
    };
    public static final Comparator<Product> BY_PRICE_COMPARATOR = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {

            int result;
            result = Float.compare(o1.getPrice(), o2.getPrice());

            return result;

        }
    };

    @Override
    public boolean writeToCSVNewProducts(String destinationFileName, List<Product> newProducts) {
        boolean result = false;
        fileCsv = new File(destinationFileName);
        FileWriter writeNew = new FileWriter();

        if (fileCsv.exists()) {
            writeNew.writeProductListToCSV(destinationFileName, newProducts, true);
            result = true;
        } else if (fileCsv.getFreeSpace() == 0) {
            try {

                fileCsv.createNewFile();
                System.out.println("New file was created");
                writeNew.writeProductListToCSV(destinationFileName, newProducts, true);
                result = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public boolean addNewDataAndSortBy(String destinationFileName, List<Product> newProducts, CompareType typeToSortList) {
        boolean result = false;

        switch (typeToSortList) {
            case BY_PRICE:
                Collections.sort(newProducts, CSVSort.BY_PRICE_COMPARATOR);
                result = true;
                break;

            case BY_NAME:
                Collections.sort(newProducts, CSVSort.BY_NAME_COMPARATOR);
                result = true;
                break;
            case BY_ARTICUL:
                Collections.sort(newProducts, CSVSort.BY_ARTICUL_COMPARATOR);
                result = true;
                break;
            case DEFAULT:
                Collections.sort(newProducts);
                result = true;
                break;


        }
        System.out.println(result);
        return result;
    }
}

