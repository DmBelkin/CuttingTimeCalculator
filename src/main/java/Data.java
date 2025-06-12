public class Data {

    private String cuttingType;

    private String toolType;

    private double diameter;

    private double length;

    private String material;

    private double square;

    private double depth;

    private double chamfersCount;

    private double threadStep;

    private double segmentGrooveWidth;

    private double bladeWidth;

    private double qualitat;

    private double Zcount;

    private double millDiameter;

    private boolean isHSS;

    private boolean isCPU;

    private double millWidth;

    private double millLength;

    public void reset() {
        this.cuttingType = "";
        this.toolType = "";
        this.diameter = 0;
        this.length = 0;
        this.material = "";
        this.square = 0;
        this.depth = 0;
        this.chamfersCount = 0;
        this.threadStep = 0;
        this.Zcount = 0;
        this.qualitat = 0;
        this.millWidth = 0;
        this.millDiameter = 0;
        this.segmentGrooveWidth = 0;
    }

    public double getMillLength() {
        return millLength;
    }

    public void setMillLength(double millLength) {
        this.millLength = millLength;
    }

    public boolean isHSS() {
        return isHSS;
    }

    public void setHSS(boolean HSS) {
        isHSS = HSS;
    }

    public boolean isCPU() {
        return isCPU;
    }

    public void setCPU(boolean CPU) {
        isCPU = CPU;
    }

    public double getMillDiameter() {
        return millDiameter;
    }

    public void setMillDiameter(double millDiameter) {
        this.millDiameter = millDiameter;
    }

    public double getMillWidth() {
        return millWidth;
    }

    public void setMillWidth(double millWidth) {
        this.millWidth = millWidth;
    }
    public double getBladeWidth() {
        return bladeWidth;
    }

    public void setBladeWidth(double bladeWidth) {
        this.bladeWidth = bladeWidth;
    }

    public double getThreadStep() {
        return threadStep;
    }

    public void setThreadStep(double threadStep) {
        this.threadStep = threadStep;
    }

    public double getSegmentGrooveWidth() {
        return segmentGrooveWidth;
    }

    public double getZcount() {
        return Zcount;
    }

    public void setZcount(double zcount) {
        Zcount = zcount;
    }

    public void setSegmentGrooveWidth(double segmentGrooveWidth) {
        this.segmentGrooveWidth = segmentGrooveWidth;
    }

    public String getCuttingType() {
        return cuttingType;
    }

    public void setCuttingType(String cuttingType) {
        this.cuttingType = cuttingType;
    }

    public double getQualitat() {
        return qualitat;
    }

    public void setQualitat(double qualitat) {
        this.qualitat = qualitat;
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

    public double getChamfersCount() {
        return chamfersCount;
    }

    public void setChamfersCount(double chamfersCount) {
        this.chamfersCount = chamfersCount;
    }

    @Override
    public String toString() {
        return "Data{" +
                "cuttingType='" + cuttingType + '\'' +
                ", toolType='" + toolType + '\'' +
                ", diameter=" + diameter +
                ", length=" + length +
                ", material='" + material + '\'' +
                ", square=" + square +
                ", depth=" + depth +
                ", chamfersCount=" + chamfersCount +
                ", threadStep=" + threadStep +
                ", segmentGrooveWidth=" + segmentGrooveWidth +
                ", bladeWidth=" + bladeWidth +
                ", qualitat=" + qualitat +
                ", Z-count=" + Zcount +
                ", isHSS=" + isHSS +
                ", isCPU=" + isCPU +
                ", millDiameter=" + millDiameter +
                ", millWidth=" + millWidth +
                '}';
    }


}
