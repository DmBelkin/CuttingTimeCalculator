public class CommandWorker {

    private Calculator calculator;

    private WindowController controller;

    private Data data;

    public CommandWorker(WindowController controller, Data data) {
        this.controller = controller;
        this.data = data;
        calculator = new Calculator();
        calculator.setController(controller);
    }

    public void getAction(String text) {
        if (text.isBlank()) {
            return;
        }
        if (text.equals("Turning")) {
            data.setCuttingType(text);
            controller.turningWindow();
        } else if (text.equals("Milling")) {
            data.setCuttingType(text);
            controller.millingWindow();
        } else if (text.equals("Drilling")) {
            data.setCuttingType(text);
            controller.drillingWindow();
        } else if (text.equals("Back")) {
            controller.backFunction(controller.getLast());
        } else if (text.equals("Turning out")) {
            data.setToolType(text);
            controller.materialsMatrixPanel();
        } else if (text.equals("Boring")) {
            data.setToolType(text);
            controller.materialsMatrixPanel();
        } else if (text.equals("Groove")) {
            data.setToolType(text);
            controller.materialsMatrixPanel();
        } else if (text.equals("Segment")) {
            data.setToolType(text);
            controller.materialsMatrixPanel();
        } else if (text.equals("Volume")) {
            data.setToolType(text);
            controller.materialsMatrixPanel();
        } else if (text.equals("End milling")) {
            data.setToolType(text);
            controller.materialsMatrixPanel();
        } else if (text.equals("Circuit")) {
            data.setToolType(text);
            controller.materialsMatrixPanel();
        } else if (text.equals("Threading")) {
            data.setToolType(text);
            controller.materialsMatrixPanel();
        } else if (text.equals("Disk milling")) {
            data.setToolType(text);
            controller.materialsMatrixPanel();
        } else if (text.equals("Submit")) {
            String p1 = controller.getDrillingFields()[0].getText();
            String p2 = controller.getDrillingFields()[1].getText();
            data.setToolType("Drilling");
            if (validNumbers(p1) && validNumbers(p2)) {
                data.setDiameter(Double.parseDouble(p1));
                data.setDepth(Double.parseDouble(p2));
                if (!validDTO(data)) {
                    controller.getOutput().setText("this not may be <= 0");
                } else {
                    controller.materialsMatrixPanel();
                }
            } else {
                controller.getOutput().setText("Incorrect input");
            }
        } else if (text.equals("Go")) {
            if (data.getToolType().equals("Segment")) {
                String p3 = controller.getSegmentTurningFields()[0].getText();
                String p4 = controller.getSegmentTurningFields()[1].getText();
                String p5 = controller.getSegmentTurningFields()[2].getText();
                if (validNumbers(p3) && validNumbers(p4) && validNumbers(p5)) {
                    data.setBladeWidth(Double.parseDouble(p3));
                    data.setDepth(Double.parseDouble(p4));
                    data.setDiameter(Double.parseDouble(p5));
                    if (!validDTO(data)) {
                        controller.getOutput().setText("this not may be <= 0");
                    } else {
                        calculator.compute(data);
                    }
                } else {
                    controller.getOutput().setText("Incorrect input");
                }
            } else if (data.getToolType().equals("Threading")) {
                String p2 = controller.getThreadTurningFields()[0].getText();
                String p3 = controller.getThreadTurningFields()[1].getText();
                String p4 = controller.getThreadTurningFields()[2].getText();
                if (validNumbers(p3) && validNumbers(p4) && validNumbers(p2)) {
                    data.setThreadStep(Double.parseDouble(p2));
                    data.setDiameter(Double.parseDouble(p3));
                    data.setLength(Double.parseDouble(p4));
                    if (!validDTO(data)) {
                        controller.getOutput().setText("this not may be <= 0");
                    } else {
                        calculator.compute(data);
                    }
                } else {
                    controller.getOutput().setText("Incorrect input");
                }
            } else if (data.getCuttingType().equals("Turning")) {
                String p1 = controller.getTurningFields()[0].getText();
                String p2 = controller.getTurningFields()[1].getText();
                String p3 = controller.getTurningFields()[2].getText();
                String p4 = controller.getTurningFields()[3].getText();
                String p5 = controller.getTurningFields()[4].getText();
                if (validNumbers(p1) && validNumbers(p2) && validNumbers(p3) && validNumbers(p4) &&
                        validNumbers(p5)) {
                    data.setDiameter(Double.parseDouble(p1));
                    data.setDepth(Double.parseDouble(p2));
                    data.setLength(Double.parseDouble(p3));
                    data.setChamfersCount(Integer.parseInt(p4));
                    data.setQualitat(Integer.parseInt(p5));
                    if (!validDTO(data)) {
                        controller.getOutput().setText("this not may be <= 0");
                    } else {
                        calculator.compute(data);
                    }
                } else {
                    controller.getOutput().setText("Incorrect input");
                }
            } else if (data.getCuttingType().equals("Milling")) {
                if (data.getToolType().equals("Disk milling")) {
                    String p1 = controller.getMillingFields()[0].getText();
                    String p2 = controller.getMillingFields()[1].getText();
                    String p3 = controller.getMillingFields()[2].getText();
                    String p4 = controller.getMillingFields()[3].getText();
                    String p5 = controller.getMillingFields()[4].getText();
                    String p6 = controller.getMillingFields()[5].getText();
                    if (validNumbers(p1) && validNumbers(p2) && validNumbers(p3) && validNumbers(p4) && validNumbers(p5)
                            && validNumbers(p6)) {
                        data.setLength(Double.parseDouble(p1));
                        data.setDepth(Double.parseDouble(p2));
                        data.setBladeWidth(Integer.parseInt(p3));
                        data.setZcount(Integer.parseInt(p4));
                        data.setMillDiameter(Integer.parseInt(p5));
                        data.setMillWidth(Double.parseDouble(p6));
                        if (!validDTO(data)) {
                            controller.getOutput().setText("this not may be <= 0");
                        } else {
                            calculator.compute(data);
                        }
                    } else {
                        controller.getOutput().setText("Incorrect input");
                    }
                } else if (data.getToolType().equals("Circuit")) {
                    String p1 = controller.getMillingFields()[0].getText();
                    String p2 = controller.getMillingFields()[1].getText();
                    String p3 = controller.getMillingFields()[2].getText();
                    String p4 = controller.getMillingFields()[3].getText();
                    String p5 = controller.getMillingFields()[4].getText();
                    String p6 = controller.getMillingFields()[5].getText();
                    if (validNumbers(p1) && validNumbers(p2) && validNumbers(p3) && validNumbers(p4) && validNumbers(p5)
                            && validNumbers(p6)) {
                        data.setLength(Double.parseDouble(replaceComma(p1)));
                        data.setDepth(Double.parseDouble(replaceComma(p2)));
                        data.setBladeWidth(Integer.parseInt(replaceComma(p3)));
                        data.setZcount(Integer.parseInt(replaceComma(p4)));
                        data.setMillDiameter(Integer.parseInt(replaceComma(p5)));
                        data.setMillLength(Double.parseDouble(replaceComma(p6)));
                        if (!validDTO(data)) {
                            controller.getOutput().setText("this not may be <= 0");
                        } else {
                            calculator.compute(data);
                        }
                    } else {
                        controller.getOutput().setText("Incorrect input");
                    }
                } else {
                    String p1 = controller.getMillingFields()[0].getText();
                    String p2 = controller.getMillingFields()[1].getText();
                    String p3 = controller.getMillingFields()[2].getText();
                    String p4 = controller.getMillingFields()[3].getText();
                    String p5 = controller.getMillingFields()[4].getText();
                    if (validNumbers(p1) && validNumbers(p2) && validNumbers(p3) && validNumbers(p4) && validNumbers(p5)) {
                        data.setSquare(Double.parseDouble(p1));
                        data.setDepth(Double.parseDouble(p2));
                        data.setQualitat(Integer.parseInt(p3));
                        data.setZcount(Integer.parseInt(p4));
                        data.setMillDiameter(Integer.parseInt(p5));
                        /**
                         * TODO
                         * Защитить код от исключений,связанных с целыми числами
                         */
                        if (!validDTO(data)) {
                            controller.getOutput().setText("this not may be <= 0");
                        } else {
                            calculator.compute(data);
                        }
                    } else {
                        controller.getOutput().setText("Incorrect input");
                    }
                }
            }
        } else {
            data.setMaterial(text);
            if (data.getToolType().equals("Disk milling")) {
                controller.discMillingParametersPanel();
            } else if (data.getCuttingType().equals("Drilling")) {
                calculator.compute(data);
            } else if (data.getToolType().equals("Segment")) {
                controller.segmentTurningParametersPanel();
            } else if (data.getToolType().equals("Threading")) {
                controller.threadTurningParametersPanel();
            } else if (data.getCuttingType().equals("Turning")) {
                controller.turningParametersWindow();
            } else if (data.getToolType().equals("Circuit")) {
                controller.conturMillingParametersPanel();
            } else if (data.getCuttingType().equals("Milling")) {
                controller.millingParametersWindow();
            }
        }
    }

    public boolean validNumbers(String text) {
        return text.matches("([0-9]*[.,])?[0-9]+") && !text.isEmpty();
    }

    public boolean validDTO(Data data) {
        if (data.getCuttingType().equals("Turning")) {
            if (data.getToolType().equals("Threading")) {
                if (data.getThreadStep() <= 0 || data.getLength() <= 0 || data.getDiameter() <= 0) {
                    return false;
                }
            } else if (data.getToolType().equals("Segment")) {
                if (data.getBladeWidth() <= 0 || data.getDepth() <= 0 || data.getDiameter() <= 0) {
                    return false;
                }
            } else {
                if (data.getDepth() <= 0 || data.getLength() <= 0 || data.getDiameter() <= 0) {
                    return false;
                }
            }
        } else if (data.getCuttingType().equals("Milling")) {
            if (data.getToolType().equals("Disk milling")) {
                if (data.getDepth() <= 0 || data.getLength() <= 0 || data.getBladeWidth() <= 0 ||
                        data.getZcount() <= 0 || data.getMillWidth() <= 0 || data.getMillDiameter() <= 0) {
                    return false;
                }
            } else if (data.getToolType().equals("Circuit")) {
                if (data.getDepth() <= 0 || data.getLength() <= 0 || data.getBladeWidth() <= 0 ||
                        data.getZcount() <= 0 || data.getMillLength() <= 0 || data.getMillDiameter() <= 0) {
                    return false;
                }
            } else {
                if (data.getSquare() <= 0 || data.getDepth() <= 0 || data.getMillDiameter() <= 0 ||
                        data.getZcount() <= 0) {
                    return false;
                }
            }
        } else {
            if (data.getDiameter() <= 0 || data.getDepth() <= 0) {
                return false;
            }
        }
        return true;
    }

    public String replaceComma(String text) {
        if (text.contains(",")) {
            text = text.replaceAll(",", ".");
        }
        return text;
    }

}
