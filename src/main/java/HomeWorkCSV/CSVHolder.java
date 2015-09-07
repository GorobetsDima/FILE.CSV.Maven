package HomeWorkCSV;

import java.util.List;

/**
 * Created by Gorobets Dmitriy on 06.09.2015.
 */
public interface CSVHolder {
    boolean writeToCSVNewProducts(String destinationFileName, List<Product> newProducts);
    boolean addNewDataAndSortBy(String destinationFileName, List<Product> newProducts, CompareType typeToSortList);
}
