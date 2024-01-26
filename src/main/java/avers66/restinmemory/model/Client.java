package avers66.restinmemory.model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Client
 *
 * @Author Tretyakov Alexandr
 */

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Order> orderList = new ArrayList<>();


    public void addOrder(Order order) {
        orderList.add(order);
    }

    public void remove(Order order) {
        orderList = orderList.stream().filter((o) -> !o.getId().equals(order.getId())).collect(Collectors.toList());
    }
}
