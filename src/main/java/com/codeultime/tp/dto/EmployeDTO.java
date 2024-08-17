package com.codeultime.tp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(name = "Employe")
@Setter
@Getter
@NoArgsConstructor
public class EmployeDTO {
    private Long id;
    @Schema(description = "Le nom de l'employé")
    private String nom;
    @Schema(description = "Le prénom de l'employé")
    private String prenom;
    @Schema(description = "Le salaire de l'employé")
    private Double salaire;
}
