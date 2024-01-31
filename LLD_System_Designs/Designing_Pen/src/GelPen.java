import strategies.writestrategies.SmoothWriteBehaviour;
import strategies.writestrategies.WriteBehaviour;

public class GelPen extends Pen implements RefilPen{
    private Refil refil;
    private boolean canChangeRefil=false;
    private GelPen(WriteBehaviour writeBehaviour) { //we can only create gelpen via builder that is why we have made this constructor as private
        super(PenType.GEL, writeBehaviour);
    }
    //TARGET IS TO BUILD LIKE THIS
//PenFactory.createGelPen()
//          .setRefil(x)
//          .setRefilable(false);
    //here .createGelPen() returns a gel pen so setRefil() will be called on gel pen and if gel pen is not mutable
    //then that is why we have to create builder class for a gel pen and same for other pens too
    public static class Builder{
        private Refil refil;
        private boolean canChangeRefil=false;

        //builer methods returns the instance of itself type here Builder
        public Builder setRefil(Refil refil){
            this.refil=refil;
            return this;
        }
        public Builder setCanChangeRefil(boolean value){
            this.canChangeRefil=value;
            return this;
        }
        public GelPen build(){
            GelPen gelPen = new GelPen(new SmoothWriteBehaviour());
            gelPen.refil= this.refil;
            gelPen.canChangeRefil = this.canChangeRefil;
            return gelPen;
        }
    }
    @Override
    public void write() {

    }

    @Override
    public Colour getColor() {
        return null;
    }

    @Override
    public Refil getRefil() {
        return this.refil;
    }

    @Override
    public boolean canChangeRefil() {
        return this.canChangeRefil;
    }

    @Override
    public void changeRefil(Refil newRefil) {

    }
}
