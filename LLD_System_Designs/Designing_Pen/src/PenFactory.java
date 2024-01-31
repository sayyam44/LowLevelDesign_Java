//TARGET IS TO BUILD LIKE THIS
//PenFactory.createGelPen()
//          .setRefil(x)
//          .setRefilable(false);

//So for this we atleast need PenFactory class

//Since factory is always a seperate class
public class PenFactory {

    //here in the cretegelpen method we are not returning a gelpen instead we are returning a Builder of gelpen
    public static GelPen.Builder createGelPen() {
        return new GelPen.Builder();
    }

    public static BallPen createPen() {
        return null;
    }
}