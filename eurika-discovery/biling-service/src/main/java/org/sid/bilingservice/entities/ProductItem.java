package org.sid.bilingservice.entities;



import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.sid.bilingservice.model.Product;

import javax.persistence.*;

@Entity
@AllArgsConstructor @NoArgsConstructor
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double quantity;
    private double price;
    private Long productID;
    @ManyToOne
    private Bill bill;
    @Transient
    private Product product;


}
