package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ItemDao itemDao;

/*
    @Test
    public void testItemDaoSave() {
        //Given
        Product product = new Product("intel");
        Item item = new Item(new BigDecimal(1004), 100);
        item.setProduct(product);

        //When
        itemDao.save(item);
        int idItem = item.getId();

        //Then
        Assert.assertEquals("intel", item.getProduct().getName());

        //Cleanup

        try {
            itemDao.delete(idItem);
        } catch (Exception e) {
            System.out.println( e );
        }
    }
*/

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Invoice invoice = new Invoice("INVOICE1");
        Item item1 = new Item(new BigDecimal(120), 10);
        Item item2 = new Item(new BigDecimal(500), 200);
        Product product1 = new Product("Car");
        Product product2 = new Product("fg");

        item1.setProduct(product1);
        item2.setProduct(product2);
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);

        //When
        invoiceDao.save(invoice);
        int idInvoice = invoice.getId();

        //Then
        Assert.assertEquals("Car", invoice.getItems().get(0).getProduct().getName());
        Assert.assertEquals(2, invoice.getItems().size());

        //CleanUp

        try {
            invoiceDao.delete(idInvoice);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
