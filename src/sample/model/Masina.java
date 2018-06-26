package sample.model;

public class Masina {
    String numeClient;
    String nrInmat;
    String marca;
    String model;
    String culoare;
    String dataParcare;
    String nrTelefon;

    public Masina(String numeClient, String nrInmat, String marca, String model, String culoare, String dataParcare, String nrTelefon) {
        this.numeClient = numeClient;
        this.nrInmat = nrInmat;
        this.marca = marca;
        this.model=model;
        this.culoare = culoare;
        this.dataParcare = dataParcare;
        this.nrTelefon = nrTelefon;
    }
}