package sample.model;

public class Tarif {
    int oZi;
    int intreDouaSiSapteZile;
    int pesteSapteZile;

    public Tarif(int oZi,int intreDouaSiSapteZile,int pesteSapteZile){
        this.oZi=oZi;
        this.intreDouaSiSapteZile=intreDouaSiSapteZile;
        this.pesteSapteZile=pesteSapteZile;
    }

    public int getOZi(){
        return oZi;
    }
    public int getIntreDouaSiSapteZile(){
        return intreDouaSiSapteZile;
    }
    public int getPesteSapteZile(){
        return pesteSapteZile;
    }
}
