package sample.model;

public class Tarif {
    int oZi;
    int intre2si7zile;
    int peste7zile;

    public Tarif(int oZi,int intre2si7zile,int peste7zile){
        this.oZi=oZi;
        this.intre2si7zile=intre2si7zile;
        this.peste7zile=peste7zile;
    }

    public int getOZi(){
        return oZi;
    }
    public int getIntre2si7zile(){
        return intre2si7zile;
    }
    public int getPeste7zile(){
        return peste7zile;
    }
}
