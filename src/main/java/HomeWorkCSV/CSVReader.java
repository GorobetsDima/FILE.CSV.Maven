package HomeWorkCSV;

import java.util.List;

/**
 * Created by Gorobets Dmitriy on 26.08.2015.
 */
public interface CSVReader {
    List<Product> readFromFile(String destinationFileName) ;
}
