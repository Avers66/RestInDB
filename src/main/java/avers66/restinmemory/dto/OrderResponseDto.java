package avers66.restinmemory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * OrderResponseDto
 *
 * @Author Tretyakov Alexandr
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {
    private Long clientId;
    private String product;
    private BigDecimal cost;
}
