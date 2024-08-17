package com.codeultime.tp.rest;

import com.codeultime.tp.dto.EmployeDTO;
import com.codeultime.tp.service.EmployeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employe")
public class EmployeController {

    public final EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le resultat est ok"),
            @ApiResponse(responseCode = "400", description = "Erreur metier (bad request)"),
            @ApiResponse(responseCode = "401", description = "Utilisateur non autorisé"),
            @ApiResponse(responseCode = "404", description = "La resource non identifier"),
            @ApiResponse(responseCode = "500", description = "Erreur technique"),
    })
    @Operation(description = "Retourne la liste des employés")
    public ResponseEntity<List<EmployeDTO>> getAll() {
        return new ResponseEntity<>(employeService.getEmployes(), HttpStatus.OK);
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "203", description = "La création est ok"),
            @ApiResponse(responseCode = "400", description = "Incohérence des données d'entrée"),
            @ApiResponse(responseCode = "401", description = "Utilisateur non autorisé"),
            @ApiResponse(responseCode = "404", description = "La resource non identifier"),
            @ApiResponse(responseCode = "500", description = "Erreur technique"),
    })
    @Operation(description = "Creaction d'un employé")
    public ResponseEntity<EmployeDTO> creat(@RequestBody EmployeDTO employe) {
        return new ResponseEntity<>(employeService.create(employe), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "La modification est ok"),
            @ApiResponse(responseCode = "400", description = "Incohérence des données d'entrée"),
            @ApiResponse(responseCode = "401", description = "Utilisateur non autorisé"),
            @ApiResponse(responseCode = "404", description = "Resource non identifiée"),
            @ApiResponse(responseCode = "500", description = "Erreur technique"),
    })
    @Operation(description = "Modification d'un employé")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody EmployeDTO employe) {
        employeService.updateEmploye(id, employe);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "La suppression est ok"),
            @ApiResponse(responseCode = "400", description = "Incohérence des données d'entrée"),
            @ApiResponse(responseCode = "401", description = "Utilisateur non autorisé"),
            @ApiResponse(responseCode = "404", description = "Resource non identifiée"),
            @ApiResponse(responseCode = "500", description = "Erreur technique"),
    })
    @Operation(description = "Suppression d'un employé")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeService.suppression(id);
        return ResponseEntity.noContent().build();
    }
}
