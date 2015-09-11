package HomeWorkCSV;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by Gorobets Dmitriy on 26.08.2015.
 */
public interface CSVWriter {
    void writeProductListToCSV(String destinationFileName, List<Product> newData, boolean appendToFile) throws FileNotFoundException;
    void writeToCSVRandomData(String destinationFileName, int lineValue);

}
