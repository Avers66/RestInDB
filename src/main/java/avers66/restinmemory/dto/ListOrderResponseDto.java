package avers66.restinmemory.dto;

import avers66.restinmemory.model.Order;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * ListOrderResponseDto
 *
 * @Author Tretyakov Alexandr
 */


@Data
public class ListOrderResponseDto {
    private List<OrderResponseDto> orders = new ArrayList<>();
}
