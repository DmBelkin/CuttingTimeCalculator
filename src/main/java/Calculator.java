import java.time.LocalTime;

public class Calculator {

    private final String[] materials = new String[]{"Steel", "Aluminium alloys", "Hard steel", "Stainless steel",
            "Cuprum alloys", "Textolit", "Plastic", "Titan"};

    /**
     * "Steel", "Aluminium alloys", "Hard steel", "Stainless steel","Cuprum alloys" "Textolit", "Plastic", "Titan"
     * 0 = finish cutting (Vc, depth, moveSpeed)
     * 1 = clean cutting (Vc, depth, moveSpeed)
     * 2 = semi clean cutting (Vc, depth, moveSpeed)
     * 3 = hard cutting (Vc, depth, moveSpeed)
     * 4 = hardest cutting (Vc, depth, moveSpeed)
     */

    private final double[][][] Vc_turning = new double[][][]{
            {{430, 0.5, 0.12}, {2000, 3, 0.2}, {150, 0.2, 0.1}, {250, 0.4, 0.2}, {400, 0.5, 0.2}, {120, 1, 0.05}, {2000, 1, 0.2}, {65, 1, 0.2}},
            {{395, 0.4, 0.2}, {2000, 3, 0.2}, {150, 0.2, 0.1}, {250, 0.4, 0.2}, {400, 0.5, 0.2}, {120, 1, 0.05}, {2000, 1, 0.2}, {65, 1, 0.2}},
            {{325, 3, 0.3}, {1900, 3, 0.35}, {150, 0.2, 0.1}, {180, 3, 0.3}, {300, 3, 0.3}, {120, 2, 0.2}, {1500, 3, 0.3}, {53, 2, 0.3}},
            {{290, 4, 0.4}, {1900, 3, 0.35}, {100, 0.2, 0.15}, {165, 3, 0.35}, {300, 3, 0.3}, {100, 2, 0.2}, {1500, 5, 0.5}, {53, 2, 0.3}},
            {{260, 5, 0.5}, {1300, 3, 0.6}, {100, 0.2, 0.15}, {135, 5, 0.5}, {270, 5, 0.5}, {100, 4, 0.25}, {1000, 5, 0.5}, {49, 4, 0.4}}
    };

    private final double[][][] Vc_boring = new double[][][]{
            {{430, 0.5, 0.12}, {2000, 3, 0.2}, {150, 0.2, 0.1}, {250, 0.4, 0.2}, {400, 0.5, 0.2}, {120, 1, 0.05}, {2000, 1, 0.2}, {65, 1, 0.2}},
            {{395, 0.4, 0.2}, {2000, 3, 0.2}, {150, 0.2, 0.1}, {250, 0.4, 0.2}, {400, 0.5, 0.2}, {120, 1, 0.05}, {2000, 1, 0.2}, {65, 1, 0.2}},
            {{325, 3, 0.3}, {1900, 3, 0.35}, {150, 0.2, 0.1}, {180, 3, 0.3}, {300, 3, 0.3}, {120, 2, 0.2}, {1500, 3, 0.3}, {53, 2, 0.3}},
            {{290, 4, 0.4}, {1900, 3, 0.35}, {100, 0.2, 0.15}, {165, 3, 0.35}, {300, 3, 0.3}, {100, 2, 0.2}, {1500, 5, 0.5}, {53, 2, 0.3}},
            {{260, 5, 0.5}, {1300, 3, 0.6}, {100, 0.2, 0.15}, {135, 5, 0.5}, {270, 5, 0.5}, {100, 4, 0.25}, {1000, 5, 0.5}, {49, 4, 0.4}}
    };

    private final double[][][] Vc_segment = new double[][][]{};//-30% turning


    private final double[][][] Vc_threading = new double[][][]{
            {{115, 0.5, 0.12}, {1000, 3, 0.2}, {50, 0.2, 0.1}, {120, 0.4, 0.2}, {90, 0.5, 0.2}, {120, 1, 0.05}, {2000, 1, 0.2}, {100, 1, 0.2}},
            {{115, 0.4, 0.2}, {1000, 3, 0.2}, {50, 0.2, 0.1}, {120, 0.4, 0.2}, {90, 0.5, 0.2}, {120, 1, 0.05}, {2000, 1, 0.2}, {100, 1, 0.2}},
            {{90, 3, 0.3}, {1000, 3, 0.35}, {40, 0.2, 0.1}, {80, 3, 0.3}, {90, 3, 0.3}, {120, 2, 0.2}, {1500, 3, 0.3}, {100, 2, 0.3}},
            {{90, 4, 0.4}, {1000, 3, 0.35}, {40, 0.2, 0.15}, {80, 3, 0.35}, {90, 3, 0.3}, {100, 2, 0.2}, {1500, 5, 0.5}, {100, 2, 0.3}},
            {{70, 5, 0.5}, {1000, 3, 0.6}, {30, 0.2, 0.15}, {50, 5, 0.5}, {90, 5, 0.5}, {100, 4, 0.25}, {1000, 5, 0.5}, {100, 4, 0.4}}
    };

    private final int[] Vc_groove = new int[]{};//-30% turning

    private final int[] Vc_drilling = new int[]{};

    /**
     * "Steel", "Aluminium alloys", "Hard steel", "Stainless steel","Cuprum alloys" "Textolit", "Plastic", "Titan"
     * 0 = finish cutting (Vc, moveSpeed by one tooth, depth)
     * 1 = clean cutting (Vc, moveSpeed by one tooth, depth)
     * 2 = semi clean cutting (Vc, moveSpeed by one tooth, depth)
     * 3 = hard cutting (Vc, moveSpeed by one tooth, depth)
     * 4 = hardest cutting (Vc, moveSpeed by one tooth, depth)
     */

    private final double[][][] Vc_end_milling = new double[][][]{
            {{300, 0.1, 0.5}, {700, 0.1, 0.5}, {16, 0.07, 0.5}, {230, 0.1, 0.5}, {350, 0.1, 0.5}, {120, 1, 0.05}, {2000, 1, 0.2}, {100, 0.1, 0.5}},
            {{300, 0.1, 1}, {700, 0.2, 1}, {16, 0.07, 0.5}, {230, 0.1, 1}, {350, 0.1, 1}, {120, 1, 0.05}, {2000, 1, 0.2}, {100, 0.1, 1}},
            {{250, 0.2, 2}, {590, 0.2, 3}, {10, 0.1, 1}, {190, 0.2, 1.5}, {300, 0.2, 2}, {120, 2, 0.2}, {1500, 3, 0.3}, {95, 0.2, 1}},
            {{250, 0.2, 3}, {590, 0.2, 4}, {10, 0.1, 1}, {190, 0.2, 2}, {300, 0.2, 3}, {100, 2, 0.2}, {1500, 5, 0.5}, {95, 0.2, 1}},
            {{200, 0.3, 3}, {590, 0.2, 5}, {10, 0.1, 2}, {155, 0.3, 2.5}, {300, 0.2, 4}, {100, 4, 0.25}, {1000, 5, 0.5}, {95, 0.2, 2}}
    };

    private final int[] Vc_face_milling = new int[]{};

    private final int[] Vc_disk_milling = new int[]{};

    private WindowController controller;



    public void compute(Data data) {
        if (data.getCuttingType().equals("Turning")) {
            controller.outputWindow(computeTurning(data));
        } else if (data.getCuttingType().equals("Milling")) {
            controller.outputWindow(computeMilling(data));
        } else {
            controller.outputWindow(computeDrilling(data));
        }
    }


    public double computeTurning(Data data) {
        double Tpz = 0.5;
        double result = 0;
        int column = 0;
        for (int i = 0; i < materials.length; i++) {
            if (materials[i].equals(data.getMaterial())) {
                column = i;
                break;
            }
        }
        double depth = data.getDepth();
        if (data.getToolType().equals("Turning out") || data.getToolType().equals("Boring")) {
            while (depth > 5) {
                double Vc = Vc_turning[4][column][0];
                result += data.getLength() / Vc_turning[4][column][2] / spinCount(Vc, data.getDiameter()) + Tpz ;
                depth -= 5;
            }
            double changeTool = 1;
            result += changeTool;
            double Vc1 = Vc_turning[3][column][0];
            double Vc2 = Vc_turning[2][column][0];
            double Vc3 = Vc_turning[1][column][0];
            double Vc4 = Vc_turning[0][column][0];
            result += data.getLength() / Vc_turning[3][column][2] / spinCount(Vc1, data.getDiameter()) + Tpz;
            result += data.getLength() / Vc_turning[2][column][2] / spinCount(Vc2, data.getDiameter()) + Tpz;
            if (data.getQualitat() <= 10) {
                result += data.getLength() / Vc_turning[1][column][2] / spinCount(Vc3, data.getDiameter()) + Tpz;
            }
            if (data.getQualitat() <= 8) {
                result += data.getLength() / Vc_turning[0][column][2] / spinCount(Vc4, data.getDiameter()) + Tpz;
            }
        } else if (data.getToolType().equals("Groove")) {
            while (depth > 5) {
                double Vc = grooveFactor(Vc_turning[4][column][0]);
                result += result += data.getLength() /
                        grooveFactor(Vc_turning[4][column][2]) / spinCount(Vc, data.getDiameter());
                depth -= 5;
            }
            double Vc1 = grooveFactor(Vc_turning[3][column][0]);
            double Vc2 = grooveFactor(Vc_turning[2][column][0]);
            double Vc3 = grooveFactor(Vc_turning[1][column][0]);
            double Vc4 = grooveFactor(Vc_turning[0][column][0]);
            result += data.getLength() / grooveFactor(Vc_turning[3][column][2]) / spinCount(Vc1, data.getDiameter());
            result += data.getLength() / grooveFactor(Vc_turning[2][column][2]) / spinCount(Vc2, data.getDiameter());
            if (data.getQualitat() <= 10) {
                result += data.getLength() / grooveFactor(Vc_turning[1][column][2]) / spinCount(Vc3, data.getDiameter());
            }
            if (data.getQualitat() <= 8) {
                result += data.getLength() / grooveFactor(Vc_turning[0][column][2]) / spinCount(Vc4, data.getDiameter());
            }
        } else if (data.getToolType().equals("Segment")) {
            double Vc = grooveFactor(Vc_turning[1][column][0]);
            result += data.getDepth() / grooveFactor(Vc_turning[1][column][2] / spinCount(Vc, data.getDiameter()));
        } else if (data.getToolType().equals("Threading")) {
            double Vc = Vc_threading[3][column][0];
            result += data.getDepth()/ data.getThreadStep() / spinCount(Vc, data.getDiameter());
            double Vc1 = Vc_threading[2][column][0];
            result += data.getDepth()/ data.getThreadStep() / spinCount(Vc1, data.getDiameter());
            double Vc3 = Vc_threading[1][column][0];
            result += (data.getDepth()/ data.getThreadStep() / spinCount(Vc3, data.getDiameter())) * 6;
        }
        result += data.getChamfersCount();
        return result;
    }


    public double computeMilling(Data data) {
        return 0;
    }

    public double computeDrilling(Data data) {
        double D_ = 0;
        return 0;
    }

    public double grooveFactor(double number) {
        return number / 100 * 30;
    }

    public double spinCount(double Vc, double diameter) {
        return 1000 * Vc / Math.PI * diameter;
    }

    public void setController(WindowController controller) {
        this.controller = controller;
    }
}
