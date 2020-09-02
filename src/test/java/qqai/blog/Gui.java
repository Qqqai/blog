package qqai.blog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 描述：
 *
 * @author qqai
 * @createTime 2020-08-26 16:03
 */

public class Gui extends JFrame implements ActionListener {
    JPanel panel1 = new JPanel(new BorderLayout());
    JPanel panel2 = new JPanel(new GridLayout(5, 9));
    JPanel panel3 = new JPanel(new FlowLayout());
    JTextField inputN = new JTextField(12);
    JTextField inputSleep = new JTextField(12);
    JTextField[] field = new JTextField[50];
    JPanel panel4 = new JPanel();

    int timerCount = 0;
    int stopThreadTab = 0;

    public Gui() {
        initPanel1();
        initPanel2();
        initPanel3();
        this.setLayout(new BorderLayout());
        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.CENTER);
        this.add(panel3, BorderLayout.SOUTH);

        this.setSize(700, 350);
        this.setTitle(" 202190303-黄喻旭-大数据191");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initPanel3() {
        JLabel label = new JLabel("202190303-黄喻旭-大数据191");
        panel3.add(label);
    }

    private void initPanel2() {
        for (int i = 0; i < 50; i++) {
            field[i] = new JTextField(12);
            panel2.add(field[i]);
        }
    }

    private void initPanel1() {
        panel1 = new JPanel();
        JLabel label = new JLabel("数列项数");
        panel1.add(label);
        panel1.add(inputN);
        panel1.add(new JLabel("sleepTime:"));
        panel1.add(inputSleep);
        JButton button = new JButton("计算");
        panel1.add(button);
        JButton stop = new JButton("停止");
        panel1.add(stop);
        button.addActionListener(this);
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //终止输出数列线程的运行   异常法
                stopThreadTab = 2;
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = inputN.getText();
        String sleepText = inputSleep.getText();
        if (text != null) {
            int n = 0;
            long time = 0;
            try {
                n = Integer.parseInt(text);
                time = Long.parseLong(sleepText);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(panel4, "输入错误无法转换", "标题", JOptionPane.WARNING_MESSAGE);
                throw new RuntimeException("输入错误无法转换");
            }
            if (n < 0 || n > 50) {
                JOptionPane.showMessageDialog(panel4, "项数过大", "标题", JOptionPane.WARNING_MESSAGE);
                throw new RuntimeException("项数过大");
            }
            if (time < 0 || time > 300) {
                JOptionPane.showMessageDialog(panel4, "休眠时间不合适", "标题", JOptionPane.WARNING_MESSAGE);
                throw new RuntimeException("休眠时间不合适");
            }

            int[] fibonacci = fibonacci(n);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (stopThreadTab != 0) {
                        stopThreadTab = 0;
                        throw new RuntimeException("已停止输出");
                    }
                    field[timerCount].setText(String.valueOf(fibonacci[timerCount]));
                    timerCount++;
                }
            }, fibonacci.length - 1, time);
        }
    }

    private int[] fibonacci(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                a[0] = 0;
            } else if (i == 1) {
                a[1] = 1;
            } else {
                a[i] = a[i - 1] + a[i - 2];
            }
        }
        return a;
    }

    public static void main(String[] args) {
        new Gui();
    }


}
