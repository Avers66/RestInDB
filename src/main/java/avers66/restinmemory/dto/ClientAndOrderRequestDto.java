package avers66.restinmemory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClientAndOrderRequest
 *
 * @Author Tretyakov Alexandr
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientAndOrderRequestDto {

    private String name;
    private List<OrderRequestTxDto> orders;
}
