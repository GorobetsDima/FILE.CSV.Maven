package HomeWorkCSV;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Gorobets Dmitriy on 26.08.2015.
 */
public class FileReader1 implements CSVReader {
    private static final Logger LOG2 = Logger.getLogger(FileReader1.class.toString());
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
            LOG2.info("Reader stream was created");
            csvProduct = new String[numberOfProducts];


            for (int i = 0; i < csvProduct.length; i++) {
                if (textCSV != null) {
                    csvProduct[i] = readfromCSV.readLine(); //записываю в массив строк csvProduct строки считанные с файла CSV
                } else break;

            }

           //печатаю содержимое массива строк в лог
            LOG2.info("File contents: " + "\n" + Arrays.toString(csvProduct));
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
                    System.out.println(p.toString());
                    break;
//                    } else {
//                        p.setName(parameters[0]);
//                        p.setArticul(parameters[1]);
//                        p.setDateProduction(parameters[2]);
//                        p.setProductLife(parameters[3]);
//                        p.setPrice(Integer.parseInt(parameters[4]));
//
//
//                        result.add(p);//созданный объект "p" помещаю в List объектов типа Product
//                        break;
                }
            }


            readfromCSV.close();//закрывает поток, если может

        } catch (FileNotFoundException e) {//выбрасывае сообщение если файла нет
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
            } catch (IOException e) {//ловит исключения ,если поток не закрывается и выдает причину и сообщение об этом
                e.getCause();
                e.getMessage();
            }
        }
    }


}


