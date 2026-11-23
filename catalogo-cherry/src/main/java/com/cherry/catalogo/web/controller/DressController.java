package com.cherry.catalogo.web.controller;

import com.cherry.catalogo.domain.Dress;
import com.cherry.catalogo.domain.service.DressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dresses")
@CrossOrigin(origins = "*")
@Tag(name = "Dress", description = "Administra el catalogo de vestidos")
public class DressController {

    private final DressService dressService;

    public DressController(DressService dressService) {
        this.dressService = dressService;
    }

    @GetMapping
    @Operation(summary = "Get all dresses", description = "Return a list of all dresses in the catalog")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of dresses")
    public ResponseEntity<List<Dress>> getAll() {
        return ResponseEntity.ok(dressService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get dress by ID", description = "Return a dress by its ID if it exists")
    @ApiResponse(responseCode = "200", description = "Dress found")
    @ApiResponse(responseCode = "404", description = "Dress not found")
    public ResponseEntity<Dress> getById(@PathVariable Long id) {
        return dressService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{category}")
    @Operation(summary = "Get dresses by category", description = "Return all dresses of a category")
    public ResponseEntity<List<Dress>> getByCategory(@PathVariable String category) {
        return ResponseEntity.ok(dressService.getByCategory(category));
    }

    @PostMapping
    @Operation(summary = "Create a dress", description = "Add a new dress to the catalog")
    @ApiResponse(responseCode = "201", description = "Dress created")
    public ResponseEntity<Dress> save(@Valid @RequestBody Dress dress) {
        return new ResponseEntity<>(dressService.save(dress), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a dress", description = "Update an existing dress")
    @ApiResponse(responseCode = "200", description = "Dress updated")
    @ApiResponse(responseCode = "404", description = "Dress not found")
    public ResponseEntity<Dress> update(@PathVariable Long id, @Valid @RequestBody Dress dress) {
        return dressService.update(id, dress)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a dress", description = "Remove a dress from the catalog")
    @ApiResponse(responseCode = "200", description = "Dress deleted")
    @ApiResponse(responseCode = "404", description = "Dress not found")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return dressService.delete(id)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
