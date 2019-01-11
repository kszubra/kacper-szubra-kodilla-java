package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.After;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    ItemDao itemDao;
    @Autowired
    ProductDao productDao;

    @After
    public void clearDatabase() {
        invoiceDao.deleteAll();
        itemDao.deleteAll();
        productDao.deleteAll();
    }

    @Ignore
    @Test
    public void testInvoiceDaoSave() {
        //given
        Product tomatoe = new Product("Tomatoe");
        productDao.save(tomatoe);
        Product cabbage = new Product("Cabbage");
        productDao.save(cabbage);
        Product watermelon = new Product("Watermelon");
        productDao.save(watermelon);
        Product onion = new Product("Onion");
        productDao.save(onion);

        Item tomatoesItem = new Item(tomatoe, new BigDecimal(0.2), 17);
        Item cabbagesItem = new Item(cabbage, new BigDecimal(1.2), 4);
        Item watermelonItem = new Item(watermelon, new BigDecimal(2.45), 5);
        Item onionItem = new Item(onion, new BigDecimal(0.1), 23);

        List<Item> itemsList = Arrays.asList(tomatoesItem, cabbagesItem, watermelonItem, onionItem);

        Invoice testInvoice = new Invoice("TestInvoice1", itemsList);

        tomatoesItem.setInvoice(testInvoice);
        cabbagesItem.setInvoice(testInvoice);
        watermelonItem.setInvoice(testInvoice);
        onionItem.setInvoice(testInvoice);

        //when
        invoiceDao.save(testInvoice);
        int invoiceId = testInvoice.getId();
        Invoice loadedInvoice = invoiceDao.findById(invoiceId).get();

        //then
        Assert.assertNotEquals(0, invoiceId);
        Assert.assertEquals(4, loadedInvoice.getItems().size());
        loadedInvoice.getItems().stream()
                .forEach(System.out::println);

    }
}
