public class Timp {
    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getPieces_a_day() {
        return pieces_a_day;
    }

    public void setPieces_a_day(int pieces_a_day) {
        this.pieces_a_day = pieces_a_day;
    }

    Timp(int days,int pieces_a_day) {
        this.days = days;
        this.pieces_a_day = pieces_a_day;
    }
    public String toString(){
        return "Comanda trebuie finalizata in " + this.days + " zile";
    }

    private int days;
    private int pieces_a_day;
    public Boolean checkTime(int pieces){
        if(this.days*this.pieces_a_day < pieces)
            return false;
        else
            return  true;
    }
}
