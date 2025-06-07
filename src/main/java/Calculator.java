

public class Calculator {


    private final String[] materials = new String[]{"Steel", "Aluminium alloys", "Hard steel", "Stainless steel",
            "Cuprum alloys", "Textolit", "Plastic", "Titan"};

    /**
     * turning
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
            {{260, 5, 0.5}, {1300, 3, 0.6}, {100, 0.2, 0.15}, {135, 4, 0.5}, {270, 5, 0.5}, {100, 4, 0.25}, {1000, 5, 0.5}, {49, 4, 0.4}}
    };

    private final double[][][] Vc_threading = new double[][][]{
            {{115, 0.5, 0.12}, {1000, 3, 0.2}, {50, 0.2, 0.1}, {120, 0.4, 0.2}, {90, 0.5, 0.2}, {120, 1, 0.05}, {2000, 1, 0.2}, {100, 1, 0.2}},
            {{115, 0.4, 0.2}, {1000, 3, 0.2}, {50, 0.2, 0.1}, {120, 0.4, 0.2}, {90, 0.5, 0.2}, {120, 1, 0.05}, {2000, 1, 0.2}, {100, 1, 0.2}},
            {{90, 3, 0.3}, {1000, 3, 0.35}, {40, 0.2, 0.1}, {80, 3, 0.3}, {90, 3, 0.3}, {120, 2, 0.2}, {1500, 3, 0.3}, {100, 2, 0.3}},
            {{90, 4, 0.4}, {1000, 3, 0.35}, {40, 0.2, 0.15}, {80, 3, 0.35}, {90, 3, 0.3}, {100, 2, 0.2}, {1500, 5, 0.5}, {100, 2, 0.3}},
            {{70, 5, 0.5}, {1000, 3, 0.6}, {30, 0.2, 0.15}, {50, 5, 0.5}, {90, 5, 0.5}, {100, 4, 0.25}, {1000, 5, 0.5}, {100, 4, 0.4}}
    };

    /**
     * drilling
     * "Steel", "Aluminium alloys", "Hard steel", "Stainless steel","Cuprum alloys" "Textolit", "Plastic", "Titan"
     * 0 = diameters 1 - 26 (Vc, moveSpeed)
     * 1 = diameters 26 - 33 (Vc, moveSpeed)
     * 2 = diameters 33 - 43 (Vc, moveSpeed)
     * 3 = diameters 43 - 58 (Vc, moveSpeed)
     */


    private final double[][][] Vc_drilling = new double[][][]{
            {{160, 0.06}, {300, 0.12}, {100, 0.08}, {120, 0.1}, {200, 0.14}, {120, 0.1}, {300, 0.12}, {80, 0.06}},
            {{160, 0.08}, {300, 0.16}, {100, 0.12}, {120, 0.16}, {200, 0.16}, {120, 0.16}, {300, 0.16}, {80, 0.08}},
            {{160, 0.1}, {300, 0.2}, {100, 0.16}, {120, 0.19}, {200, 0.2}, {120, 0.19}, {300, 0.2}, {80, 0.1}},
            {{160, 0.2}, {300, 0.25}, {100, 0.18}, {120, 0.22}, {200, 0.25}, {100, 0.22}, {300, 0.25}, {80, 0.12}},
    };

    /**
     * milling
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


    private WindowController controller;


    public void compute(Data data) {
        if (data.getCuttingType().equals("Turning")) {
            controller.outputWindow(String.format("%.2f", computeTurning(data)));
        } else if (data.getCuttingType().equals("Milling")) {
            controller.outputWindow(String.format("%.2f", computeMilling(data)));
        } else {
            controller.outputWindow(String.format("%.2f", computeDrilling(data)));
        }
    }


    public double computeTurning(Data data) {
        double Tpz = 0.5;
        double result = 0;
        int column = getMaterial(data.getMaterial());
        double depth = data.getDepth();
        if (data.getToolType().equals("Turning out") || data.getToolType().equals("Boring")) {
            while (depth > Vc_turning[4][column][1]) {
                double Vc = Vc_turning[4][column][0];
                result += calculateTime(data.getLength(), Vc_turning[4][column][2],
                        spinCount(Vc, data.getDiameter())) + Tpz;
                depth -= Vc_turning[4][column][1];
            }
            double changeTool = 0.5;
            result += changeTool;
            double Vc1 = Vc_turning[3][column][0];
            double Vc2 = Vc_turning[2][column][0];
            double Vc3 = Vc_turning[1][column][0];
            double Vc4 = Vc_turning[0][column][0];
            result += calculateTime(data.getLength(), Vc_turning[3][column][2],
                    spinCount(Vc1, data.getDiameter())) + Tpz;
            result += calculateTime(data.getLength(), Vc_turning[2][column][2],
                    spinCount(Vc2, data.getDiameter())) + Tpz;
            if (data.getQualitat() <= 10) {
                result += calculateTime(data.getLength(), Vc_turning[1][column][2],
                        spinCount(Vc3, data.getDiameter())) + Tpz;
            }
            if (data.getQualitat() <= 8) {
                result += calculateTime(data.getLength(), Vc_turning[0][column][2],
                        spinCount(Vc4, data.getDiameter())) + Tpz;
            }
        } else if (data.getToolType().equals("Groove")) {
            while (depth > Vc_turning[4][column][1]) {
                double Vc = grooveFactor(Vc_turning[4][column][0]);
                result += calculateTime(data.getLength(), grooveFactor(Vc_turning[4][column][2]),
                        spinCount(Vc, data.getDiameter())) + Tpz;
                depth -= Vc_turning[4][column][1];
            }
            double changeTool = 0.5;
            result += changeTool;
            double Vc1 = grooveFactor(Vc_turning[3][column][0]);
            double Vc2 = grooveFactor(Vc_turning[2][column][0]);
            double Vc3 = grooveFactor(Vc_turning[1][column][0]);
            double Vc4 = grooveFactor(Vc_turning[0][column][0]);
            result += calculateTime(data.getLength(), grooveFactor(Vc_turning[3][column][2]),
                    spinCount(Vc1, data.getDiameter())) + Tpz;
            result += calculateTime(data.getLength(), grooveFactor(Vc_turning[3][column][2]),
                    spinCount(Vc2, data.getDiameter())) + Tpz;
            if (data.getQualitat() <= 10) {
                result += calculateTime(data.getLength(), grooveFactor(Vc_turning[1][column][2]),
                        spinCount(Vc3, data.getDiameter())) + Tpz;
            }
            if (data.getQualitat() <= 8) {
                result += calculateTime(data.getLength(), grooveFactor(Vc_turning[4][column][2]),
                        spinCount(Vc4, data.getDiameter())) + Tpz;
            }
        } else if (data.getToolType().equals("Segment")) {
            double Vc = grooveFactor(Vc_turning[3][column][0]);
            result += calculateTime(data.getDepth(), grooveFactor(Vc_turning[2][column][2]),
                    spinCount(Vc, data.getDiameter())) + Tpz;
        } else if (data.getToolType().equals("Threading")) {
            double Vc = Vc_threading[4][column][0];
            result += calculateTime(data.getLength(), data.getThreadStep(), spinCount(Vc, data.getDiameter())) + Tpz;
            double Vc1 = Vc_threading[2][column][0];
            result += calculateTime(data.getLength(), data.getThreadStep(), spinCount(Vc1, data.getDiameter())) + Tpz;
            double Vc3 = Vc_threading[1][column][0];
            result += calculateTime(data.getLength(), data.getThreadStep(), spinCount(Vc3, data.getDiameter())) * 8 + Tpz;
        }
        result += data.getChamfersCount();
        if (!data.isCPU()) {
            result *= 2;
        }
        return result;
    }


    public double computeMilling(Data data) {
        if (data.getToolType().equals("Disk milling")) {
            return computeDiscMilling(data);
        }
        double Tpz = 0.5;
        int column = getMaterial(data.getMaterial());
        double result = 0;
        double changeTool = 1;
        double V = data.getSquare() * data.getDepth();
        double spin1 = spinCount(Vc_end_milling[4][column][0], data.getMillDiameter());
        double spin2 = spinCount(Vc_end_milling[3][column][0], data.getMillDiameter());
        double spin3 = spinCount(Vc_end_milling[2][column][0], data.getMillDiameter());
        double spin4 = spinCount(Vc_end_milling[1][column][0], data.getMillDiameter());
        double spin5 = spinCount(Vc_end_milling[0][column][0], data.getMillDiameter());
        double oneRowV = (double) (data.getMillDiameter() / 4) * Vc_end_milling[4][column][2] * data.getDepth();
        double oneRowTime = calculateTime(data.getDepth(), data.getZcount() * Vc_end_milling[4][column][1],
                spin1) + Tpz;
        double preMilling = (((V / 100) * 90) / oneRowV) * oneRowTime;
        double oneRowV1 = (double) (data.getMillDiameter() / 6) * Vc_end_milling[2][column][2] * data.getDepth();
        double oneRowTime1 = calculateTime(data.getDepth(), data.getZcount() * Vc_end_milling[2][column][1],
                spin3) + Tpz;
        double cleanMilling = (((V / 100) * 10) / oneRowV1) * oneRowTime1;
        double oneRowV2 = (double) (data.getMillDiameter() / 8) * Vc_end_milling[1][column][2] * data.getDepth();
        double oneRowTime2 = calculateTime(data.getDepth(), data.getZcount() * Vc_end_milling[1][column][1],
                spin4) + Tpz;
        double preFinishMilling = (((V / 100) * 5) / oneRowV1) * oneRowTime1;
        double finisMilling = (((V / 100) * 5) / oneRowV2) * oneRowTime2;
        if (data.getQualitat() >= 14) {
            result += preMilling;
        } else if (data.getQualitat() < 14 && data.getQualitat() >= 10) {
            result += preMilling;
            result += changeTool;
            result += cleanMilling;
        } else if (data.getQualitat() < 10) {
            result += preMilling;
            result += preFinishMilling;
            result += changeTool;
            result += finisMilling;
        }
        if (!data.isCPU()) {
            result *= 2;
        }
        return result;
    }

    public double computeDiscMilling(Data data) {
        double Tpz = 0.5;
        int column = getMaterial(data.getMaterial());
        double result = 0;
        double V = data.getDepth() * data.getBladeWidth() * data.getLength();
        double spin1 = spinCount(Vc_end_milling[4][column][0], data.getMillDiameter());
        double spin2 = spinCount(Vc_end_milling[3][column][0], data.getMillDiameter());
        double spin3 = spinCount(Vc_end_milling[2][column][0], data.getMillDiameter());
        double spin4 = spinCount(Vc_end_milling[1][column][0], data.getMillDiameter());
        double spin5 = spinCount(Vc_end_milling[0][column][0], data.getMillDiameter());
        double oneRowV = data.getMillWidth() * Vc_end_milling[4][column][2] * data.getLength();
        double oneRowTime = calculateTime(data.getLength(), data.getZcount() * Vc_end_milling[4][column][1],
                spin1) + Tpz;
        double preMilling = (((V / 100) * 90) / oneRowV) * oneRowTime;
        double oneRowV1 = data.getMillWidth() * Vc_end_milling[2][column][2] * data.getLength();
        double oneRowTime1 = calculateTime(data.getLength(), data.getZcount() * Vc_end_milling[2][column][1],
                spin3) + Tpz;
        double cleanMilling = (((V / 100) * 10) / oneRowV1) * oneRowTime1;
        double oneRowV2 = data.getMillWidth() * Vc_end_milling[1][column][2] * data.getLength();
        double oneRowTime2 = calculateTime(data.getLength(), data.getZcount() * Vc_end_milling[1][column][1],
                spin4) + Tpz;
        double preFinishMilling = (((V / 100) * 5) / oneRowV1) * oneRowTime1;
        double finisMilling = (((V / 100) * 5) / oneRowV2) * oneRowTime2;
        result += preMilling;
        result += cleanMilling;
        if (!data.isCPU()) {
            result *= 2;
        }
        return result;
    }

    public double computeDrilling(Data data) {
        double Tpz = 0.5;
        int column = getMaterial(data.getMaterial());
        double depth = data.getDepth();
        double[] params = null;
        if (data.getDiameter() <= 26) {
            params = Vc_drilling[0][column];
        } else if (data.getDiameter() > 26 && data.getDiameter() <= 33) {
            params = Vc_drilling[1][column];
        } else if (data.getDiameter() > 33 && data.getDiameter() <= 43) {
            params = Vc_drilling[2][column];
        } else if (data.getDiameter() > 43) {
            params = Vc_drilling[3][column];
        }
        double Vc = params[0];
        if (data.isHSS()) {
            Vc /= 4;
        }
        double spin = spinCount(Vc, data.getDiameter());
        return calculateTime(depth, params[1], spin) + Tpz;
    }

    public int getMaterial(String material) {
        int column = 0;
        for (int i = 0; i < materials.length; i++) {
            if (materials[i].equals(material)) {
                column = i;
                break;
            }
        }
        return column;
    }

    public double calculateTime(double length, double x, double spinCount) {
        return (length / x) / spinCount;
    }

    public double grooveFactor(double number) {
        return number - (number / 100) * 25;
    }

    public double spinCount(double Vc, double diameter) {
        return (1000 * Vc) / (Math.PI * diameter);
    }

    public void setController(WindowController controller) {
        this.controller = controller;
    }
}
