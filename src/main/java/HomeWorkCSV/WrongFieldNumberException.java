package HomeWorkCSV;

/**
 * Created by Gorobets Dmitriy on 08.09.2015.
 */
public class WrongFieldNumberException extends Exception {
    private static final String SEPARATOR = ",";
    FileWriter writer;

    public static void checkNumberOfFields(Product p, int fieldsNumber) {
        FileWriter writer = new FileWriter();
//проверить заполнен ли продукт р правельно?(если не выбросить исключ)
        StringBuilder sb = writer.rowToCsv(p);
        String str = sb.toString();
        System.out.println(str);
        String[] sarr = str.split(SEPARATOR);
        String s = sarr.toString();
        String[] iarr = s.split("");
//        for (int i = 0; i < iarr.length; i++) {
//            switch (iarr[i]) {
//                case " ":
//                    if(iarr[i+1]=="0"){
//                        try {
//                            throw new WrongFieldNumberException();
//                        } catch (WrongFieldNumberException e) {
//                            e.getMessage();
//                            System.out.println("Вы задали не достаточное количество характеристик для продукта!");
//                            e.printStackTrace();
//                        }
//                        break;
//                    }
//            }
//
//        }


        System.out.println(sarr.length);
        for (int i = 0; i <iarr.length; i++) {
            if (sarr[i] == " " | sarr[i + 1] == "0") {
                try {
                    throw new WrongFieldNumberException();
                } catch (WrongFieldNumberException e) {
                    e.getMessage();
                    System.out.println("Вы задали не достаточное количество характеристик для продукта!");
                    e.printStackTrace();
                }
                break;
            } else if (sarr[i].equals("null")) {
                try {
                    throw new WrongFieldNumberException();
                } catch (WrongFieldNumberException e) {
                    e.getMessage();
                    System.out.println("Вы задали не достаточное количество характеристик для продукта!");
                    e.printStackTrace();
                }
                break;
            } else if (sarr.length > fieldsNumber) {
                try {
                    throw new WrongFieldNumberException();
                } catch (WrongFieldNumberException e) {
                    e.getMessage();
                    System.out.println("Kоличество заданых характеристик для продукта превышено!");
                    e.printStackTrace();
                }
                break;
            }
        }

    }
}



