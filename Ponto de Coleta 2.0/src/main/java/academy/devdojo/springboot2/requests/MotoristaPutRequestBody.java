package academy.devdojo.springboot2.requests;

import lombok.Data;

@Data
public class MotoristaPutRequestBody {
    private Long id;
    private String name;
    private int idade;
    private Long cpf;
}
