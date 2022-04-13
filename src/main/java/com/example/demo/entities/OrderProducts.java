package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class OrderProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderProductsId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supp_org_id")
    private Organization suppOrgId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supp_user_id")
    private User suppUserId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private DictProduct product;

    private Long offeredPrice;
    @Column(nullable = false)
    private Long requestedPrice;
    @Column(nullable = false)
    private Long quantity;
    @Column(nullable = false)
    private Long status;
}
