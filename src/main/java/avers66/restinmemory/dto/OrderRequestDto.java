package avers66.restinmemory.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * OrderRequestDto
 *
 * @Author Tretyakov Alexandr
 */

@Data
public class OrderRequestDto {

    @NotNull(message = "ID клиента должно быть указано")
    @Positive(message = "ID должен быть больше нуля")
    private Long clientId;

    @NotBlank(message = "Название продукта не может быть пустым")
    @Size(min = 3, max = 30, message = "Название продукта должно быть больше {min} и меньше {max}")
    private String product;

    @NotNull(message = "Цена должна быть указана")
    @PositiveOrZero(message = "Цена должна быть больше или равна нулю")
    private BigDecimal cost;
}
