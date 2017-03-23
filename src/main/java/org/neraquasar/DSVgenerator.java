/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neraquasar;

import javax.swing.*;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 *
 * @author kd
 */
public class DSVgenerator
{

    static JFrame frameMain = new JFrame();

    static JPanel panelMain = new JPanel();

    static JScrollPane scroll = new JScrollPane(panelMain);

    static JPanel panel1 = new JPanel();

    static int fieldsN;

    static JTextField txtDelimiter = new JTextField();

    static JTextField txtFilepath = new JTextField();

    static JPanel panel2 = new JPanel();

    static JPanel panel3 = new JPanel();

    static DefaultTableModel dsvmodel = new DefaultTableModel(
            new String[]
            {

                "1", "2"
            }, 0);

    /**
     * Do all preparations on the start of runtime
     *
     * @throws Exception
     */
    static void initialize() throws Exception
    {
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.setSize(900, 800);
        frameMain.setLayout(new BorderLayout());

        initPanelMain();
        frameMain.add(scroll);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }

    static void initPanelMain()
    {
        panelMain.setVisible(true);
        GroupLayout layout = new GroupLayout(panelMain);
        panelMain.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        initPanel1();
        initPanel2(3);
        initPanel3();

        layout.setHorizontalGroup(
                layout.createParallelGroup()
                .addComponent(panel1)
                .addComponent(panel2)
                .addComponent(panel3));

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                .addComponent(panel1)
                .addComponent(panel2)
                .addComponent(panel3));
    }

    static void initPanel1()
    {
        panel1.setVisible(true);
        GroupLayout layout = new GroupLayout(panel1);
        panel1.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

//        SequentialGroup seqGroup = layout.createSequentialGroup();
//        ParallelGroup parGroup = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
//        layout.setHorizontalGroup(seqGroup);
//        layout.setVerticalGroup(parGroup);
        JLabel lblFilepath = new JLabel("Path to .txt (will be OVERWRITEN)");
        JLabel lblN = new JLabel("Number of fields");
        JTextField txtN = new JTextField();
        txtN.setText("3");
        JLabel lblDelimiter = new JLabel("Delimiter");
        txtDelimiter.setText(";");
        txtFilepath.setText("/Users/");
        JButton btnSetfields = new JButton("Set fields");

        btnSetfields.addActionListener(e
                ->
                {
                    fieldsN = Integer.parseInt(txtN.getText());
                    panel2.removeAll();
                    initPanel2(Integer.parseInt(txtN.getText()));
                    panelMain.repaint();
        });

        layout.setHorizontalGroup(
                layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFilepath)
                        .addComponent(txtFilepath))
                .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDelimiter)
                        .addComponent(txtDelimiter)
                        .addComponent(lblN)
                        .addComponent(txtN)
                        .addComponent(btnSetfields))
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFilepath)
                        .addComponent(txtFilepath))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDelimiter)
                        .addComponent(txtDelimiter)
                        .addComponent(lblN)
                        .addComponent(txtN)
                        .addComponent(btnSetfields))
        );

//        seqGroup.addComponent(lblFilepath);
//        parGroup.addComponent(lblFilepath);
//
//        seqGroup.addComponent(txtFilepath);
//        parGroup.addComponent(txtFilepath);
//
//        seqGroup.addComponent(lblDelimiter);
//        parGroup.addComponent(lblDelimiter);
//
//        seqGroup.addComponent(txtDelimiter);
//        parGroup.addComponent(txtDelimiter);
//
//        seqGroup.addComponent(lblN);
//        parGroup.addComponent(lblN);
//
//        seqGroup.addComponent(txtN);
//        parGroup.addComponent(txtN);
//
//        seqGroup.addComponent(btnSetfields);
//        parGroup.addComponent(btnSetfields);
    }

    static void initPanel2(int fieldsN)
    {
        panel2.setVisible(true);
        GroupLayout layout = new GroupLayout(panel2);
        panel2.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        SequentialGroup seqGroup = layout.createSequentialGroup();
        ParallelGroup parGroup = layout.createParallelGroup();
        layout.setHorizontalGroup(parGroup);
        layout.setVerticalGroup(seqGroup);

        JButton btnAddfield = new JButton("Generate");

        btnAddfield.addActionListener(e
                ->
                {
                    panel3.removeAll();
                    dsvmodel.addRow(new Object[]
                    {
                        genString(), "Удалить"
                    });

                    initPanel3();
                    panelMain.repaint();
        });

        for (int i = 0; i < fieldsN; i++)
        {
            JPanel add = addField();
            seqGroup.addComponent(add);
            parGroup.addComponent(add);
        }

        seqGroup.addComponent(btnAddfield);
        parGroup.addComponent(btnAddfield);
    }

    static JPanel addField()
    {
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel lbla = new JLabel("a");
        JLabel lblA = new JLabel("A");
        JLabel lbl1 = new JLabel("1");
        JLabel lbl_ = new JLabel("#");
        JLabel lblN = new JLabel("N");

        JCheckBox cbBoxa = new JCheckBox();
        JCheckBox cbBoxA = new JCheckBox();
        JCheckBox cbBox1 = new JCheckBox();
        JCheckBox cbBox_ = new JCheckBox();
        JTextField txtN = new JTextField();

        cbBoxa.setSelected(true);
        cbBoxA.setSelected(true);
        cbBox1.setSelected(true);
        cbBox_.setSelected(true);
        txtN.setText("10");

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                .addComponent(lbla)
                .addComponent(cbBoxa)
                .addComponent(lblA)
                .addComponent(cbBoxA)
                .addComponent(lbl1)
                .addComponent(cbBox1)
                .addComponent(lbl_)
                .addComponent(cbBox_)
                .addComponent(lblN)
                .addComponent(txtN));

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lbla)
                .addComponent(cbBoxa)
                .addComponent(lblA)
                .addComponent(cbBoxA)
                .addComponent(lbl1)
                .addComponent(cbBox1)
                .addComponent(lbl_)
                .addComponent(cbBox_)
                .addComponent(lblN)
                .addComponent(txtN));

        return panel;
    }

    static void initPanel3()
    {
        panel3.setVisible(true);
        GroupLayout layout = new GroupLayout(panel3);
        panel3.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        SequentialGroup seqGroup = layout.createSequentialGroup();
        ParallelGroup parGroup = layout.createParallelGroup();
        layout.setHorizontalGroup(parGroup);
        layout.setVerticalGroup(seqGroup);

        JTable table = new JTable(dsvmodel);
        table.getColumnModel().getColumn(1).setMaxWidth(100);
        Action delete = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                ((DefaultTableModel) table.getModel()).removeRow(modelRow);
            }

        };
        ButtonColumn buttonColumn = new ButtonColumn(table, delete, 1);
        buttonColumn.setMnemonic(KeyEvent.VK_D);

        seqGroup.addComponent(table);
        parGroup.addComponent(table);

        JButton fileout = new JButton("Create/Overwrite file");

        fileout.addActionListener(new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                List<String> listResult = new ArrayList<>();
                for (int i = 0; i < dsvmodel.getRowCount(); i++)
                    listResult.add(dsvmodel.getValueAt(i, 0).toString());
                write2file(listResult);
            }

        });

        seqGroup.addComponent(fileout);
        parGroup.addComponent(fileout);
    }

    static void write2file(List<String> listText)
    {
        if (txtFilepath.getText().length() < 5 || txtFilepath.getText() == null || !txtFilepath.getText().substring(txtFilepath.getText().length() - 4).equals(".txt"))
        {
            panel3.removeAll();
            dsvmodel.addRow(new Object[]
            {
                "----- FILE PATH MUST BE: c:\\*.txt , for example: c:\\users\\username\\1.txt or /Users/kd/1.txt-----", "Удалить"
            });
            initPanel3();
            panelMain.repaint();
            return;
        }
        //Определяем файл
        File file = new File(txtFilepath.getText());

        try
        {
            //проверяем, что если файл не существует то создаем его
            if (!file.exists())
                file.createNewFile();

            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try
            {
                //Записываем текст у файл
                for (String text : listText)
                    out.print(text + "\n");
            }
            finally
            {
                //После чего мы должны закрыть файл
                //Иначе файл не запишется
                out.close();
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    static String genString()
    {
        List<String> list = new ArrayList<>();
        List<Boolean> checks = new ArrayList<>();
        for (Component x : panel2.getComponents())
            if (x.getClass().equals(JPanel.class))
            {
                JPanel y = (JPanel) x;

                checks.clear();
                for (Component z : y.getComponents())
                {
                    if (z.getClass().equals(JCheckBox.class))
                    {
                        JCheckBox cb = (JCheckBox) z;
                        checks.add(cb.isSelected());
                    }
                    if (z.getClass().equals(JTextField.class))
                    {
                        JTextField txt = (JTextField) z;
                        fieldsN = Integer.parseInt(txt.getText());
                    }
                }
                if (fieldsN != 0 && checks.size() == 4)
                    list.add(checksToString(fieldsN, checks));
            }
        return list2string(list);
    }

    static String list2string(List<String> list)
    {
        StringBuilder w = new StringBuilder();
        String delimiter = txtDelimiter.getText();
        for (String x : list)
            w.append(x).append(delimiter);
        return cropLastDelimiter(w.toString(), delimiter);
    }

    static String checksToString(int fieldsN, List<Boolean> checks)
    {
        return getRandomstring(fieldsN, checks.get(0), checks.get(1), checks.get(2), checks.get(3));
    }

    public static void main(String[] args) throws Exception
    {
        initialize();
        frameMain.setVisible(true);
    }

    static String cropLastDelimiter(String s, String delimiter)
    {
        return (s != null
                && s.length() >= delimiter.length()
                && s.substring(s.length() - delimiter.length()).equals(delimiter))
                ? s.substring(0, s.length() - delimiter.length()) : s;
    }

    static String getEffective(boolean add_lettersMlat, boolean add_lettersBlat, boolean add_numbers, boolean add_spec)
    {
        String lettersMlat = "abcdefghijklmnopqrstuvwxyz";
        String lettersBlat = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String spec = "!`\"§$%&/()=?\\´+*#';:<>|{}[]";

        StringBuilder effective = new StringBuilder();
        if (add_lettersMlat)
            effective.append(lettersMlat);
        if (add_lettersBlat)
            effective.append(lettersBlat);
        if (add_numbers)
            effective.append(numbers);
        if (add_spec)
            effective.append(spec);
        if (effective.toString().length() == 0)
            throw new NullPointerException("no symbols in effective");

        return effective.toString();
    }

    static String getRandomstring(int n, boolean add_lettersMlat, boolean add_lettersBlat, boolean add_numbers, boolean add_spec)
    {
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        char[] chars = getEffective(add_lettersMlat, add_lettersBlat, add_numbers, add_spec).toCharArray();
        for (int i = 0; i < n; i++)
            result.append(chars[random.nextInt(chars.length - 1)]);

        return result.toString();
    }

}
