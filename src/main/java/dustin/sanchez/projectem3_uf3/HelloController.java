package dustin.sanchez.projectem3_uf3;

import Producte.Producte;
import dustin.Sanchez.Fitxers;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML
    private Button BTGuarda;
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
    @FXML
    private Label LBTrue;
    @FXML
    private TextField CodiNom;
    @FXML
    private Button BPrimer;
    @FXML
    private Button BAbans;
    @FXML
    private Button BDespres;
    @FXML
    private Button BUltim;




    static Producte p = new Producte();
    static Fitxers f = new Fitxers();
    static List<Producte> contingutFitxer;           // variable estàtica amb el contingut del fitxer
    static String dir = ".dades";
    static private int numProductesCerca = 0;
    static private List<Producte> llistaProductesCerca = new ArrayList<>();

    private void converteixCsvaBin() {

    }


    public void initialize() throws IOException, InterruptedException {

        // comprovem que existeix el fitxer i si és així
        // llegim el fitxer
        // formatem les dades de les persones de manera més amigable
        if (f.existeixIO(p.getFitxer())) {
            actualitzaPantalla();
        }
    }

    private void mostraBotons_Direccio(boolean mostra) {
        comprovaBotonera();
        BPrimer.setVisible(mostra);
        BAbans.setVisible(mostra);
        BDespres.setVisible(mostra);
        BUltim.setVisible(mostra);


        if(!mostra)
            numProductesCerca = 0;

    }

    private void comprovaBotonera() {
        if (numProductesCerca >0) {
            BPrimer.setDisable(false);
            BAbans.setDisable(false);
        }
        else  {
            BPrimer.setDisable(true);
            BAbans.setDisable(true);
            BUltim.setDisable(false);

        }
        if (numProductesCerca < llistaProductesCerca.size() -1){
            BUltim.setDisable(false);
            BDespres.setDisable(false);
        } else {
            BUltim.setDisable(true);
            BDespres.setDisable(true);
            BPrimer.setDisable(false);
        }
    }


    //<editor-fold desc="Botones">
    public void bprimer() {
        numProductesCerca = 0;
        comprovaBotonera();
        mostraProducte(llistaProductesCerca.get(numProductesCerca));
    }

    public void babans() {
        numProductesCerca--;
        comprovaBotonera();
        mostraProducte(llistaProductesCerca.get(numProductesCerca));
    }

    public void bseguent() {
        numProductesCerca++;
        comprovaBotonera();
        mostraProducte(llistaProductesCerca.get(numProductesCerca));
    }

    public void bultim() {
        numProductesCerca = llistaProductesCerca.size() -1;
        comprovaBotonera();
        mostraProducte(llistaProductesCerca.get(numProductesCerca));
    }
    //</editor-fold>

    public void mostraProducte (Producte prod){

        NomTextEscrit.setText(prod.getNom());
        PreuTextEscrit.setText(String.valueOf(prod.getPreu()));
        DescripcioTextEscrit.setText(prod.getDescripcio());
       // DCTextEscrit.setText(prod.getData());

    }


    /*
    public void cancela() {
        netejaCamps();
        llistaProductecerca.clear();
        mostraBotons_Direccio(false);
        BTGuarda.setText("Guarda");
        LBError.setText("")
    } */


    public void Cerca() {


    }

    public void Treu() {
    }



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

    private void netejaCamps() {

        NomTextEscrit.setText("");
        PreuTextEscrit.setText("");
        DescripcioTextEscrit.setText("");
        DCTextEscrit.getEditor().clear();

    }

    public void Guarda() throws IOException, InterruptedException {

        LBTrue.setText("");

        // Ens assegurem que tots els camps estàn plens
        if (
                NomTextEscrit.getText().length() >= 1 &&
                        PreuTextEscrit.getText().length() >= 1 &&
                        DescripcioTextEscrit.getText().length() >= 1 &&
                        DCTextEscrit.getValue().toString().length() >= 1
        ) {
            String nom = NomTextEscrit.getText();
            int preu = Integer.parseInt(PreuTextEscrit.getText());
            String descripcio = DescripcioTextEscrit.getText();
            String data = DCTextEscrit.getValue().toString();


            // Construïm una persona amb aquests camps
            Producte pers = new Producte(nom, preu, descripcio, data);

            // Agafem el text del botó (per comprovar si guardem o modifiquem)
            String textBoto = BTGuarda.getText();

            // si volem modificar
            if (!textBoto.equals("Guarda")) {
                BTGuarda.setText("Guarda");
                pers.modificarPersona();
            } else {                    // si volem guardar
                pers.guardaProducte();
            }
            LBTrue.setText("PRODUCTE GUARDAT!!");
            NomText.setText("- NOM: "+nom);
            PreuText.setText("- PREU: "+(preu)+"€");
            DescripcioText.setText(descripcio);
            DataCaducitatText.setText("- DATA: "+data);
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



}