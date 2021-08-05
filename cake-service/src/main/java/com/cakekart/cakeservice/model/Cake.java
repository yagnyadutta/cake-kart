package com.cakekart.cakeservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.*;

@Data
@Document(collection = "cakes")
@AllArgsConstructor
@NoArgsConstructor
public class Cake {

    @Id
    private String id;
    String name;
    Category category;
    List<Review> reviews;
    double[] availableWaights;
    String specialInst;
    String note;
    String imgPath;
    boolean veg;

}
