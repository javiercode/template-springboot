package ubilapaz.edu.bo.template.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LibroDto {
    private String autor;
    private String titulo;
    private String formato;
    private String editorial;
}
