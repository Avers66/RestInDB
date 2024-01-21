package avers66.restinmemory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * ListResponseDto
 *
 * @Author Tretyakov Alexandr
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListClientResponseDto {
    private List<ClientResponseDto> clients = new ArrayList<>();
}
