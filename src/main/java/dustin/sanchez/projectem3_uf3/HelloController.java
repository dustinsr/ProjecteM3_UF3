package dustin.sanchez.projectem3_uf3;

import Producte.Producte;
import dustin.Sanchez.Fitxers;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class HelloController {

    @FXML
    private TextField NomTextEscrit;
    @FXML
    private TextField PreuTextEscrit;
    @FXML
    private DatePicker DCTextEscrit;
    @FXML
    private TextField DescripcioTextEscrit;
    @FXML
    private Label NomText;
    @FXML
    private Label PreuText;
    @FXML
    private TextField DescripcioText;
    @FXML
    private Label DataCaducitatText;

    static Producte p = new Producte();
    static Fitxers f = new Fitxers();
    static List<Producte> contingutFitxer;           // variable estàtica amb el contingut del fitxer
    static String dir = ".dades";                     // no utilitzat el directori


    private void actualitzaPantalla() throws IOException, InterruptedException {
        contingutFitxer = p.retornaLlistaProductes();
       // LBNumPersones.setText(contingutFitxer.size() + " persones");      // quantitat de persones en el fitxer
        String text = "";

        for (Producte prod : contingutFitxer) {
            text = text +
                    prod.getNom() + " " + prod.getPreu() + " €" + "\n" +
                    prod.getDescripcio() + " \n"
                    + prod.getData() + "\n\n";
        }

    }

    public void initialize() throws IOException, InterruptedException {

        // comprovem que existeix el fitxer i si és així
        // llegim el fitxer
        // formatem les dades de les persones de manera més amigable
        if (f.existeixIO(p.getFitxer())) {
            actualitzaPantalla();
        }
    }

    private void netejaCamps() {

        NomTextEscrit.setText("");
        PreuTextEscrit.setText("");
        DescripcioTextEscrit.setText("");
        DCTextEscrit.getEditor().clear();

    }

    public void Guarda() throws IOException, InterruptedException {

        String nom = NomTextEscrit.getText();
        int preu = Integer.parseInt(PreuTextEscrit.getText());
        String descripcio = DescripcioTextEscrit.getText();
        String data = DCTextEscrit.getValue().toString();


        // Ens assegurem que tots els camps estàn plens
        if (
                NomTextEscrit.getText().length() >= 1 &&
                        PreuTextEscrit.getText().length() >= 1 &&
                        DescripcioTextEscrit.getText().length() >= 1 &&
                        DCTextEscrit.getText().length() >= 1
        ) {

            // Agafem els camps dels TextFields
            String nom = TFNom.getText();
            String cognom = TFCognom.getText();
            int edat = Integer.parseInt(TFEdat.getText());
            double sou = Double.parseDouble(TFSou.getText());

            // Construïm una persona amb aquests camps
            Persona pers = new Persona(nom, cognom, edat, sou);

            // Agafem el text del botó (per comprovar si guardem o modifiquem)
            String textBoto = BTGuardaPersona.getText();

            // si volem modificar
            if (!textBoto.equals("Guarda")) {
                BTGuardaPersona.setText("Guarda");
                pers.modificarPersona();
            } else {                    // si volem guardar
                pers.guardaPersona();
            }
            netejaCamps();              // reiniciem els TextFields
            actualitzaPantalla();       // recarreguem el fitxer al TextArea
        } else {
            // En cas que no hagim posat algun dels camps als textFields. Missatge de Warning avisant
            Alert al = new Alert(Alert.AlertType.WARNING);
            al.setTitle("ERROR");
            al.setContentText("Has d'omplir tots els camps");
            al.show();
        }
    }


    public void BTAlmacenar() {
        String nom = NomTextEscrit.getText();
        int preu = Integer.parseInt(PreuTextEscrit.getText());
        String descripcio = DescripcioTextEscrit.getText();
        String data = DCTextEscrit.getValue().toString();


        NomText.setText("- NOM: "+nom);
        PreuText.setText("- PREU: "+(preu)+"€");
        DescripcioText.setText(descripcio);
        DataCaducitatText.setText("- DATA: "+data);

        netejaCamps();



    }



}