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

    private JButton[] tools;

    private JButton[] control;

    private JPanel last;

    private JLabel text;

    private Calculator calculator;

    private Data data;


    public WindowController() {
        frame = new JFrame();
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
        } else if (text.equals("Turning Out")) {
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
            materialsMatrixPanel();
            outputWindow();
        } else {
            if (data.getCuttingType().equals("Turning")) {
                turningParametersWindow();
            } else if (data.getCuttingType().equals("Milling")) {
                millingParametersWindow();
            }
        }
    }

    public void mainPage() {
        frame.setSize(1500, 300);
        frame.setVisible(true);
        text.setBackground(new Color(30, 30, 30));
        text.setForeground(new Color(30, 200, 100));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setFont(new Font("Ink Free", Font.BOLD, 30));
        text.setText("Cuttingtime calculator");
        text.setOpaque(true);
        panel.setLayout(new BorderLayout());
        panel.setBounds(0, 0, 100, 100);
        panel.add(text);
        frame.add(panel, BorderLayout.NORTH);

        toolType = new JPanel();
        toolType.setLayout(new GridLayout(1, 3));
        toolType.setBackground(new Color(200, 200, 200));
        tools = new JButton[3];
        String[] types = new String[]{"Turning", "Milling", "Drilling"};
        for (int i = 0; i < 3; i++) {
            tools[i] = new JButton();
            toolType.add(tools[i]);
            tools[i].setFont(new Font("MVBoli", Font.BOLD, 50));
            tools[i].setFocusable(false);
            tools[i].addActionListener(this);
            tools[i].setText(types[i]);
        }
        control = tools;
        last = toolType;
        render(toolType);
    }

    public void backFunction(JPanel oldPanel) {
        frame.remove(oldPanel);
        mainPage();
    }

    public void render(JPanel panel) {
        frame.getContentPane().add(panel);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    public JButton createButton(String text) {
        JButton button = new JButton();
        button.setText(text);
        button.setFont(new Font("MVBoli", Font.PLAIN, 20));
        button.setFocusable(false);
        button.addActionListener(this);
        return button;
    }


    public void turningWindow() {
        turning = new JPanel();
        turning.setLayout(new GridLayout(1, 5));
        turning.setBackground(new Color(200, 200, 200));
        JButton[] buttons = new JButton[5];
        String[] types = new String[]{"Turning out", "Boring", "Groove", "Segment", "Back"};
        for (int i = 0; i < 5; i++) {
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
        milling.setLayout(new GridLayout(1, 5));
        milling.setBackground(new Color(200, 200, 200));
        JButton[] buttons = new JButton[4];
        String[] types = new String[]{"End milling", "Face milling", "Disk milling", "Back"};
        for (int i = 0; i < 4; i++) {
            buttons[i] = createButton(types[i]);
            milling.add(buttons[i]);
        }
        control = buttons;
        frame.remove(last);
        last = milling;
        render(milling);
    }

    public void drillingWindow() {
        JTextField[] jTextFields = new JTextField[2];
        JButton[] buttons = new JButton[2];
        String[] types = new String[]{"Submit", "Back"};
        drilling = new JPanel();
        drilling.setLayout(new GridLayout(1, 5));
        drilling.setBackground(new Color(200, 200, 200));
        jTextFields[0] = new JTextField();
        jTextFields[0].setText("Diameter");
        jTextFields[0].setFont(new Font("MVBoli", Font.PLAIN, 20));
        drilling.add(jTextFields[0]);
        jTextFields[1] = new JTextField();
        jTextFields[1].setText("Length");
        jTextFields[1].setFont(new Font("MVBoli", Font.PLAIN, 20));
        drilling.add(jTextFields[1]);
        for (int i = 0; i < buttons.length; i++) {
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
        JTextField[] jTextFields = new JTextField[2];
        JButton[] buttons = new JButton[2];
        String[] types = new String[]{"Go", "Back"};
        millingParameters = new JPanel();
        millingParameters.setLayout(new GridLayout(1, 5));
        millingParameters.setBackground(new Color(200, 200, 200));
        jTextFields[0] = new JTextField();
        jTextFields[0].setText("Square");
        jTextFields[0].setFont(new Font("MVBoli", Font.PLAIN, 20));
        millingParameters.add(jTextFields[0]);
        jTextFields[1] = new JTextField();
        jTextFields[1].setText("Depth");
        jTextFields[1].setFont(new Font("MVBoli", Font.PLAIN, 20));
        millingParameters.add(jTextFields[1]);
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = createButton(types[i]);
            millingParameters.add(buttons[i]);
        }
        control = buttons;
        frame.remove(last);
        last = millingParameters;
        render(millingParameters);
    }

    public void turningParametersWindow() {
        JTextField[] jTextFields = new JTextField[4];
        JButton[] buttons = new JButton[2];
        String[] types = new String[]{"Go", "Back"};
        turningParameters = new JPanel();
        turningParameters.setLayout(new GridLayout(1, 5));
        turningParameters.setBackground(new Color(200, 200, 200));
        jTextFields[0] = new JTextField();
        jTextFields[0].setText("Diameter");
        jTextFields[0].setFont(new Font("MVBoli", Font.PLAIN, 20));
        turningParameters.add(jTextFields[0]);
        jTextFields[1] = new JTextField();
        jTextFields[1].setText("Total depth");
        jTextFields[1].setFont(new Font("MVBoli", Font.PLAIN, 20));
        turningParameters.add(jTextFields[1]);
        jTextFields[2] = new JTextField();
        jTextFields[2].setText("Length");
        jTextFields[2].setFont(new Font("MVBoli", Font.PLAIN, 20));
        turningParameters.add(jTextFields[2]);
        jTextFields[3] = new JTextField();
        jTextFields[3].setText("Chamfers count");
        jTextFields[3].setFont(new Font("MVBoli", Font.PLAIN, 20));
        turningParameters.add(jTextFields[3]);
        for (int i = 0; i < buttons.length; i++) {
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
