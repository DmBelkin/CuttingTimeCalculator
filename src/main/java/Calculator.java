import java.time.LocalTime;

public class Calculator {

    /**
     * "Steel", "Aluminium alloys", "Hard steel", "Stainless steel","Cuprum alloys" "Textolit", "Plastic", "Titan"
     * 0 = finish cutting (Vc, depth, moveSpeed)
     * 1 = clean cutting (Vc, depth, moveSpeed)
     * 2 = semi clean cutting (Vc, depth, moveSpeed)
     * 3 = hard cutting (Vc, depth, moveSpeed)
     * 4 = hardest cutting (Vc, depth, moveSpeed)
     */

    double[][][] Vc_turning = new double[][][] {
            {{430, 0.5, 0.12}, {2000, 3, 0.2}, {150, 0.2, 0.1}, {250, 0.4, 0.2}, {400, 0.5, 0.2}, {120, 1, 0.05}, {2000, 1, 0.2}, {65, 1, 0.2}},
            {{395, 0.4, 0.2}, {2000, 3, 0.2}, {150, 0.2, 0.1}, {250, 0.4, 0.2}, {400, 0.5, 0.2}, {120, 1, 0.05}, {2000, 1, 0.2}, {65, 1, 0.2}},
            {{325, 3, 0.3}, {1900, 3, 0.35}, {150, 0.2, 0.1}, {180, 3, 0.3}, {300, 3, 0.3}, {120, 2, 0.2}, {1500, 3, 0.3}, {53, 2, 0.3}},
            {{290, 4, 0.4}, {1900, 3, 0.35}, {100, 0.2, 0.15}, {165, 3, 0.35}, {300, 3, 0.3}, {100, 2, 0.2}, {1500, 5, 0.5}, {53, 2, 0.3}},
            {{260, 5, 0.5}, {1300, 3, 0.6}, {100, 0.2, 0.15}, {135, 5, 0.5}, {270, 5, 0.5}, {100, 4, 0.25}, {1000, 5, 0.5}, {49, 4, 0.4}}
    };

    double[][][] Vc_boring = new double[][][] {
            {{430, 0.5, 0.12}, {2000, 3, 0.2}, {150, 0.2, 0.1}, {250, 0.4, 0.2}, {400, 0.5, 0.2}, {120, 1, 0.05}, {2000, 1, 0.2}, {65, 1, 0.2}},
            {{395, 0.4, 0.2}, {2000, 3, 0.2}, {150, 0.2, 0.1}, {250, 0.4, 0.2}, {400, 0.5, 0.2}, {120, 1, 0.05}, {2000, 1, 0.2}, {65, 1, 0.2}},
            {{325, 3, 0.3}, {1900, 3, 0.35}, {150, 0.2, 0.1}, {180, 3, 0.3}, {300, 3, 0.3}, {120, 2, 0.2}, {1500, 3, 0.3}, {53, 2, 0.3}},
            {{290, 4, 0.4}, {1900, 3, 0.35}, {100, 0.2, 0.15}, {165, 3, 0.35}, {300, 3, 0.3}, {100, 2, 0.2}, {1500, 5, 0.5}, {53, 2, 0.3}},
            {{260, 5, 0.5}, {1300, 3, 0.6}, {100, 0.2, 0.15}, {135, 5, 0.5}, {270, 5, 0.5}, {100, 4, 0.25}, {1000, 5, 0.5}, {49, 4, 0.4}}
    };

    double[][][] Vc_segment = new double[][][]{};//-30% turning

    double[][][] Vc_threading = new double[][][]{
            {{430, 0.5, 0.12}, {2000, 3, 0.2}, {150, 0.2, 0.1}, {250, 0.4, 0.2}, {400, 0.5, 0.2}, {120, 1, 0.05}, {2000, 1, 0.2}, {65, 1, 0.2}},
            {{395, 0.4, 0.2}, {2000, 3, 0.2}, {150, 0.2, 0.1}, {250, 0.4, 0.2}, {400, 0.5, 0.2}, {120, 1, 0.05}, {2000, 1, 0.2}, {65, 1, 0.2}},
            {{325, 3, 0.3}, {1900, 3, 0.35}, {150, 0.2, 0.1}, {180, 3, 0.3}, {300, 3, 0.3}, {120, 2, 0.2}, {1500, 3, 0.3}, {53, 2, 0.3}},
            {{290, 4, 0.4}, {1900, 3, 0.35}, {100, 0.2, 0.15}, {165, 3, 0.35}, {300, 3, 0.3}, {100, 2, 0.2}, {1500, 5, 0.5}, {53, 2, 0.3}},
            {{260, 5, 0.5}, {1300, 3, 0.6}, {100, 0.2, 0.15}, {135, 5, 0.5}, {270, 5, 0.5}, {100, 4, 0.25}, {1000, 5, 0.5}, {49, 4, 0.4}}
    };

    int[] Vc_groove = new int[]{};//-30% turning

    int[] Vc_drilling = new int[]{};

    int[] Vc_end_milling = new int[]{};

    int[] Vc_face_milling = new int[]{};

    int[] Vc_disk_milling = new int[]{};



    public LocalTime compute (Data data) {
        if (data.getCuttingType().equals("Turning")) {
            return computeTurning(data);
        } else if (data.getCuttingType().equals("Milling")) {
            return computeMilling(data);
        }
        return computeDrilling(data);
    }


    public LocalTime computeTurning(Data data) {
        return null;
    }

    public LocalTime computeMilling(Data data) {
        return null;
    }

    public LocalTime computeDrilling(Data data) {
        double D_ = 0;
        return null;
    }

    public double grooveCoefficient(double number) {
        return number / 100 * 30;
    }

}
