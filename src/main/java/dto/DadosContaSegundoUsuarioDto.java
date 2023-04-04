package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class DadosContaSegundoUsuarioDto {
    String numeroDaConta;
    String digitoDaConta;
}
