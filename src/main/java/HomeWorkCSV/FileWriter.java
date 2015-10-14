package HomeWorkCSV;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * Метод "writeProductListToCSV" записывает данные в CSV файл;
 * <p>
 * Метод "rowToCsv" записывает  в строку поля продукта "р" типа "Product".;
 * <p>
 * Метод "isTrueWriteAndReadCSVFile"  проверяет соответствие записаных и считанных данных CSV файла;
 * <p>
 * Метод "writeToCSVRandomData" записывает произвольные данные в CSV файл ;
 * <p>
 * Created by Gorobets Dmitriy .
 */
public class FileWriter implements CSVWriter {
    private static final String SEPARATOR = ", ";
    private static final Logger LOG1 = Logger.getLogger(FileWriter.class);
    private static final String HEADER = "ProductName(String), Articul(String), DateProduction(String), ProductLife(String), Price(Int)";


    public FileWriter() {

    }

    //метод записываает продукты из листа в файл csv
    @Override
    public void writeProductListToCSV(String destinationFileName, List<Product> newProducts, boolean appendToFile) {
        PrintWriter writeToCSV = null;
        File file = new File(destinationFileName);

        if (!file.exists()) {
            try {
                file.createNewFile();

            } catch (IOException e) {
                LOG1.error("We have some issues with a stream ");
                e.printStackTrace();
            }
        }
        try {

            writeToCSV = new PrintWriter(new FileOutputStream(file, appendToFile));//создал новый поток
            for (Product p : newProducts) {
                writeToCSV.print(rowToCsv(p));//записал инфо из строки StringBuilder в файл CSV
                LOG1.info("File " + destinationFileName + " was written");
            }
            writeToCSV.flush();
            writeToCSV.close();
        } catch (FileNotFoundException e) {
            LOG1.error("File " + destinationFileName + " don't exist ");
            e.getMessage();
        } finally {
            closeStream(writeToCSV);
        }
    }

    //метод записывает в строку поля продукта р.
    public StringBuilder rowToCsv(Product p) {
        StringBuilder featureProducts;

        featureProducts = new StringBuilder();
        featureProducts.append(p.getName()).append(SEPARATOR).append(p.getArticul()).append(SEPARATOR).
                append(p.getDateProduction()).append(SEPARATOR).append(p.getProductLife()).
                append(SEPARATOR).append(p.getPrice()).append("\n");


        return featureProducts;

    }

    //Метод проверяет соответствие записаных и считанных данных
    public boolean isTrueWriteAndReadCSVFile(List<Product> newProducts) {
        boolean result;
        String[] sar = FileReader1.getCsvProduct();//массив строк считанных с CSV файла
        StringBuilder allProducts = new StringBuilder();
        allProducts.append("[");
        for (Product p : newProducts) {// ЗАПИСЫВАЮ в строку StringBuilder значения полей объектов типа Product
            allProducts.append(p.getName()).append(SEPARATOR).append(p.getArticul()).append(SEPARATOR).
                    append(p.getDateProduction()).append(SEPARATOR).append(p.getProductLife()).
                    append(SEPARATOR).append(p.getPrice()).append(SEPARATOR);
        }

        allProducts.append("]");
        System.out.println(allProducts);

        if (allProducts.toString().equals(Arrays.toString(sar))) {//сравниваю соответствие записанной строки и считанной посимвольно

            result = true;
        } else {
            result = false;
        }

        System.out.println(result);

        return result;

    }


    // метод,кот. записыват данные случайным образом
    @Override
    public void writeToCSVRandomData(String destinationFileName, int lineValue) {

        File file;
        StringBuilder featureRandomProducts = new StringBuilder();

        featureRandomProducts.append(HEADER);
        featureRandomProducts.append("\n");

        for (int i = 1; i <= lineValue; i++) {//записываю в строку featureRandomProducts i=lineValue случайных значений
            featureRandomProducts.append(String.format("Name%d ", i) + SEPARATOR + String.format("Articul%d ", i) + SEPARATOR + String.format("DateProduction%d ", i) + SEPARATOR + String.format("ProductLife%d ", i) + SEPARATOR + (200 + i) + "\n");

        }

        PrintWriter randomWriteToCSV = null;
        file = new File(destinationFileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
                LOG1.info("We created a new File");
            }
        } catch (IOException e) {
            LOG1.info("We caught an IOException message: " + e.getMessage());
            e.getMessage();
            e.printStackTrace();
        }
        try {
//создаю поток записи в csv и записываю данные
            randomWriteToCSV = new PrintWriter(new FileOutputStream(file, true));
            randomWriteToCSV.print(featureRandomProducts);

            randomWriteToCSV.flush();
            randomWriteToCSV.close();

        } catch (FileNotFoundException e) {
            LOG1.error("File: " + destinationFileName + " isn't existed");
            e.getMessage();
        } finally {
            closeStream(randomWriteToCSV);
            LOG1.info("Output Stream was closed");
        }
    }

    //метод проверяющий,закрылся ли поток,если нет ,то пытается его закрыть
    private void closeStream(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                LOG1.info(e.getMessage() + "; \n " + e.getCause());
                e.getMessage();
            }
        }
    }


}

