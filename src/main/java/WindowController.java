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


    public WindowController() {
        frame = new JFrame();
        output = new JTextField();
        output.setSize(new Dimension(450, 400));
        frame.add(output, BorderLayout.PAGE_END);
        panel = new JPanel();
        text = new JLabel();
        calculator = new Calculator();
        data = new Data();
        mainPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
        } else if (text.equals("Disk milling")) {
            data.setToolType(text);
            materialsMatrixPanel();
        } else if (text.equals("Submit")) {
            String p1 = blankChange(drillingFields[0].getText());
            String p2 = blankChange(drillingFields[1].getText());
            if (validNumbers(p1) && validNumbers(p2)) {
                data.setDiameter(Double.parseDouble(p1));
                data.setDepth(Double.parseDouble(p2));
            }
            materialsMatrixPanel();
            outputWindow();
        } else if (text.equals("Go")) {
            if (data.getCuttingType().equals("Turning")) {
                String p1 = blankChange(turningFields[0].getText());
                String p2 = blankChange(turningFields[1].getText());
                String p3 = blankChange(turningFields[2].getText());
                String p4 = blankChange(turningFields[3].getText());
                if (validNumbers(p1) && validNumbers(p2) && validNumbers(p3) && validNumbers(p4)) {
                    data.setDiameter(Double.parseDouble(p1));
                    data.setDepth(Double.parseDouble(p2));
                    data.setLength(Double.parseDouble(p3));
                    data.setChamfersCount(Integer.parseInt(p4));
                }
            } else if (data.getCuttingType().equals("Milling")) {
                String p1 = blankChange(millingFields[0].getSelectedText());
                String p2 = blankChange(millingFields[1].getSelectedText());
                if (validNumbers(p1) && validNumbers(p2)) {
                    data.setSquare(Double.parseDouble(p1));
                    data.setDepth(Double.parseDouble(p2));
                }
            }
        } else {
            data.setMaterial(text);
            if (data.getCuttingType().equals("Turning")) {
                turningParametersWindow();
            } else if (data.getCuttingType().equals("Milling")) {
                millingParametersWindow();
            } else {

            }
        }
        System.out.println(data);
    }

    public String blankChange(String text) {
        if (text == null) {
            return "";
        }
        return text.isBlank() ? "0": text;
    }

    public boolean validNumbers(String text) {
        System.out.println(text);
        return text.matches("([0-9]*[.])?[0-9]+");
    }

    public void mainPage() {
        frame.setSize(450, 800);
        frame.setResizable(false);
        frame.setVisible(true);
        text.setBackground(new Color(30, 30, 30));
        text.setForeground(new Color(30, 200, 100));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setFont(new Font("Ink Free", Font.PLAIN, 20));
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
        field.setName(name);
        field.addActionListener(this);
        field.setFont(new Font("MVBoli", Font.PLAIN, 20));
        return field;
    }


    public void turningWindow() {
        turning = new JPanel();
        turning.setLayout(new GridLayout(3, 3));
        turning.setBackground(new Color(200, 200, 200));
        JButton[] buttons = new JButton[9];
        String[] types = new String[]{"Turning out", "Boring", "Groove", "Segment", "Back", "", "", "", ""};
        for (int i = 0; i < 9; i++) {
            buttons[i] = createButton(types[i]);
            turning.add(buttons[i]);
        }
        control = buttons;
        frame.remove(last);
        last = turning;
        render(turning);
    }


    public void millingWindow() {
        milling = new JPanel();
        milling.setLayout(new GridLayout(3, 3));
        milling.setBackground(new Color(200, 200, 200));
        JButton[] buttons = new JButton[9];
        String[] types = new String[]{"End milling", "Face milling", "Disk milling", "Back", "", "", "", "", ""};
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
        JButton[] buttons = new JButton[7];
        String[] types = new String[]{"Submit", "Back", "", "", "", "", ""};
        drilling = new JPanel();
        drilling.setLayout(new GridLayout(3, 3));
        drilling.setBackground(new Color(200, 200, 200));
        drillingFields[0] = createTextField("Diameter");
        drilling.add(drillingFields[0]);
        drillingFields[1] = createTextField("Length");
        drilling.add(drillingFields[1]);
        for (int i = 0; i < 7; i++) {
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
        String[] types = new String[]{"Steel", "Aluminium alloys", "Hard steel",
        "Cuprum alloys", "Stainless steel", "Textolit", "Plastic", "Cast Iron", "Back"};
        for (int i = 0; i < 9; i++) {
            buttons[i] = createButton(types[i]);
            materials.add(buttons[i]);
        }
        control = buttons;
        frame.remove(last);
        last = materials;
        render(materials);
    }

    public void millingParametersWindow() {
        millingFields = new JTextField[2];
        JButton[] buttons = new JButton[7];
        String[] types = new String[]{"Go", "Back", "", "", "", "", ""};
        millingParameters = new JPanel();
        millingParameters.setLayout(new GridLayout(3, 3));
        millingParameters.setBackground(new Color(200, 200, 200));
        millingFields[0] = createTextField("Square");
        millingParameters.add(millingFields[0]);
        millingFields[1] = createTextField("Depth");
        millingParameters.add(millingFields[1]);
        for (int i = 0; i < 7; i++) {
            buttons[i] = createButton(types[i]);
            millingParameters.add(buttons[i]);
        }
        control = buttons;
        frame.remove(last);
        last = millingParameters;
        render(millingParameters);
    }

    public void turningParametersWindow() {
        turningFields = new JTextField[4];
        JButton[] buttons = new JButton[5];
        String[] types = new String[]{"Go", "Back", "", "", ""};
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
        for (int i = 0; i < 5; i++) {
            buttons[i] = createButton(types[i]);
            turningParameters.add(buttons[i]);
        }
        control = buttons;
        frame.remove(last);
        last = turningParameters;
        render(turningParameters);
    }

    public void outputWindow() {

    }
}
