package Producte;

import dustin.Sanchez.Fitxers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Persona.
 *
 * @author vicent  Classe que implementa mètodes d'accés a fitxers i alguns mèetodes per utilitzar l'Agenda
 * @since 3.33
 */
public class Producte {

    //<editor-fold desc="PROPIETATS">
    // variables
    private int id; //Identificador producto
    private String nom;
    private int preu;
    private String descripcio;
    private String data;


    //</editor-fold>


    static final String fitxer = "productes.csv";
    static final String fitxerBin = "productes.dat";
    static final Fitxers f = new Fitxers();
    //static final Fitxers f = new Fitxers(fitxerBin);


    //<editor-fold desc="CONSTRUCTORS">
    // constructors

    /**
     * Instantiates a new Persona.
     */
    public Producte() {
        this.id=System.identityHashCode(this);
    }

    /**
     * Instantiates a new Persona.
     *
     * @param nom    the nom
     * @param preu the cognom
     * @param descripcio   the edat
     * @param data    the sou
     */
    public Producte(String nom, int preu, String descripcio, String data) {
        this.id=System.identityHashCode(this);

        this.nom = nom;
        this.preu = preu;
        this.descripcio = descripcio;
        this.data = data;
    }
    //</editor-fold>

    //<editor-fold desc="GETTERS">
    // getters


    public String getNom() {
        return nom;
    }

    public int getPreu() {
        return preu;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public String getData() {
        return data;
    }

    public String getFitxer() {
        return fitxer;
    }
    //</editor-fold>

    //<editor-fold desc="MÈTODES">
    // toString


    // guardar persona fitxer


    /**
     * Guarda persona.
     *
     * @throws IOException the io exception
     */
    public void guardaProducte() throws IOException {
//        String text;
//        text=getNom()+";"+getCognom()+";"+getEdat()+";"+getSou();
        f.escriuTextFitxer(fitxer, this.toString(), true);

    }

    /*
    public void guardaProductse() {
        f.escriuObjecteFitxer(this, true);
    } */


    /**
     * Retorna string persones string.
     *
     * @return the string
     */
    public String retornaStringProductes() throws IOException, InterruptedException {
        return f.retornaContingutFitxer(fitxer,"UTF-8");
    }

    /**
     * Cercar per cognom string.
     *
     * @param cognomACercar the cognom a cercar
     * @return the string
     */
    // cercar per cogonom
    //Para buscar por nom, preu, descripcio o data
    public List<Producte> cercarPerCognom(String cognomACercar) throws IOException, InterruptedException {
        List<String> persones = f.retornaContingutFitxer(fitxer);
        String cognom;
        List<Producte> productesTrobades = new ArrayList<>();

        for (String fila : persones) {
            String[] dades = fila.split(";");
            cognom = dades[1];
            if (cognom.equals(cognomACercar)) {
                Producte pers = new Producte(
                        dades[0],
                        Integer.parseInt(dades[1]),
                        dades[2],
                        dades[3]
                );

                productesTrobades.add(pers);
            }
        }

        return productesTrobades;
    }


    /**
     * Retorna persones persona [ ].
     *
     * @return the persona [ ]
     * @deprecated perquè tenim el mètode que retorna una llista de Persones
     */
    @Deprecated
    public Producte[] retornaProductes() throws IOException, InterruptedException {

        String persones = f.retornaContingutFitxer(fitxer,"UTF-8");

        String[] files = persones.split("\n");
        int cont = files.length;


        Producte[] arrayProductes = new Producte[cont];


        for (int i = 0; i < files.length; i++) {
            String[] dades = files[i].split(";");

            Producte p1 = new Producte(
                    dades[0],
                    Integer.parseInt(dades[1]),
                    dades[2],
                    dades[3]);

            arrayProductes[i] = p1;

        }
        return arrayProductes;
    }

    /**
     * Retorna persones persona [ ].
     *
     * @return the persona [ ]
     *
     */

    /*

    public List<Producte> retornaLlistaProductes() throws IOException, InterruptedException {
        List<Object> objectes = f.retornaFitxerObjectenllista();
        List<Producte> productestotal = converteixPErsona;
        return productestotal;
    } */

   /* public List<Producte> retornaLlistaProductes() throws IOException, InterruptedException {
        List <Producte> lProductes = new ArrayList<>();

        for (Object obj: objectes)
    }

   public List<Producte> cercar(String cercar) {
        Lista<Producte> productes = retornaLlistaProductes();
    } */




    public List<Producte> retornaLlistaProductes() throws IOException, InterruptedException {

        String productes = f.retornaContingutFitxer(fitxer,"UTF-8");

        String[] files = productes.split("\n");


        List<Producte> llista = new ArrayList<>();


        for (int i = 0; i < files.length; i++) {
            String[] dades = files[i].split(";");

            Producte p1 = new Producte(
                    dades[0],
                    Integer.parseInt(dades[1]),
                    dades[2],
                    dades[3]);

            llista.add(p1);

        }
        return llista;
    }


    /**
     * Elimina una persona del fitxer a partir del seu cognom.
     *
     * @param cognom cognom de la persona a eliminar
     * @throws IOException Excepció d'Entrada/Sortida
     * @see #retornaProductes()
     */

   /* public void eliminaPersona(String cognom, int numProducte) throws IOException, InterruptedException {
        List<Producte> productes = retornaLlistaProductes();
        boolean afegir = false;
        boolean trobat=false;
        int contaProducte = 0;

        for (int i = 0; i < productes.size(); i++) {

            if (!productes.get(i).getNom().equals(cognom) || trobat) {
                f.escriuObjecteFitxer(productes.get(i), afegir);
                afegir = true;
            } else {
                if (contaProducte == numProducte)
                    trobat = true;
                else {
                    f.escriuObjecteFitxer(productes.get(i), afegir);
                    afegir = true;
                }
                contaProducte++;
            }

        }

    }
    */


    public void eliminaPersona(String cognom) throws IOException, InterruptedException {
        Producte[] persones = retornaProductes();
        boolean afegir = false;
        boolean trobat=false;

        for (int i = 0; i < persones.length; i++) {
            // sobreescrivim el fitxer excloent la persona a eliminar
            if (!persones[i].getNom().equals(cognom) || trobat) {
                f.escriuTextFitxer(fitxer, persones[i].toString(), afegir);
                afegir = true;
            }else{
                trobat=true;        // així sols eliminem una sola persona amb el cognom i no totes
            }
        }
    }

    /**
     * Modificar persona.
     *
     * @throws IOException the io exception
     */
    public void modificarPersona() throws IOException, InterruptedException {
        Producte[] persones = retornaProductes();
        boolean afegir = false;
        boolean trobat = false;

        for (int i = 0; i < persones.length; i++) {
            // sobreescrivim el fitxer excloent la persona a modificar
            if (!persones[i].getNom().equals(this.nom) &&
                    !persones[i].getNom().equals(this.nom) || trobat) {
                f.escriuTextFitxer(fitxer, persones[i].toString(), afegir);
                afegir = true;
            } else {
                f.escriuTextFitxer(fitxer, this.toString(), afegir);
                afegir = true;
                trobat = true;
            }
        }
    }


    @Override
    public String toString() {
        return nom + ";" + preu + ";" + descripcio + ";" + data;
    }

    //</editor-fold>

}
