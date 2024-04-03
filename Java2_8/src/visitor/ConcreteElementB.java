package visitor;

public class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor v) {
        v.visitElementB(this);
    }
}
