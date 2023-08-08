package com.developmentteam.brothersdeliveryapi.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class OrderItemId implements Serializable {

    private Long orderId;

    private Long itemId;

}
