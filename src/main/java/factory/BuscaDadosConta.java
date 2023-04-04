package factory;


import dto.DadosContaSegundoUsuarioDto;

public class BuscaDadosConta {

    public static DadosContaSegundoUsuarioDto BuscaDadosConta (String numeroDaConta, String  digitoDaConta) {

        return new DadosContaSegundoUsuarioDto(
                numeroDaConta,
                digitoDaConta
                );
    }
}

