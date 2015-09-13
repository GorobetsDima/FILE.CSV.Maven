package HomeWorkCSV;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Gorobets Dmitriy on 27.08.2015.
 */
public class CSVFileRunner {
    public static void main(String[] args) throws FileNotFoundException {


//создаю объекты продуктов,данные о которых нужно поместить в файл CSV
        Product p1 = new Product();
        p1.setName("Молоко");
        p1.setArticul("мп1ж1л");
        p1.setDateProduction("1.01.2016");
        p1.setProductLife("1 месяц");
        p1.setPrice(17);

        Product p2 = new Product();
        p2.setName("Сыр");
        p2.setArticul("мп2т1к");
        p2.setDateProduction("10.01.2016");
        p2.setProductLife("3 месяца");
        p2.setPrice(144);

        Product p3 = new Product();
        p3.setName("Кефир");
        p3.setArticul("мп3ж1л");
        p3.setDateProduction("4.01.2016");
        p3.setProductLife("1 месяц");
        p3.setPrice(16);

        Product p4 = new Product();
        p4.setName("Йогурт");
        p4.setArticul("мп4ж1л");
        p4.setDateProduction("9.01.2016");
        p4.setProductLife("1 месяц");
        p4.setPrice(20);

        Product p5 = new Product();
        p5.setName("Сметана");
        p5.setArticul("мп5гж1/2л");
        p5.setDateProduction("15.01.2016");
        p5.setProductLife("1 month");
        p5.setPrice(14);

        Product p6 = new Product();
        p6.setName("Сливочное Масло");
        p6.setArticul("мп6lт250г");
        p6.setDateProduction("1.01.2016");
        p6.setProductLife("2 месяца");
        p6.setPrice(32);

        Product p7 = new Product();
        p7.setName("Баклажан");
        p7.setArticul("ов23ю.1к");
        p7.setDateProduction("18.01.2016");
        p7.setProductLife("1 месяц");
        p7.setPrice(25);

        Product p8 = new Product();
        p8.setName("Рис");
        p8.setArticul("зк7тр1к");
        p8.setDateProduction("9.01.2016");
        p8.setProductLife("6 месяцев");
        p8.setPrice(28);

//        Product p9 = new Product();
//        p9.setName("Рис");
//        p9.setArticul("зк7тр1к");
//        p9.setDateProduction("9.01.2016");
//        p9.setProductLife("6 месяцев");
////        p9.setPrice(28);
//        Product p10 = new Product("Свинина", "мс10тр1к", "5.09.2015", "10 дней", 75);

        List<Product> newProducts = new LinkedList<Product>();//Лист с обьектами Product
        newProducts.add(p1);
        newProducts.add(p2);
        newProducts.add(p3);
        newProducts.add(p4);
        newProducts.add(p5);
        newProducts.add(p6);
        newProducts.add(p7);
        newProducts.add(p8);


        FileWriter fw = new FileWriter();
        fw.writeProductListToCSV("BasketOfProducts.csv", newProducts, true);
//
//

//        FileWriter fran = new FileWriter();
//        fran.writeToCSVRandomData("BasketOfProducts.csv",newProducts.size());
        FileReader1 fr = new FileReader1(newProducts.size());
        fr.readFromFile("C:\\Users\\Gorobets Dmitriy\\IdeaProjects\\FILE.CSV.Maven1\\BasketOfProducts.csv");

//        fw.isTrueWriteAndReadCSVFile(newProducts);
//        CSVSort sort = new CSVSort();
//        sort.addNewDataAndSortBy("BasketOfProducts.csv",newProducts,CompareType.DEFAULT);
//        sort.writeToCSVNewProducts("BasketOfProducts.csv",newProducts);



//WrongFieldNumberException wfne = new WrongFieldNumberException();
//        wfne.checkNumberOfFields(p9, 5);



        }


    }

