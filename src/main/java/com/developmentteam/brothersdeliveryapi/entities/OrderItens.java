package com.developmentteam.brothersdeliveryapi.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Order_Itens", schema = "default")
public class OrderItens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItensId;

    @Column
    private String productId;

    @Column
    private String orderId;

    @Column
    private Integer quantity;
}
