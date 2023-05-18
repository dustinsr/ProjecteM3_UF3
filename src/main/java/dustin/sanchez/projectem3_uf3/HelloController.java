package dustin.sanchez.projectem3_uf3;

import Producte.Producte;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import pkgFitxers.Fitxers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloController {

    //<editor-fold desc="FXML">
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
    private TextField CercaNom;
    @FXML
    private TextField CercaPreu;
    @FXML
    private TextField CercaDescripcio;
    @FXML
    private DatePicker CercaData;
    @FXML
    private TextField DescripcioTrobat;
    @FXML
    private Button BPrimer;
    @FXML
    private Button BAbans;
    @FXML
    private Button BDespres;
    @FXML
    private Button BUltim;
    @FXML
    private Label NomTrobat;
    @FXML
    private Label PreuTrobat;
    @FXML
    private Label DataTrobat;
    //</editor-fold>

    //<editor-fold desc="Variables Globales">
    static Producte p = new Producte();
    static Fitxers f = new Fitxers();
    static List<Producte> contingutFitxer;           // variable estàtica amb el contingut del fitxer
    static String dir = ".dades";
    static private int numProductesCerca = 0;
    static private List<Producte> llistaProductesCerca = new ArrayList<>();
    //</editor-fold>


    /**
     /**
     * llegeix del fitxer i actualitza el TextArea amb el contingut del fitxer
     * formata les dades del fitxer per a que apareguin de manera ordenada

     * @throws IOException          Excepció d'Entrada / Sortida
     * @throws InterruptedException Excepció d'interrupció
     */
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

    /**
     * Tot el que vulguem executar en l'arrencada del formulari cada que iniciem l'aplicació
     *
     * @throws IOException          excepció d'Entrada i sortida
     * @throws InterruptedException excepció d'interrupció
     */
    public void initialize() throws IOException, InterruptedException {

        // comprovem que existeix el fitxer i si és així
        // llegim el fitxer
        // formatem les dades de les persones de manera més amigable
        if (f.existeixIO(p.getFitxer())) {
            actualitzaPantalla();
            p.alertaCaducitat();
        }
    }

    /**
     * Buidem els Text Fields
     */
    private void netejaCamps() {

        NomTextEscrit.setText("");
        PreuTextEscrit.setText("");
        DescripcioTextEscrit.setText("");
        DCTextEscrit.getEditor().clear();

    }

    /**
     * botó per guardar els productes
     *
     * @throws IOException          Excepció d'Entrada i Sortida
     * @throws InterruptedException Excepció d'interrupció
     */
    public void Guarda() throws IOException, InterruptedException {

        String nom = NomTextEscrit.getText();
        int preu = Integer.parseInt(PreuTextEscrit.getText());
        String descripcio = DescripcioTextEscrit.getText();
        String data = DCTextEscrit.getValue().toString();

        if (nom.length() >= 1 && preu >= 1 && descripcio.length() >= 1 && data.length() >= 1)
        // Ens assegurem que tots els camps estàn plens
        if (
                NomTextEscrit.getText().length() >= 1 &&
                        PreuTextEscrit.getText().length() >= 1 &&
                        DescripcioTextEscrit.getText().length() >= 1 &&
                        DCTextEscrit.getValue().lengthOfYear() >= 1
        ) {

            // Verificar que tots els camps estiguin plens
            if (nom.length() >= 1 && preu >= 1 && descripcio.length() >= 1 && data.length() >= 1);

            // Agafem els camps dels TextFields
/*            String nom = TFNom.getText();
            String cognom = TFCognom.getText();
            int edat = Integer.parseInt(TFEdat.getText());
            double sou = Double.parseDouble(TFSou.getText());*/

            // Construïm una persona amb aquests camps
                //Persona pers = new Persona(nom, cognom, edat, sou);
            Producte produc = new Producte(nom,preu,descripcio,data);

            // Agafem el text del botó (per comprovar si guardem o modifiquem)
            String textBoto = BTGuarda.getText();

            // si volem modificar
            if (!textBoto.equals("Guarda")) {
                BTGuarda.setText("Guarda");
                //produc.modificarPersona();
                produc.modificarProducte();
            } else {                    // si volem guardar
                //produc.guardaPersona();
                produc.guardaProducte();
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

    /**
     * Emmagatzema les dades i les neteja una vegada guardades
     */
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

    //<editor-fold desc="data caducitat alerta descart">
    /*public class AlertaCaducitatAliments {
        public static void main(String[] args) {
            List<Aliment> llistaAliments = obtenirLlistaAliments(); // obtenim la llista d'aliments de la font de dades

            StringBuilder missatgeAlerta = new StringBuilder();

            for (Aliment aliment : llistaAliments) {
                LocalDate dataCaducitat = aliment.getDataCaducitat();
                LocalDate dataActual = LocalDate.now();
                long diesFinsCaducitat = dataActual.until(dataCaducitat).getDays();

                if (diesFinsCaducitat <= 3) {
                    String nomAliment = aliment.getNom();
                    missatgeAlerta.append(nomAliment).append(" caduca en ").append(diesFinsCaducitat).append(" dies.\n");
                }
            }

            if (missatgeAlerta.length() > 0) {
                JOptionPane.showMessageDialog(null, missatgeAlerta.toString(), "Aliments a punt de caducar", JOptionPane.WARNING_MESSAGE);
            }
        }

        private static List<Aliment> obtenirLlistaAliments() {
            // codi per obtenir la llista d'aliments de la font de dades
            // retorna una llista d'objectes Aliment
        }
    }*/

    /*class Aliment {
        private String nom;
        private LocalDate dataCaducitat;

        // constructor i getters i setters
    }*/
    //</editor-fold>






}