public class Data {

    private String cuttingType;

    private String toolType;

    private double diameter;

    private double length;

    private String material;

    private double square;

    private double depth;



    public Data(){}


    public Data(String cuttingType, String toolType,
                double diameter, double length,
                String material, double square,
                double depth) {
        this.cuttingType = cuttingType;
        this.toolType = toolType;
        this.diameter = diameter;
        this.length = length;
        this.material = material;
        this.square = square;
        this.depth = depth;
    }

    public void reset() {
        this.cuttingType = "";
        this.toolType = "";
        this.diameter = 0;
        this.length = 0;
        this.material = "";
        this.square = 0;
        this.depth = 0;
    }

    public String getCuttingType() {
        return cuttingType;
    }

    public void setCuttingType(String cuttingType) {
        this.cuttingType = cuttingType;
    }

    public String getToolType() {
        return toolType;
    }

    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }
}
