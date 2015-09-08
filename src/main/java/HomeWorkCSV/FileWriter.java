package HomeWorkCSV;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gorobets Dmitriy on 26.08.2015.
 */
public class FileWriter implements CSVWriter {
    private static final String SEPARATOR = ", ";
    private static StringBuilder featureProducts;

    public FileWriter() {

    }
//метод записываает продукты из листа в файл csv
    @Override
    public void writeProductListToCSV(String destinationFileName, List<Product> newProducts, boolean appendToFile) {


        PrintWriter writeToCSV = null;
        File file = new File(destinationFileName);
        try {
//TODO
//            if (file.length() == 0) {//проверяю пуст ли файл,если да,то записываю в него инфо
            writeToCSV = new PrintWriter(new FileOutputStream(file, appendToFile));//создал новый поток
            for (Product p : newProducts) {
                writeToCSV.print(rowToCsv(p));//записал инфо из строки StringBuilder в файл CSV

            }

            writeToCSV.flush();
            writeToCSV.close();
//            } else {//если файл не пуст удаляю его и создаю новый!???
//                file.delete();
//                file.createNewFile();
//                writeToCSV = new PrintWriter(new FileOutputStream(file, appendToFile));//создал новый поток
//
//                for (Product p : newProducts) {
//                    writeToCSV.print(rowToCsv(p));//записал инфо из строки StringBuilder в файл CSV
//                }
//                writeToCSV.flush();
//                writeToCSV.close();
//            }

        } catch (FileNotFoundException e) {
            e.getMessage();

//        } catch (IOException e) {
//            e.printStackTrace();
        } finally {
            closeStream(writeToCSV);
        }
    }
//метод записывае в строку поля продукта р.
    public static StringBuilder rowToCsv(Product p) {

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
        StringBuilder featureRandomProducts = new StringBuilder();

        for (int i = 1; i <= lineValue; i++) {//записываю в строку featureRandomProducts i=lineValue случайных значений

            featureRandomProducts.append("Name" + i + SEPARATOR + "Articul" + i + SEPARATOR + "DateProduction" + i + SEPARATOR + "ProductLife" + i +
                    SEPARATOR + "Price" + i + "\n");
        }

        PrintWriter randomWriteToCSV = null;
        File file = new File(destinationFileName);
        try {
//создаю поток записи в csv и записываю данные
            randomWriteToCSV = new PrintWriter(new FileOutputStream(file, true));
            randomWriteToCSV.print(featureRandomProducts);

            randomWriteToCSV.flush();
            randomWriteToCSV.close();

        } catch (FileNotFoundException e) {
            e.getMessage();
        } finally {
            closeRandomStream(randomWriteToCSV);
        }
    }
//метод проверяющий,закрылся ли поток,если нет ,то пытается его закрыть
    private void closeRandomStream(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }


}

