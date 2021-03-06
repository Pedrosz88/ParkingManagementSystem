package sample.model;

public class Masina {
    String numeClient;
    String nrInmat;
    String marca;
    String modelul;
    String culoarea;
    String dataParcare;
    String nrTelefon;

    public Masina(String numeClient, String nrInmat, String marca, String modelul, String culoarea, String dataParcare, String nrTelefon) {
        this.numeClient = numeClient;
        this.nrInmat = nrInmat;
        this.marca = marca;
        this.modelul = modelul;
        this.culoarea = culoarea;
        this.dataParcare = dataParcare;
        this.nrTelefon = nrTelefon;
    }

    public String getNumeClient() {
        return numeClient;
    }

    public String getNrInmat() {
        return nrInmat;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelul() {
        return modelul;
    }

    public String getCuloarea() {
        return culoarea;
    }

    public String getDataParcare() { return dataParcare; }

    public String getNrTelefon() {
        return nrTelefon;
    }

}