import strategies.writestrategies.SmoothWriteBehaviour;

public class Marker extends Pen implements RefilPen{
    public Marker(PenType penType) {
        super(penType.MARKER, new SmoothWriteBehaviour());
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
        return null;
    }

    @Override
    public boolean canChangeRefil() {
        return false;
    }

    @Override
    public void changeRefil(Refil newRefil) {

    }
}
