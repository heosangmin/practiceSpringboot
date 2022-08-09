package dev.mamekun.springboot.relationship.data.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "product_detail")
@Setter
@Getter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode()
public class ProductDetail extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @OneToOne()
    @JoinColumn(name = "product_number")
    private Product product;
}
