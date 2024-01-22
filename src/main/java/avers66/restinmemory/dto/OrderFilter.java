package avers66.restinmemory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * OrderFilter
 *
 * @Author Tretyakov Alexandr
 */

@Data
@AllArgsConstructor
public class OrderFilter {


    private Integer pageSize;
    private Integer pageNumber;
    private String productName;
    private BigDecimal minCost;
    private BigDecimal maxCost;
    private Instant createdBefore;
    private Instant updatedBefore;
    private Long clientId;


}
