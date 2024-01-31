public interface RefilPen {
    //Why didn't we make it an abstract class and made it an interface ?
    //ANS -In Bird class why did not we have a flyingbird and eatingbird methods

    //here we have a noun name as interface RefilPen , if that particular entity doesn't have any attributes

    Refil getRefil(); //this method is for getting the refil for a particular pen
    boolean canChangeRefil(); //this method tells whether a pen is refilable or not
    void changeRefil(Refil newRefil); //this method is for again refiling a refilable pen
}
