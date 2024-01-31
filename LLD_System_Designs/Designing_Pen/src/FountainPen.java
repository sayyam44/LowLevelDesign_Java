import strategies.writestrategies.SmoothWriteBehaviour;

public class FountainPen extends Pen{
    public FountainPen(PenType penType) {
        super(penType.FOUNTAIN, new SmoothWriteBehaviour());
    }

    @Override
    public void write() {

    }

    @Override
    public Colour getColor() {
        return null;
    }
}

