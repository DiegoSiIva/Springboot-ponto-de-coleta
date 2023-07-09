package academy.devdojo.springboot2.requests;

import java.sql.Date;

import lombok.Data;

@Data
public class PontoDeColetaPostRequestBody {
    private String bairro;
    private Date dia;
    private Date horario;
}