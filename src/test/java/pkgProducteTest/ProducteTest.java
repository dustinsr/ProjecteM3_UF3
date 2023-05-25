package pkgProducteTest;

import Producte.Producte;
import javafx.scene.control.Alert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pkgFitxers.Fitxers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProducteTest {

    private Producte producte;
    private Fitxers f = new Fitxers();
    private List<Producte> productes = new ArrayList<>();

    @BeforeEach
    void setUp() {
        // Inicializar el objeto producte antes de cada test
        producte = new Producte("Aigua", 1, "Aigua font vella", "2023-05-29");

        // Verificar si el producto está caducado
        producte.alertaCaducitat();
    }

    @AfterEach
    void tearDown() {
        // realizar después de ejecutar todos los tests
        System.out.println("Ejecutando acciones después de los tests...");
        // guardar los productos en un archivo
        productes.add(producte);
        try {
            StringBuilder stringBuilder = new StringBuilder();
            for (Producte producte : productes) {
                stringBuilder.append(producte.toString()).append("\n");
            }
            f.escriuTextFitxer("productes.txt", stringBuilder.toString(), true);
            System.out.println("Productos guardados en productes.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getNom() {
    }

    @Test
    void getPreu() {
    }

    @Test
    void getDescripcio() {
    }

    @Test
    void getData() {
    }

    @Test
    void getFitxer() {
    }

    @Test
    void guardaProducte() {
    }

    @Test
    void retornaStringProductes() {
    }

    @Test
    void cercarPerNom() {
    }

    @Test
    void cercarPerPreu() {
    }

    @Test
    void cercarPerDescripcio() {
    }

    @Test
    void cercarPerData() {
    }

    @Test
    void retornaProductes() {
    }

    @Test
    void retornaLlistaProductes() {
    }

    @Test
    void eliminaProducte() {
    }

    @Test
    void modificarProducte() {
    }

    @Test
    void alertaCaducitat() {
    }

    @Test
    void testToString() {
    }
}