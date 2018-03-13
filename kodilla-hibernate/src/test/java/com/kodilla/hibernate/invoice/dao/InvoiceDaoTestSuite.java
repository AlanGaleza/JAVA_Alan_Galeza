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

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Invoice invoice = new Invoice("INVOICE1");

        Product product1 = new Product("Car");
        Product product2 = new Product("Laptop");
        productDao.save(product1);
        productDao.save(product2);

        Item item1 = new Item(new BigDecimal(120), 10);
        Item item2 = new Item(new BigDecimal(220), 20);
        Item item3 = new Item(new BigDecimal(500), 3);

        item1.setProduct(product1);
        item2.setProduct(product1);
        item3.setProduct(product2);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);

        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);

        //When
        invoiceDao.save(invoice);
        int idInvoice = invoice.getId();

        //Then
        Assert.assertEquals("Car", invoice.getItems().get(0).getProduct().getName());

        //CleanUp

        try {
            invoiceDao.delete(idInvoice);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
