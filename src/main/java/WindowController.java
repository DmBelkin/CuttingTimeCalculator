import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowController implements ActionListener {

    private JFrame frame;

    private JPanel panel;

    private JPanel toolType;

    private JPanel turning;

    private JPanel milling;

    private JPanel drilling;

    private JPanel materials;

    private JPanel turningParameters;

    private JPanel millingParameters;

    private JPanel segmentTurningParameters;

    private JTextField[] segmentTurningFields;

    private JPanel threadTurningParameters;

    private JTextField[] threadTurningFields;

    private JTextField[] drillingFields;

    private JTextField[] millingFields;

    private JTextField[] turningFields;

    private JButton[] tools;

    private JButton[] control;

    private JPanel last;

    private JLabel text;

    private Calculator calculator;

    private Data data;

    private JTextField output;

    private JToggleButton isHSS;

    private JToggleButton isCPU;


    public WindowController() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        output = new JTextField();
        output.setSize(new Dimension(450, 50));
        output.setFont(new Font("Ink Free", Font.PLAIN, 50));
        output.setBackground(new Color(30, 30, 30));
        output.setForeground(new Color(30, 200, 100));
        output.setText("0.0");
        frame.add(output, BorderLayout.PAGE_END);
        panel = new JPanel();
        text = new JLabel();
        calculator = new Calculator();
        calculator.setController(this);
        data = new Data();
        isCPU = new JToggleButton("CNC");
        isCPU.addActionListener(this);
        isHSS = new JToggleButton("HSS");
        isHSS.addActionListener(this);
        mainPage();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == isHSS && !data.isHSS()) {
            isHSS.setSelected(true);
            data.setHSS(true);
            return;
        }
        if (e.getSource() == isHSS && data.isHSS()) {
            isHSS.setSelected(false);
            data.setHSS(false);
            return;
        }
        if (e.getSource() == isCPU && !data.isCPU()) {
            isCPU.setSelected(true);
            data.setCPU(true);
            return;
        }
        if (e.getSource() == isCPU && data.isCPU()) {
            isCPU.setSelected(false);
            data.setCPU(false);
            return;
        }
        for (int i = 0; i < control.length; i++) {
            if (e.getSource() == control[i]) {
                getAction(control[i].getText());
            }
        }
    }

    public void getAction(String text) {
        if (text.isBlank()) {
            return;
        }
        if (text.equals("Turning")) {
            data.setCuttingType(text);
            turningWindow();
        } else if (text.equals("Milling")) {
            data.setCuttingType(text);
            millingWindow();
        } else if (text.equals("Drilling")) {
            data.setCuttingType(text);
            drillingWindow();
        } else if (text.equals("Back")) {
            backFunction(last);
        } else if (text.equals("Turning out")) {
            data.setToolType(text);
            materialsMatrixPanel();
        } else if (text.equals("Boring")) {
            data.setToolType(text);
            materialsMatrixPanel();
        } else if (text.equals("Groove")) {
            data.setToolType(text);
            materialsMatrixPanel();
        } else if (text.equals("Segment")) {
            data.setToolType(text);
            materialsMatrixPanel();
        } else if (text.equals("Face milling")) {
            data.setToolType(text);
            materialsMatrixPanel();
        } else if (text.equals("End milling")) {
            data.setToolType(text);
            materialsMatrixPanel();
        } else if (text.equals("Threading")) {
            data.setToolType(text);
            materialsMatrixPanel();
        } else if (text.equals("Disk milling")) {
            data.setToolType(text);
            materialsMatrixPanel();
        } else if (text.equals("Submit")) {
            String p1 = drillingFields[0].getText();
            String p2 = drillingFields[1].getText();
            if (validNumbers(p1) && validNumbers(p2)) {
                data.setDiameter(Double.parseDouble(p1));
                data.setDepth(Double.parseDouble(p2));
                if (!validDTO(data)) {
                    output.setText("this not may be <= 0");
                } else {
                    materialsMatrixPanel();
                }
            } else {
                output.setText("Incorrect input");
            }
        } else if (text.equals("Go")) {
            if (data.getToolType().equals("Segment")) {
                String p3 = segmentTurningFields[0].getText();
                String p4 = segmentTurningFields[1].getText();
                String p5 = segmentTurningFields[2].getText();
                if (validNumbers(p3) && validNumbers(p4) && validNumbers(p5)) {
                    data.setBladeWidth(Double.parseDouble(p3));
                    data.setDepth(Double.parseDouble(p4));
                    data.setDiameter(Double.parseDouble(p5));
                    if (!validDTO(data)) {
                        output.setText("this not may be <= 0");
                    } else {
                        calculator.compute(data);
                    }
                } else {
                    output.setText("Incorrect input");
                }
            } else if (data.getToolType().equals("Threading")) {
                String p2 = threadTurningFields[0].getText();
                String p3 = threadTurningFields[1].getText();
                String p4 = threadTurningFields[2].getText();
                if (validNumbers(p3) && validNumbers(p4) && validNumbers(p2)) {
                    data.setThreadStep(Double.parseDouble(p2));
                    data.setDiameter(Double.parseDouble(p3));
                    data.setLength(Double.parseDouble(p4));
                    if (!validDTO(data)) {
                        output.setText("this not may be <= 0");
                    } else {
                        calculator.compute(data);
                    }
                } else {
                    output.setText("Incorrect input");
                }
            } else if (data.getCuttingType().equals("Turning")) {
                String p1 = turningFields[0].getText();
                String p2 = turningFields[1].getText();
                String p3 = turningFields[2].getText();
                String p4 = turningFields[3].getText();
                String p5 = turningFields[4].getText();
                if (validNumbers(p1) && validNumbers(p2) && validNumbers(p3) && validNumbers(p4) &&
                validNumbers(p5)) {
                    data.setDiameter(Double.parseDouble(p1));
                    data.setDepth(Double.parseDouble(p2));
                    data.setLength(Double.parseDouble(p3));
                    data.setChamfersCount(Integer.parseInt(p4));
                    data.setQualitat(Integer.parseInt(p5));
                    if (!validDTO(data)) {
                        output.setText("this not may be <= 0");
                    } else {
                        calculator.compute(data);
                    }
                } else {
                    output.setText("Incorrect input");
                }
            } else if (data.getCuttingType().equals("Milling")) {
                if (data.getToolType().equals("Disk milling")) {
                    String p1 = millingFields[0].getText();
                    String p2 = millingFields[1].getText();
                    String p3 = millingFields[2].getText();
                    String p4 = millingFields[3].getText();
                    String p5 = millingFields[4].getText();
                    String p6 = millingFields[5].getText();
                    if (validNumbers(p1) && validNumbers(p2) && validNumbers(p3) && validNumbers(p4) && validNumbers(p5)
                    && validNumbers(p6)) {
                        data.setLength(Double.parseDouble(p1));
                        data.setDepth(Double.parseDouble(p2));
                        data.setBladeWidth(Integer.parseInt(p3));
                        data.setZcount(Integer.parseInt(p4));
                        data.setMillDiameter(Integer.parseInt(p5));
                        data.setMillWidth(Double.parseDouble(p6));
                        if (!validDTO(data)) {
                            output.setText("this not may be <= 0");
                        } else {
                            calculator.compute(data);
                        }
                    } else {
                        output.setText("Incorrect input");
                    }
                } else {
                    String p1 = millingFields[0].getText();
                    String p2 = millingFields[1].getText();
                    String p3 = millingFields[2].getText();
                    String p4 = millingFields[3].getText();
                    String p5 = millingFields[4].getText();
                    if (validNumbers(p1) && validNumbers(p2) && validNumbers(p3) && validNumbers(p4) && validNumbers(p5)) {
                        data.setSquare(Double.parseDouble(p1));
                        data.setDepth(Double.parseDouble(p2));
                        data.setQualitat(Integer.parseInt(p3));
                        data.setZcount(Integer.parseInt(p4));
                        data.setMillDiameter(Integer.parseInt(p5));
                        if (!validDTO(data)) {
                            output.setText("this not may be <= 0");
                        } else {
                            calculator.compute(data);
                        }
                    } else {
                        output.setText("Incorrect input");
                    }
                }
            }
        } else {
            data.setMaterial(text);
            if (data.getToolType().equals("Disk milling")) {
                discMillingParametersPanel();
            } else if (data.getCuttingType().equals("Drilling")){
                calculator.compute(data);
            } else if (data.getToolType().equals("Segment")) {
                segmentTurningParametersPanel();
            } else if (data.getToolType().equals("Threading")) {
                threadTurningParametersPanel();
            } else if (data.getCuttingType().equals("Turning")) {
                turningParametersWindow();
            } else if (data.getCuttingType().equals("Milling")) {
                millingParametersWindow();
            }
        }
    }

    public boolean validNumbers(String text) {
        return text.matches("([0-9]*[.])?[0-9]+") && !text.isEmpty();
    }

    public boolean validDTO(Data data) {
        if(data.getCuttingType().equals("Turning")) {
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
            } else {
                if (data.getSquare() <= 0 || data.getDepth() <= 0 || data.getMillDiameter() <= 0 ||
                data.getZcount() <= 0) {
                    return false;
                }
            }
        } else {
            if (data.getLength() <= 0 || data.getDiameter() <= 0) {
                return false;
            }
        }
        return true;
    }

    public void mainPage() {
        frame.setSize(450, 290);
        frame.setResizable(false);
        frame.setVisible(true);
        text.setBackground(new Color(30, 30, 30));
        text.setForeground(new Color(30, 200, 100));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setFont(new Font("Ink Free", Font.PLAIN, 50));
        text.setText("Cuttingtime calculator");
        text.setOpaque(true);
        panel.setLayout(new BorderLayout());
        panel.setBounds(0, 0, 100, 100);
        panel.add(text);
        frame.add(panel, BorderLayout.NORTH);

        toolType = new JPanel();
        toolType.setLayout(new GridLayout(3, 3));
        toolType.setBackground(new Color(200, 200, 200));
        tools = new JButton[9];
        String[] types = new String[]{"Turning", "Milling", "Drilling", "", "", "", "", "", ""};
        for (int i = 0; i < 9; i++) {
            tools[i] = createButton(types[i]);
            toolType.add(tools[i]);
        }
        control = tools;
        last = toolType;
        render(toolType);
    }

    public void backFunction(JPanel oldPanel) {
        frame.remove(oldPanel);
        data.reset();
        output.setText("0.0");
        isCPU.setSelected(false);
        isHSS.setSelected(false);
        data.setCPU(false);
        data.setHSS(false);
        mainPage();
    }

    public void render(JPanel panel) {
        frame.setResizable(false);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public JButton createButton(String text) {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(150, 80));
        button.setText(text);
        button.setFont(new Font("MVBoli", Font.PLAIN, 20));
        button.setFocusable(false);
        button.addActionListener(this);
        return button;
    }

    public JTextField createTextField(String name) {
        JTextField field = new JTextField();
        field.setText(name);
        field.addActionListener(this);
        field.setFont(new Font("MVBoli", Font.PLAIN, 20));
        return field;
    }


    public void turningWindow() {
        turning = new JPanel();
        turning.setLayout(new GridLayout(3, 3));
        turning.setBackground(new Color(200, 200, 200));
        JButton[] buttons = new JButton[9];
        String[] types = new String[]{"Turning out", "Boring", "Groove", "Segment", "Threading", "", "", "", "Back"};
        for (int i = 0; i < 9; i++) {
            buttons[i] = createButton(types[i]);
            turning.add(buttons[i]);
        }
        control = buttons;
        frame.remove(last);
        last = turning;
        render(turning);
    }

    public void segmentTurningParametersPanel() {
        segmentTurningFields = new JTextField[3];
        JButton[] buttons = new JButton[5];
        String[] types = new String[]{"", "", "", "Go", "Back"};
        segmentTurningParameters = new JPanel();
        segmentTurningParameters.setLayout(new GridLayout(3, 3));
        segmentTurningParameters.setBackground(new Color(200, 200, 200));
        segmentTurningFields[0] = createTextField("Blade width");
        segmentTurningParameters.add(segmentTurningFields[0]);
        segmentTurningFields[1] = createTextField("Depth");
        segmentTurningParameters.add(segmentTurningFields[1]);
        segmentTurningFields[2] = createTextField("Diameter");
        segmentTurningParameters.add(segmentTurningFields[2]);
        segmentTurningParameters.add(isCPU);
        for (int i = 0; i < 5; i++) {
            buttons[i] = createButton(types[i]);
            segmentTurningParameters.add(buttons[i]);
        }
        control = buttons;
        frame.remove(last);
        last = segmentTurningParameters;
        render(segmentTurningParameters);
    }

    public void threadTurningParametersPanel() {
        threadTurningFields = new JTextField[3];
        JButton[] buttons = new JButton[5];
        String[] types = new String[]{"", "", "", "Go", "Back"};
        threadTurningParameters = new JPanel();
        threadTurningParameters.setLayout(new GridLayout(3, 3));
        threadTurningParameters.setBackground(new Color(200, 200, 200));
        threadTurningFields[0] = createTextField("Step");
        threadTurningParameters.add(threadTurningFields[0]);
        threadTurningFields[1] = createTextField("Diameter");
        threadTurningParameters.add(threadTurningFields[1]);
        threadTurningFields[2] = createTextField("Length");
        threadTurningParameters.add(threadTurningFields[2]);
        threadTurningParameters.add(isCPU);
        for (int i = 0; i < 5; i++) {
            buttons[i] = createButton(types[i]);
            threadTurningParameters.add(buttons[i]);
        }
        control = buttons;
        frame.remove(last);
        last = threadTurningParameters;
        render(threadTurningParameters);
    }

    public void discMillingParametersPanel() {
        millingFields = new JTextField[6];
        JButton[] buttons = new JButton[3];
        String[] types = new String[]{"Go", "Back"};
        millingParameters = new JPanel();
        millingParameters.setLayout(new GridLayout(3, 3));
        millingParameters.setBackground(new Color(200, 200, 200));
        millingFields[0] = createTextField("Length");
        millingParameters.add(millingFields[0]);
        millingFields[1] = createTextField("Depth");
        millingParameters.add(millingFields[1]);
        millingFields[2] = createTextField("Width");
        millingParameters.add(millingFields[2]);
        millingFields[3] = createTextField("Z-count");
        millingParameters.add(millingFields[3]);
        millingFields[4] = createTextField("Mill D");
        millingParameters.add(millingFields[4]);
        millingFields[5] = createTextField("Mill width");
        millingParameters.add(millingFields[5]);
        millingParameters.add(isCPU);
        for (int i = 0; i < 2; i++) {
            buttons[i] = createButton(types[i]);
            millingParameters.add(buttons[i]);
        }
        control = buttons;
        frame.remove(last);
        last = millingParameters;
        render(millingParameters);
    }


    public void millingWindow() {
        milling = new JPanel();
        milling.setLayout(new GridLayout(3, 3));
        milling.setBackground(new Color(200, 200, 200));
        JButton[] buttons = new JButton[9];
        String[] types = new String[]{"End milling", "Face milling", "Disk milling", "", "", "", "", "", "Back"};
        for (int i = 0; i < 9; i++) {
            buttons[i] = createButton(types[i]);
            milling.add(buttons[i]);
        }
        control = buttons;
        frame.remove(last);
        last = milling;
        render(milling);
    }

    public void drillingWindow() {
        drillingFields = new JTextField[2];
        JButton[] buttons = new JButton[6];
        String[] types = new String[]{"", "", "", "", "Submit", "Back"};
        drilling = new JPanel();
        drilling.setLayout(new GridLayout(3, 3));
        drilling.setBackground(new Color(200, 200, 200));
        drillingFields[0] = createTextField("Diameter");
        drilling.add(drillingFields[0]);
        drillingFields[1] = createTextField("Length");
        drilling.add(drillingFields[1]);
        drilling.add(isHSS);
        for (int i = 0; i < 6; i++) {
            buttons[i] = createButton(types[i]);
            drilling.add(buttons[i]);
        }
        control = buttons;
        frame.remove(last);
        last = drilling;
        render(drilling);
    }

    public void materialsMatrixPanel() {
        materials = new JPanel();
        materials.setLayout(new GridLayout(3, 3));
        materials.setBackground(new Color(200, 200, 200));
        JButton[] buttons = new JButton[9];
        String[] types = new String[]{"Steel", "Aluminium alloys", "Hard steel", "Stainless steel",
                "Cuprum alloys", "Textolit", "Plastic", "Titan", "Back"};
        for (int i = 0; i < 9; i++) {
            buttons[i] = createButton(types[i]);
            buttons[i].setFont(new Font("MVBoli", Font.PLAIN, 10));
            materials.add(buttons[i]);
        }
        control = buttons;
        frame.remove(last);
        last = materials;
        render(materials);
    }

    public void millingParametersWindow() {
        millingFields = new JTextField[5];
        JButton[] buttons = new JButton[3];
        String[] types = new String[]{"", "Go", "Back"};
        millingParameters = new JPanel();
        millingParameters.setLayout(new GridLayout(3, 3));
        millingParameters.setBackground(new Color(200, 200, 200));
        millingFields[0] = createTextField("Square");
        millingParameters.add(millingFields[0]);
        millingFields[1] = createTextField("Depth");
        millingParameters.add(millingFields[1]);
        millingFields[2] = createTextField("Qualitat");
        millingParameters.add(millingFields[2]);
        millingFields[3] = createTextField("Z-count");
        millingParameters.add(millingFields[3]);
        millingFields[4] = createTextField("Mill D");
        millingParameters.add(millingFields[4]);
        millingParameters.add(isCPU);
        for (int i = 0; i < 3; i++) {
            buttons[i] = createButton(types[i]);
            millingParameters.add(buttons[i]);
        }
        control = buttons;
        frame.remove(last);
        last = millingParameters;
        render(millingParameters);
    }

    public void turningParametersWindow() {
        turningFields = new JTextField[5];
        JButton[] buttons = new JButton[3];
        String[] types = new String[]{ "", "Go", "Back"};
        turningParameters = new JPanel();
        turningParameters.setLayout(new GridLayout(3, 3));
        turningParameters.setBackground(new Color(200, 200, 200));
        turningFields[0] = createTextField("Diameter");
        turningParameters.add(turningFields[0]);
        turningFields[1] = createTextField("Total depth");
        turningParameters.add(turningFields[1]);
        turningFields[2] = createTextField("Length");
        turningParameters.add(turningFields[2]);
        turningFields[3] = createTextField("Chamfers count");
        turningParameters.add(turningFields[3]);
        turningFields[4] = createTextField("Qualitat");
        turningParameters.add(turningFields[4]);
        turningParameters.add(isCPU);
        for (int i = 0; i < 3; i++) {
            buttons[i] = createButton(types[i]);
            turningParameters.add(buttons[i]);
        }
        control = buttons;
        frame.remove(last);
        last = turningParameters;
        render(turningParameters);
    }

    public void outputWindow(String minutes) {
         output.setText(minutes);
    }
}
