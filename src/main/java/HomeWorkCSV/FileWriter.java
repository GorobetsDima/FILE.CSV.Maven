package HomeWorkCSV;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Gorobets Dmitriy on 26.08.2015.
 */
public class FileWriter implements CSVWriter {
    private static final String SEPARATOR = ", ";
    private static final Logger LOG1 = Logger.getLogger(FileWriter.class.toString());
    private  static final String HEADER = "ProductName(String), Articul(String), DateProduction(String), ProductLife(String), Price(Int)";




    public FileWriter() {

    }

    //метод записываает продукты из листа в файл csv
    @Override
    public void writeProductListToCSV(String destinationFileName, List<Product> newProducts, boolean appendToFile)  {

        PrintWriter writeToCSV = null;
        File file = new File(destinationFileName);
        if (!file.exists()) {
            try {
                file.createNewFile();

            } catch (IOException e) {
                LOG1.warning("We have some issues with a stream ");
                e.printStackTrace();
            }
        }
        try {

            writeToCSV = new PrintWriter(new FileOutputStream(file, appendToFile));//создал новый поток
            for (Product p : newProducts) {
                writeToCSV.print(rowToCsv(p));//записал инфо из строки StringBuilder в файл CSV
                LOG1.info("File" + destinationFileName + " was written");
            }
            writeToCSV.flush();
            writeToCSV.close();
        } catch (FileNotFoundException e) {
            LOG1.warning("File " + destinationFileName + " don't exist ");
            e.getMessage();
        } finally {
            closeStream(writeToCSV);
        }
    }

    //метод записывае в строку поля продукта р.
    public StringBuilder rowToCsv(Product p) {
        StringBuilder featureProducts;

        featureProducts = new StringBuilder();
        featureProducts.append(p.getName()).append(SEPARATOR).append(p.getArticul()).append(SEPARATOR).
                append(p.getDateProduction()).append(SEPARATOR).append(p.getProductLife()).
                append(SEPARATOR).append(p.getPrice()).append("\n");


        return featureProducts;

    }

    //метод проверяет соответствие записаных и считанных данных
    //TODO
    public boolean isTrueWriteAndReadCSVFile(String[] csvProduct, List<Product> newProducts) {
        boolean result;
        StringBuilder allProducts = new StringBuilder();

        for (Product p : newProducts) {// ЗАПИСЫВАЮ в строку StringBuilder значения полей объектоа типа Product
            allProducts.append(p.getName()).append(SEPARATOR).append(p.getArticul()).append(SEPARATOR).
                    append(p.getDateProduction()).append(SEPARATOR).append(p.getProductLife()).
                    append(SEPARATOR).append(p.getPrice()).append("\n");
        }
        System.out.println(allProducts);
        System.out.println(Arrays.toString(csvProduct));

        if (allProducts.toString() == (Arrays.toString(csvProduct))) {//не правильно

            result = true;
        } else {
            result = false;
        }

        System.out.println(result);

        return result;

    }

    //метод проверяет закрылся ли поток,если нет то закрывает его
    private void closeStream(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }

    // метод,кот. записыват данный случайным образом
    @Override
    public void writeToCSVRandomData(String destinationFileName, int lineValue) {

        File file;
        StringBuilder featureRandomProducts = new StringBuilder();
//
//        featureRandomProducts.append(HEADER);
//        featureRandomProducts.append("\n");

        for (int i = 1; i <= lineValue; i++) {//записываю в строку featureRandomProducts i=lineValue случайных значений
            featureRandomProducts.append(String.format("Name%d ",i)+SEPARATOR+String.format("Articul%d ",i)+SEPARATOR+String.format("DateProduction%d ",i)+SEPARATOR+String.format("ProductLife%d ",i)+SEPARATOR+(200+i)+"\n" );
//            featureRandomProducts.append("\n");
//            featureRandomProducts.append("Name" + i + SEPARATOR + "Articul" + i + SEPARATOR + "DateProduction" + i + SEPARATOR + "ProductLife" + i +
//                    SEPARATOR + "Price" + i + "\n");
        }
//        System.out.println(featureRandomProducts);
        PrintWriter randomWriteToCSV = null;
        file = new File(destinationFileName);
        try{
            if (!file.exists()){
                file.createNewFile();
                LOG1.info("We created a new File");
            }
        } catch (IOException e) {
            LOG1.info("We caught an IOException message: "+e.getMessage());
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
            LOG1.warning("File: "+destinationFileName+" isn't existed");
            e.getMessage();
        } finally {
            closeRandomStream(randomWriteToCSV);
            LOG1.info("Output Stream was closed");
        }
    }

    //метод проверяющий,закрылся ли поток,если нет ,то пытается его закрыть
    private void closeRandomStream(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                LOG1.info(e.getMessage()+"; \n "+ e.getCause());
                e.getMessage();
            }
        }
    }


}

