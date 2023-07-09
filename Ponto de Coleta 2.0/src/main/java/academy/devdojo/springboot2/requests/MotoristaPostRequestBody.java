package academy.devdojo.springboot2.requests;

import lombok.Data;

@Data
public class MotoristaPostRequestBody {
    private String name;
    private int idade;
    private Long cpf;
}
