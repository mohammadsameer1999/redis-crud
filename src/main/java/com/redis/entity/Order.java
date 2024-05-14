package com.redis.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "order_details")
public class Order implements Serializable {

    private static final long serialVersionUID = 214101981905645865L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String oderDetails;
    private int qty;
    private Long price;
}
