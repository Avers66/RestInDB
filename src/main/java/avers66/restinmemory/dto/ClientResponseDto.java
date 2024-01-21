package avers66.restinmemory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * ResponseDto
 *
 * @Author Tretyakov Alexandr
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDto {

    private Long id;
    private String name;
    private List<OrderResponseDto> orders = new ArrayList<>();
}
