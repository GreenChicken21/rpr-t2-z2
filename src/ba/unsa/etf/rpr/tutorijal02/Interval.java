package ba.unsa.etf.rpr.tutorijal02;

public class Interval {

    private double pocetak;
    private double kraj;
    private boolean sadrziPocetak;
    private boolean sadrziKraj;

    public Interval(double v, double v1, boolean b, boolean b1) {
        if(v>v1) throw new IllegalArgumentException();
        this.pocetak = v;
        this.kraj = v1;
        this.sadrziPocetak = b;
        this.sadrziKraj = b1;
    }

    public Interval() {
        this.pocetak = 0;
        this.kraj = 0;
        this.sadrziPocetak = false;
        this.sadrziKraj = false;
    }

    public double getPocetak() {
        return pocetak;
    }

    public void setPocetak(double pocetak) {
        this.pocetak = pocetak;
    }

    public double getKraj() {
        return kraj;
    }

    public void setKraj(double kraj) {
        this.kraj = kraj;
    }

    public boolean getSadrziPocetak() {
        return sadrziPocetak;
    }

    public void setSadrziPocetak(boolean sadrziPocetak) {
        this.sadrziPocetak = sadrziPocetak;
    }

    public boolean getSadrziKraj() {
        return sadrziKraj;
    }

    public void setSadrziKraj(boolean sadrziKraj) {
        this.sadrziKraj = sadrziKraj;
    }


    public boolean isIn(double v) {
        if(pocetak < v && v < kraj)return true;
        else if((v == pocetak && sadrziPocetak)|| (v == kraj && sadrziKraj)) return true;
        return false;
    }

    public boolean isNull() {
        return (kraj == 0 && pocetak == 0 && !sadrziKraj && !sadrziPocetak);
    }


    public Interval intersect(Interval i) {
        Interval pov = new Interval();
        if(this.isIn(i.getPocetak())){
            pov.setPocetak(i.getPocetak());
            pov.setSadrziPocetak(i.getSadrziPocetak());
        }else{
            pov.setPocetak(this.getPocetak());
            pov.setSadrziPocetak(this.getSadrziPocetak());
        }

        if(this.isIn(i.getKraj())){
            pov.setKraj(i.getKraj());
            pov.setSadrziKraj(i.getSadrziKraj());
        }else{
            pov.setKraj(this.getKraj());
            pov.setSadrziKraj(this.getSadrziKraj());
        }

        return pov;
    }

    public static Interval intersect(Interval i, Interval i2){
        return null;
    }
}
