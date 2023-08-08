package com.developmentteam.brothersdeliveryapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class OrderItemPrimaryKey implements Serializable {

    @Column(name = "orderId")
    private Long orderId;

    @Column(name = "productId")
    private Long productId;

}
