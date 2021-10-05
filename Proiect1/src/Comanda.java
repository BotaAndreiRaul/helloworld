public class Comanda {
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public int getCutmaterial() {
        return cutmaterial;
    }

    public void setCutmaterial(int cutmaterial) {
        this.cutmaterial = cutmaterial;
    }
    private int code;
    private int pieces;
    private int cutmaterial;
    public int[] cuts;
    public int checkCode(int code){
        int count = 0;
        while(code!=0){
            code /= 10;
            count++;
        }
        return count;
    }
    Comanda(int code,int pieces,int cutmaterial){
        this.code=code;
        this.pieces=pieces;
        this.cutmaterial=cutmaterial;
    }
    public int materialNeeded(int cutmaterial){
        if((this.pieces/cutmaterial)*cutmaterial<this.pieces)
            return this.pieces/cutmaterial+1;
        else
            return this.pieces/cutmaterial;
    }
    public int remainingPieces(){
        if(materialNeeded(cutmaterial)*this.cutmaterial>this.pieces)
            return materialNeeded(cutmaterial)*this.cutmaterial-this.pieces;
        return materialNeeded(cutmaterial)*this.cutmaterial-this.pieces;
    }
    public String toString(){
        return "Codul este " + this.code + " si sunt nevoie de " + this.pieces + " bucati si materia prima trebuie taiata in "
                + this.cutmaterial + " bucati";
    }
}
