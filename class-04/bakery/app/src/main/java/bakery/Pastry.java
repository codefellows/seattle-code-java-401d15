package bakery;

 public class Pastry {
    private boolean isGlazed;
    private float price;
    private String flavor;
    private int weight;
    private String size;

    public Pastry(boolean _isGlazed, float _price, String _flavor, int _weight, String _size){
        this.isGlazed = _isGlazed;
        this.price = _price;
        this.flavor = _flavor;
        this.weight = _weight;
        this.size = _size;
    }
    // METHOD OVERLOADING/CONTSRUCTOR OVERLOADING
     public Pastry(float price, String flavor) {
         this.price = price;
         this.flavor = flavor;
     }

     public void prompt(){
        System.out.println("Price needs to be > 0");
    }

    public void eat(){
        System.out.println("NOM NOM NOM");
    }

     public boolean isGlazed() {
         return isGlazed;
     }

     public void setGlazed(boolean glazed) {
         isGlazed = glazed;
     }

     public float getPrice() {
         return price;
     }

     public void setPrice(float price) {
         this.price = price;
     }

     public String getFlavor() {
         return flavor;
     }

     public void setFlavor(String flavor) {
         this.flavor = flavor;
     }

     public int getWeight() {
         return weight;
     }

     public void setWeight(int weight) {
         this.weight = weight;
     }

     public String getSize() {
         return size;
     }

     public void setSize(String size) {
         this.size = size;
     }


 }
