package avers66.restinmemory.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RequesDto
 *
 * @Author Tretyakov Alexandr
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDto {

    @NotBlank(message = "Имя клиента должно быть заполнено")
    @Size(min = 3, max = 30, message = "Имя клиента должно быть больше {min} и меньше {max}")
    private String name;
}
