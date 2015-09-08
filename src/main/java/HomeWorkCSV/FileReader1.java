package HomeWorkCSV;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Gorobets Dmitriy on 26.08.2015.
 */
public class FileReader1 implements CSVReader {
    private static String[] csvProduct;
    private static final String SEPARATOR = ", ";
    private int numberOfProducts;

    public static String[] getCsvProduct() {
        return csvProduct;
    }


    public FileReader1(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    //метод считывает данные с файла CSV
    @Override
    public List<Product> readFromFile(String destinationFileName) {
        List<Product> result = new LinkedList<>();//создал лист обьектов Product
        BufferedReader readfromCSV = null;
        try {
            readfromCSV = new BufferedReader(new FileReader(destinationFileName));
            String textCSV = readfromCSV.readLine();//читаю с потока строку

            csvProduct = new String[numberOfProducts];

            for (int i = 0; i < csvProduct.length; i++) {
                if (textCSV != null) {
                    csvProduct[i] = readfromCSV.readLine() ; //записываю в массив строк csvProduct строки считанные с файла CSV
                } else break;

            }
            System.out.println("File contents: ");
            System.out.println(Arrays.toString(csvProduct));//печатаю содержимое массива строк
            for (String st : csvProduct) {
                if (st != null) {
                    //разбиваю элементы массива строк csvProduct на подстроки
                    String[] parameters = st.split(SEPARATOR); // и создаю новый массив из подстрок



                    Product p = new Product();//создал объект типа Product и заполнил его поля значениями из массива подстрок "parameters"
                    p.setName(parameters[0]);
                    p.setArticul(parameters[1]);
                    p.setDateProduction(parameters[2]);
                    p.setProductLife(parameters[3]);
                    p.setPrice(Integer.parseInt(parameters[4]));


                    result.add(p);//созданный объект "p" помещаю в List объектов типа Product

                }

            }

            readfromCSV.close();//закрывает поток, если может
        } catch (FileNotFoundException e) {//ыбрасывае сообщение если вайла нет
            e.getMessage();
        } catch (IOException e) {//ловит исключение если проблема с потоком вывода
            e.getCause();
        } finally {
            closeStream(readfromCSV);//закрывает поток, сли он существует
        }

        return result;


    }

    private void closeStream(Closeable stream) {//метод закрытия потока вывода,если он существет
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {//ловит исключения ,если поток не закрывается и выдает причину и сообщение об этомв консоль
                e.getCause();
                e.getMessage();
            }
        }
    }


}


