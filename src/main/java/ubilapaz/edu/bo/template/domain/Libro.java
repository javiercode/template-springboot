package ubilapaz.edu.bo.template.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "AUTOR")
    private String autor;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "FORMATO")
    private String formato;

    @Column(name = "EDITORIAL")
    private String editorial;

    @Column(name = "FECHA_REGISTRO")
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    @Column(name = "FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;
}



