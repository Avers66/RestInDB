package avers66.restinmemory.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Order
 *
 * @Author Tretyakov Alexandr
 */


@Getter
@Setter
@ToString
@Builder
@Entity(name = "'order'")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product ;

    @Column(columnDefinition = "numeric(38)")
    private BigDecimal cost;

    @CreationTimestamp
    @Column(name = "create_at")
    private Instant createAt;

    @UpdateTimestamp
    @Column(name = "update_at")
    private Instant updateAt;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;



}
