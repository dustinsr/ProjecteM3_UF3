package Producte;

import pkgFitxers.Fitxers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Producte.
 *
 * @author Dustin, Bryan777s  Classe que implementa mètodes d'accés a fitxers i alguns mèetodes per utilitzar l'Nevera
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


    /**
     * The Fitxer.
     */
    static final String fitxer = "productes.csv";
    /**
     * The Fitxer bin.
     */
    static final String fitxerBin = "productes.dat";
    /**
     * The F.
     */
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
     * @param nom        the nom
     * @param preu       the el preu
     * @param descripcio the descripcio
     * @param data       the data product
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


    /**
     * Gets nom.
     *
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Gets preu.
     *
     * @return the preu
     */
    public int getPreu() {
        return preu;
    }

    /**
     * Gets descripcio.
     *
     * @return the descripcio
     */
    public String getDescripcio() {
        return descripcio;
    }

    /**
     * Gets data.
     *
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * Gets fitxer.
     *
     * @return the fitxer
     */
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
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    public String retornaStringProductes() throws IOException, InterruptedException {
        return f.retornaContingutFitxer(fitxer,"UTF-8");
    }

    //<editor-fold desc=" cercar per nom, preu, descripcio o data">
    /**
     * Cercar per nom string.
     *
     * @param nomACercar the cognom a cercar
     * @return the string
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    public List<Producte> cercarPerNom(String nomACercar) throws IOException, InterruptedException {
        List<String> productes = f.retornaContingutFitxerLlista(fitxer);
        String nom;
        List<Producte> productesTrobades = new ArrayList<>();

        for (String fila : productes) {
            String[] dades = fila.split(";");
            nom = dades[0];
            if (nom.equalsIgnoreCase(nomACercar)) {
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
     * Cercar per preu list.
     *
     * @param preuACercar the preu a cercar
     * @return the list
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    public List<Producte> cercarPerPreu(String preuACercar) throws IOException, InterruptedException {
        List<String> productes = f.retornaContingutFitxerLlista(fitxer);
        String preu;
        List<Producte> productesTrobades = new ArrayList<>();

        for (String fila : productes) {
            String[] dades = fila.split(";");
            preu = dades[1];
            if (preu.equals(preuACercar)) {
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
     * Cercar per descripcio list.
     *
     * @param descripcioACercar the descripcio a cercar
     * @return the list
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    public List<Producte> cercarPerDescripcio(String descripcioACercar) throws IOException, InterruptedException {
        List<String> productes = f.retornaContingutFitxerLlista(fitxer);
        String descripcio;
        List<Producte> productesTrobades = new ArrayList<>();

        for (String fila : productes) {
            String[] dades = fila.split(";");
            descripcio = dades[2];
            if (descripcio.equalsIgnoreCase(descripcioACercar)) {
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
     * Cercar per data list.
     *
     * @param dataACercar the data a cercar
     * @return the list
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    public List<Producte> cercarPerData(String dataACercar) throws IOException, InterruptedException {
        List<String> productes = f.retornaContingutFitxerLlista(fitxer);
        String data;
        List<Producte> productesTrobades = new ArrayList<>();

        for (String fila : productes) {
            String[] dades = fila.split(";");
            data = dades[3];
            if (data.equalsIgnoreCase(dataACercar)) {
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
     * Retorna persones producte [ ].
     *
     * @return the producte [ ]
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     * @deprecated perquè tenim el mètode que retorna una llista de Productes
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
    //</editor-fold>

    //<editor-fold desc="descartado">
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
    //</editor-fold>

    /**
     * Retorna persones persona [ ].
     *
     * @return the persona [ ]
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
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

    /**
     * Elimina un producte del fitxer a partir del seu nom.
     *
     * @param nom nom de la persona a eliminar
     * @throws IOException          Excepció d'Entrada/Sortida
     * @throws InterruptedException the interrupted exception
     * @see #retornaProductes() #retornaProductes()
     */
    public void eliminaProducte(String nom) throws IOException, InterruptedException {
        Producte[] productes = retornaProductes();
        boolean afegir = false;
        boolean trobat=false;

        for (int i = 0; i < productes.length; i++) {
            // sobreescrivim el fitxer excloent la persona a eliminar
            if (!productes[i].getNom().equals(nom) || trobat) {
                f.escriuTextFitxer(fitxer, productes[i].toString(), afegir);
                afegir = true;
            }else{
                trobat=true;        // així sols eliminem una sola persona amb el cognom i no totes
            }
        }
    }

    /**
     * Modificar persona.
     *
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    public void modificarProducte() throws IOException, InterruptedException {
        Producte[] productes = retornaProductes();
        boolean afegir = false;
        boolean trobat = false;

        for (int i = 0; i < productes.length; i++) {
            // sobreescrivim el fitxer excloent la persona a modificar
            if (!productes[i].getNom().equals(this.nom) &&
                    !productes[i].getNom().equals(this.nom) || trobat) {
                f.escriuTextFitxer(fitxer, productes[i].toString(), afegir);
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
