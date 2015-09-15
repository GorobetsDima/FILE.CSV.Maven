package HomeWorkCSV.tests;

import HomeWorkCSV.Product;
import org.fest.assertions.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Gorobets Dmitriy on 15.09.2015.
 */
public class ProductTest {
    List<Product> list;
    Product p;
    Product p1;
    Product p2;
    Product p3;


    @Before
    public void setUpBeforeTestProduct() throws FileNotFoundException {
        list = new LinkedList<>();
        p = new Product();
        p.setPrice(10);
        p.setProductLife("12");
        p.setDateProduction("3.4.3");
        p.setArticul("3234");
        p.setName("milk");

        p1 = new Product();
        p1.setPrice(10);
        p1.setProductLife("12");
        p1.setDateProduction("3.4.3");
        p1.setArticul("3234");
        p1.setName("milk");

        p2 = new Product();
        p2.setPrice(10);
        p2.setProductLife("12");
        p2.setDateProduction("3.4.3");
        p2.setArticul("3234");
        p2.setName("meat");

        list.add(p);
        list.add(1, p1);
        p3 = new Product("Свинина", "мс10тр1к", "5.09.2015", "10 дней", 75);

    }

    @Test
    public void tst_DefaultProductConstractor() {
        Product p4 = new Product();
        assertTrue(p4.getPrice() == 0);
        assertTrue(p4.getArticul() == null);
        assertTrue(p4.getDateProduction() == null);
        assertTrue(p4.getProductLife() == null);
        assertTrue(p4.getName() == null);
    }

    @Test
    public void tst_ProductConstractorWithParametersFalse() {

        assertFalse(p3.getPrice() == 0);
        assertFalse(p3.getArticul() == null);
        assertFalse(p3.getDateProduction() == null);
        assertFalse(p3.getProductLife() == null);
        assertFalse(p3.getName() == null);
    }


    @Test
    public void tst_PriceField() {
        assertTrue(p.getPrice() == 10);
    }

    @Test
    public void tst_EqualsProductLifeField() {
        assertTrue(p.getProductLife().equals("12"));
    }

    @Test
    public void tst_ProductLifeField() {
        assertTrue(p.getProductLife() == "12");
    }

    @Test
    public void tst_EqualsDateProductionField() {
        assertTrue(p.getDateProduction().equals("3.4.3"));
    }

    @Test
    public void tst_DateProductionField() {
        assertTrue(p.getDateProduction() == "3.4.3");
    }

    @Test
    public void tst_EqualsArticulField() {
        assertTrue(p.getArticul().equals("3234"));
    }

    @Test
    public void tst_ArticulField() {
        assertTrue(p.getArticul() == "3234");
    }

    @Test
    public void tst_EqualsNameField() {
        assertTrue(p.getName().equals("milk"));
    }

    @Test
    public void tst_NameField() {
        assertTrue(p.getName() == "milk");
    }

    @Test
    public void tst_InstanceOfProductP() {
        Assertions.assertThat(p).isInstanceOf(Product.class);

    }

    @Test
    public void tst_InstanceOfProductP1() {
        Assertions.assertThat(p1).isInstanceOf(Product.class);

    }

    @Test
    public void tst_TrueCompareToProduct() {
        assertTrue(p1.compareTo(p) == 0);

    }

    @Test
    public void tst_FalseInstanceOfProductP1() {
        assertFalse((p1.compareTo(p2) == 0));

    }


    @Test
    public void tst_ContainsLinkedList() {
        Assertions.assertThat(list).contains(p, p1);

    }

    @Test
    public void tst_NotEmptyLinkedList1() {
        Assertions.assertThat(list).isNotEmpty();

    }

    @Test
    public void tst_LinkedListHasSize() {
        Assertions.assertThat(list.iterator()).hasSize(2);

    }

    @Test
    public void tst_LinkedListRemoveHasSize() {
        list.remove(0);

        Assertions.assertThat(list.iterator()).hasSize(1);

    }

    @Test
    public void tst_LinkedListRemoveAllHasSize() {
        list.remove(0);
        list.remove(0);

        Assertions.assertThat(list.iterator()).hasSize(0);

    }

    @Test
    public void tst_checkSameWriteToLinkedList1() {
        assertSame(list.get(0), p);

    }

    @Test
    public void tst_checkSameWriteToLinkedList2() {
        assertSame(list.get(1), p1);

    }

    @After

    public void setUpAfterTestProduct() {
        list = null;
        p = null;
        p1 = null;
        p2 = null;
        p3 = null;


    }


}
