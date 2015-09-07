package HomeWorkCSV;

/**
 * Created by Gorobets Dmitriy on 26.08.2015.
 */
public class Product implements Comparable<Product> {
    private String name;
    private String dateProduction;
    private String productLife;
    private String articul;
    private int price;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getArticul() {
        return articul;
    }

    public void setArticul(String articul) {
        this.articul = articul;
    }

    public String getProductLife() {
        return productLife;
    }

    public void setProductLife(String productLife) {
        this.productLife = productLife;
    }

    public String getDateProduction() {
        return dateProduction;
    }

    public void setDateProduction(String dateProduction) {
        this.dateProduction = dateProduction;
    }


    @Override
    public int compareTo(Product o) {
        int result;
        result = name.compareTo(o.name);
        if (result != 0) {
            return result;
        }
        result = dateProduction.compareTo(o.dateProduction);
        if (result != 0) {
            return result;
        }
        result = productLife.compareTo(o.productLife);
        if (result != 0) {
            return result;
        }
        result = articul.compareTo(o.articul);
        if (result != 0) {
            return result;
        }
        result = Integer.compare(price, o.price);
        if (result != 0) {
            return result;
        }

        return result;
    }
}


