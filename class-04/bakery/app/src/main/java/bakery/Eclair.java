package bakery;

public class Eclair extends Doughnut{
    boolean isFilled;
    public Eclair(boolean _isGlazed, float _price, String _flavor, int _weight, String _size, boolean _hasHole, boolean _isFilled) {
        super(_isGlazed, _price, _flavor, _weight, _size, _hasHole);
        this.isFilled = _isFilled;
    }
}
