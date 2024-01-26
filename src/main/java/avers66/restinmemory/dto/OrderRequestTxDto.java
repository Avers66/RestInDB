package avers66.restinmemory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * OrderRequestTxDto
 *
 * @Author Tretyakov Alexandr
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequestTxDto {

    private String product;
    private BigDecimal cost;
}
