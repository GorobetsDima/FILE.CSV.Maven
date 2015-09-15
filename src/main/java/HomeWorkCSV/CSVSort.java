package HomeWorkCSV;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Gorobets Dmitriy on 06.09.2015.
 */
public class CSVSort implements CSVHolder {
    File fileCsv;
    //Создаю три компаратора, которые сравниеют поля объектов Product
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
            result = Integer.compare(o1.getPrice(), o2.getPrice());

            return result;

        }
    };

    //Метод проверяет ,можно ли записать данные в файл
    @Override
    public boolean writeToCSVNewProducts(String destinationFileName, List<Product> newProducts) {
        boolean result;
        fileCsv = new File(destinationFileName);
        FileWriter writeNew = new FileWriter();

        if (fileCsv.exists()) {
            writeNew.writeProductListToCSV(destinationFileName, newProducts, true);
            result = true;
        } else if (fileCsv.canWrite()) {
            writeNew.writeProductListToCSV(destinationFileName, newProducts, true);
            result = true;
        } else {
            result = false;
        }
        return result;
    }
//метод выбирает компаратор по типу сортировки,кот. пришел и сортирует лист обьектов
    @Override
    public boolean addNewDataAndSortBy(String destinationFileName, List<Product> newProducts, CompareType
            typeToSortList) {
        FileWriter writeNew = new FileWriter();

        boolean result = false;

        switch (typeToSortList) {
            case BY_PRICE:
                Collections.sort(newProducts, CSVSort.BY_PRICE_COMPARATOR);
                writeNew.writeProductListToCSV(destinationFileName, newProducts, true);
                result = true;
                break;

            case BY_NAME:
                Collections.sort(newProducts, CSVSort.BY_NAME_COMPARATOR);
                writeNew.writeProductListToCSV(destinationFileName, newProducts, true);
                result = true;
                break;
            case BY_ARTICUL:
                Collections.sort(newProducts, CSVSort.BY_ARTICUL_COMPARATOR);
                writeNew.writeProductListToCSV(destinationFileName, newProducts, true);
                result = true;
                break;
            case DEFAULT:
                Collections.sort(newProducts);
                writeNew.writeProductListToCSV(destinationFileName, newProducts, true);
                result = true;
                break;


        }
        System.out.println(result);
        return result;
    }
}

