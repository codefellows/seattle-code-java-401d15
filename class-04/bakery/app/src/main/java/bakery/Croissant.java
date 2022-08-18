package bakery;

public class Croissant extends Pastry{
    boolean hasLayers;
    public Croissant(boolean _isGlazed, float _price, String _flavor, int _weight, String _size, boolean _hasLayers) {
        super(_isGlazed, _price, _flavor, _weight, _size);
        this.hasLayers = _hasLayers;
    }
}
