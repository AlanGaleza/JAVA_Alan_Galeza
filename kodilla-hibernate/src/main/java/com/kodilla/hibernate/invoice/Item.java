package com.kodilla.hibernate.invoice;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "ITEM")
public class Item {
    private int id;
    private BigDecimal price;
    private int quantity;
    private BigDecimal value;
    private Product product;


}
