package bakery;

public class Doughnut extends Pastry{
    boolean hasHole;

    public Doughnut(boolean _isGlazed, float _price, String _flavor, int _weight, String _size, boolean _hasHole) {
        super(_isGlazed, _price, _flavor, _weight, _size);
        this.hasHole = _hasHole;
    }

    @Override
    public void eat() {
        System.out.println("MUNCH MUNCH MUNCH");
    }

    @Override
    public String toString() {
        String doughnut = "isGlazed: " + isGlazed() + "\nprice: " + getPrice() + "\nflavor: " + getFlavor();
        return doughnut;
    }
}
