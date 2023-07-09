package academy.devdojo.springboot2.requests;

import lombok.Data;

@Data
public class ColetoresPutRequestBody {
    private Long id;
    private String name;
    private int idade;
    private Long cpf;
}
