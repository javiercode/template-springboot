package ubilapaz.edu.bo.template.service.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response {
//    private Integer codigo;
    private Boolean success=false;
    private String mensaje;
}
