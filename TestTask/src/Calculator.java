import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.util.StringTokenizer;

public class Calculator extends JFrame {

    // data
    static private String buf;

    // flag
    static private boolean Un;
    static private int Lbr;
    static private int Rbr;


    // buttons
    private JPanel Main;
    private JTextField textField;
    private JButton cBtn;
    private JButton multBtn;
    private JButton decBtn;
    private JButton incBtn;
    private JButton equBtn;
    private JButton divBtn;
    private JButton dotBtn;
    private JButton RBracketBtn;
    private JButton LBracketBtn;
    private JButton delBtn;
    private JButton oneBtn;
    private JButton fourBtn;
    private JButton fiveBtn;
    private JButton sevenBtn;
    private JButton eightBtn;
    private JButton zeroBtn;
    private JButton twoBtn;
    private JButton nineBtn;
    private JButton sixBtn;
    private JButton threeBtn;

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.pack();
    }

    public Calculator() {
        setContentPane(Main);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(700, 200, 300, 200);
        setVisible(true);
        buf = "";
        Un = true;
        Lbr = 0;
        Rbr = 0;

        cBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buf = "";
                Lbr = 0;
                Rbr = 0;
                textField.setText(buf);
            }
        });
        LBracketBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buf.length() == 0)
                {
                    buf += "(";
                    textField.setText(buf);
                    Lbr++;
                }
                else {
                    char last = buf.charAt(buf.length() - 1);
                    if (DotLast(last) || ValLast(last) || RBracketLast(last)) return;
                    buf += "(";
                    textField.setText(buf);
                    Lbr++;
                }
            }
        });
        RBracketBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buf.length() == 0 || Rbr == Lbr) return;
                else
                {
                    char last = buf.charAt(buf.length() - 1);
                    if (DotLast(last) || OpLast(last) || LBracketLast(last)) return;
                    buf += ")";
                    textField.setText(buf);
                    Rbr++;
                }
            }
        });
        divBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buf.length() == 0) return;
                else
                {
                    char last = buf.charAt(buf.length() - 1);
                    if (DotLast(last) || OpLast(last)) return;
                    buf += "/";
                    textField.setText(buf);
                }
            }
        });
        multBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buf.length() == 0) return;
                else
                {
                    char last = buf.charAt(buf.length() - 1);
                    if (DotLast(last) || OpLast(last)) return;
                    buf += "*";
                    textField.setText(buf);
                }
            }
        });
        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buf.length() == 0) return;
                if (buf.charAt(buf.length()-1) == '(') Lbr--;
                if (buf.charAt(buf.length()-1) == ')') Rbr--;
                if (buf.length() == 1) buf = "";
                else buf = buf.substring(0, buf.length() - 1) + buf.substring(buf.length());
                textField.setText(buf);
            }
        });
        dotBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buf.length() == 0) return;
                else
                {
                    char last = buf.charAt(buf.length() - 1);
                    if (DotLast(last) || OpLast(last) || LBracketLast(last) || RBracketLast(last)) return;
                    buf += ".";
                    textField.setText(buf);
                }
            }
        });
        decBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buf.length() == 0)
                {
                    buf += "-";
                    textField.setText(buf);
                }
                else
                {
                    char last = buf.charAt(buf.length() - 1);
                    if (DotLast(last) || OpLast(last)) return;
                    buf += "-";
                    textField.setText(buf);
                }
            }
        });
        incBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buf.length() == 0) return;
                else
                {
                    char last = buf.charAt(buf.length() - 1);
                    if (DotLast(last) || OpLast(last)) return;
                    buf += "+";
                    textField.setText(buf);
                }
            }
        });
        oneBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buf.length() == 0)
                {
                    buf += "1";
                    textField.setText(buf);
                }
                else
                {
                    char last = buf.charAt(buf.length() - 1);
                    if (RBracketLast(last)) return;
                    buf += "1";
                    textField.setText(buf);
                }
            }
        });
        twoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buf.length() == 0)
                {
                    buf += "2";
                    textField.setText(buf);
                }
                else
                {
                    char last = buf.charAt(buf.length() - 1);
                    if (RBracketLast(last)) return;
                    buf += "2";
                    textField.setText(buf);
                }
            }
        });
        threeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buf.length() == 0)
                {
                    buf += "3";
                    textField.setText(buf);
                }
                else
                {
                    char last = buf.charAt(buf.length() - 1);
                    if (RBracketLast(last)) return;
                    buf += "3";
                    textField.setText(buf);
                }
            }
        });
        fourBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buf.length() == 0)
                {
                    buf += "4";
                    textField.setText(buf);
                }
                else
                {
                    char last = buf.charAt(buf.length() - 1);
                    if (RBracketLast(last)) return;
                    buf += "4";
                    textField.setText(buf);
                }
            }
        });
        fiveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buf.length() == 0)
                {
                    buf += "5";
                    textField.setText(buf);
                }
                else
                {
                    char last = buf.charAt(buf.length() - 1);
                    if (RBracketLast(last)) return;
                    buf += "5";
                    textField.setText(buf);
                }
            }
        });
        sixBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buf.length() == 0)
                {
                    buf += "6";
                    textField.setText(buf);
                }
                else
                {
                    char last = buf.charAt(buf.length() - 1);
                    if (RBracketLast(last)) return;
                    buf += "6";
                    textField.setText(buf);
                }
            }
        });
        sevenBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buf.length() == 0)
                {
                    buf += "7";
                    textField.setText(buf);
                }
                else
                {
                    char last = buf.charAt(buf.length() - 1);
                    if (RBracketLast(last)) return;
                    buf += "7";
                    textField.setText(buf);
                }
            }
        });
        eightBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buf.length() == 0)
                {
                    buf += "8";
                    textField.setText(buf);
                }
                else
                {
                    char last = buf.charAt(buf.length() - 1);
                    if (RBracketLast(last)) return;
                    buf += "8";
                    textField.setText(buf);
                }
            }
        });
        nineBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buf.length() == 0)
                {
                    buf += "9";
                    textField.setText(buf);
                }
                else
                {
                    char last = buf.charAt(buf.length() - 1);
                    if (RBracketLast(last)) return;
                    buf += "9";
                    textField.setText(buf);
                }
            }
        });
        zeroBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buf.length() == 0)
                {
                    buf += "0";
                    textField.setText(buf);
                }
                else
                {
                    char last = buf.charAt(buf.length() - 1);
                    if (RBracketLast(last)) return;
                    if (buf.charAt(buf.length() - 1) == '0')
                    {
                        if (buf.length() == 1) return;
                        int i = buf.length() - 2;
                        while(buf.length() > 0)
                        {
                            if (buf.charAt(i) == '.') break;
                            else if (buf.charAt(i) == '(' || buf.charAt(i) == ')' || isOp(buf.charAt(i))) return;
                            i--;
                        }
                    }
                    buf += "0";
                    textField.setText(buf);
                }
            }
        });
        equBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOp(buf.charAt(buf.length() - 1)) || buf.charAt(buf.length() - 1) == '('
                        || buf.charAt(buf.length() - 1) == '.' || Lbr!=Rbr) return;
                buf = textField.getText();
                toOPS();
                try {
                   calc();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                textField.setText(buf);
            }
        });
    }

    ////////////////////////////////////////////// основные методы

    private static void toOPS(){
        // алгоритм Дейкстры по составлению обратной польской строки, легко найти в интернете
        // Это первое, что пришло в голову, когда прочитал о необходимости делать скобки
        // алгоритм немного расширен для унарного минуса
        String stack = "", output = "";
        char cur, temp;
        Un = true;

        for (int i = 0; i < buf.length(); i++) {
            cur = buf.charAt(i);
            if (isOp(cur)) {
                if (stack.length() > 0) {
                    while (stack.length() > 0) {
                        temp = stack.charAt(stack.length() - 1);
                        if (isOp(temp) && (opPrior(cur) <= opPrior(temp))) {     // если последний элемент стэка - операция с приорететом больше или равным, чем у новой
                            output += " " + temp;
                            stack = stack.substring(0, stack.length()-1);
                        } else {
                            break;
                        }
                    }
                }
                if(output.length() != 0)output += " ";
                stack += cur;
            } else if (cur == '(') {
                Un = true;
                stack += '(';
            } else if (cur == ')') {
                Un = false;
                int j = stack.length() - 1;
                while (stack.charAt(j) != '('){
                    output += " " + stack.charAt(j);
                    stack = stack.substring(0, j) + stack.substring(j + 1);
                    j--;
                }
                stack = stack.substring(0, j) + stack.substring(j + 1); // вырезаем саму скобку
            } else {
                if (stack.length() > 0){
                    if (stack.charAt(stack.length() - 1) == '-' && Un) {
                        output += '-';
                        output += cur;
                        stack = stack.substring(0, stack.length()-1);
                    }
                    else output += cur;
                }
                else output += cur;
                Un = false;
            }
        }
        while (stack.length() > 0) {
            output += " " + stack.substring(stack.length()-1);
            stack = stack.substring(0, stack.length()-1);
        }
        buf = output;
    }

    private static void calc() throws Exception{
        double fst = 0, sec = 0;
        String temp;
        Stack<Double> stack = new Stack <Double>();
        StringTokenizer st = new StringTokenizer(buf);
        while(st.hasMoreTokens()) {
            try {
                temp = st.nextToken().trim();
                if (temp.length() == 1 && isOp(temp.charAt(0))) {
                    if (stack.size() < 2) {
                        throw new Exception("Неверное количество данных в стеке для операции " + temp);
                    }
                    fst = stack.pop();
                    sec = stack.pop();
                    switch (temp.charAt(0)) {
                        case '+':
                            fst += sec;
                            break;
                        case '-':
                            fst = sec - fst;
                            break;
                        case '/':
                            fst = sec / fst;
                            break;
                        case '*':
                            fst *= sec;
                    }
                    stack.push(fst);
                } else {
                    fst = Double.parseDouble(temp);
                    stack.push(fst);
                }
            } catch (Exception e) {
                throw new Exception("Недопустимый символ в выражении");
            }
        }
        if (stack.size() > 1) {
            throw new Exception("Количество операторов не соответствует количеству операндов");
        }
        double result = stack.pop();
        if (result/(int)result == 1)
        {
            int Intresult = (int)result;
            buf = String.valueOf(Intresult);
        }
        else if (result == 0) buf = "0";
        else buf = String.valueOf(result);
    }

    //////////////////////////////////////////////////// вспомогательные методы

    private static boolean isOp(char c) {
        switch (c) {
            case '-':
            case '+':
            case '*':
            case '/':
            case '^':
                return true;
        }
        return false;
    }
    private static byte opPrior(char op) {
        // приорететы операций, унарный минус - наибольший
        if (op == '-' && Un) return 3;
        switch (op) {
            case '*':
            case '/':
                return 2;
        }
        return 1; // Тут остается + и -
    }

    //////////////////////////////////////////////////// методы для контроля оформления

    private static boolean OpLast(char ch){
        switch (ch){
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
            default:
                return false;
        }
    }

    private static boolean DotLast(char ch){
        if (ch == '.') return true;
        return false;
    }

    private static boolean RBracketLast(char ch){
        if (ch == ')') return true;
        return false;
    }

    private static boolean LBracketLast(char ch){
        if (ch == '(') return true;
        return false;
    }

    private static boolean ValLast(char ch){
        switch (ch){
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return true;
            default:
                return false;
        }
    }
}
