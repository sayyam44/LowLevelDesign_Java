import strategies.writestrategies.SmoothWriteBehaviour;

public class BallPen extends Pen implements RefilPen{

    public BallPen(PenType penType) {
        super(penType.BALL, new SmoothWriteBehaviour());
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
