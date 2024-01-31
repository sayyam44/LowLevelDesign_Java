import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Pen> pens =new ArrayList<>();
        for (Pen pen:pens){
            if (pen.getType().equals(PenType.BALL)){

            }
        }
        GelPen gelPen = PenFactory
                .createGelPen()
                .setCanChangeRefil(true)
                .setRefil(new Refil())
                .build();
    }
}
//Here we could create directly an instance of any pen and begin to define that pen normally
//like this
//PenFactory.createGelPen();
//          .with Refil();
//          .with Refilable(True/False)
//          .build()

//TARGET IS TO BUILD LIKE THIS
//PenFactory.createGelPen() // so here we need a penFactory class with methods as createGelPen() or createBallPen() or createMarker() or createFountainPen() that is why we needed factory design
//but these 3 remaining functions will be attached to a particular class that is either gelpen or ball pen or fountainpen or marker that is why we needed builder within that particular class
//           .setCanChangeRefil(true)
//           .setRefil(new Refil())
//           .build();

//So for this we atleast need PenFactory class
