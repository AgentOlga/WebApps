package me.ola.webapps2.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import me.ola.webapps2.service.IngredientService;
import me.ola.webapps2.service.RecipeService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOError;
import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/files")
@Tag(name = "API для работы с файлами рецептов и файлами ингредиентов", description = "Загрузка/Выгрузка" +
        "файлов рецептов и файлов ингредиентов.")
public class FileController {
    private final RecipeService recipeService;
    private final IngredientService ingredientService;

    @GetMapping("/recipe/export")
    @Operation(
            summary = "Выгрузка файла рецептов"
    )
    public ResponseEntity<InputStreamResource> downloadRecipesFile() {
        try {
            File recipeFile = recipeService.readFile();
            InputStreamResource resource = new InputStreamResource(new FileInputStream(recipeFile));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(recipeFile.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename" + recipeFile.getName())
                    .body(resource);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping(value = "/recipe/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(
            summary = "Загрузка файла рецептов"
    )
    public ResponseEntity<String> uploadRecipesFile(@RequestParam MultipartFile file) {
        try {
            recipeService.uploadFile(file);
            return ResponseEntity.ok("Файл успешно импортирован");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Ошибка при загрузке файла.Загрузите корректный файл");
        }
    }

    @PostMapping(value = "/ingredient/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(
            summary = "Загрузка файла ингредиентов"
    )
    public ResponseEntity<String> uploadIngredientsFile(@RequestParam MultipartFile file) {
        try {
            ingredientService.uploadFile(file);
            return ResponseEntity.ok("Файл успешно импортирован");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Ошибка при загрузке файла.Загрузите корректный файл");
        }

    }
}
