
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ClientGUI extends JFrame  implements ActionListener, Thread.UncaughtExceptionHandler {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JTextArea log = new JTextArea();
    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JCheckBox cbAlwaysOnTop = new JCheckBox("Always on top");
    private final JTextField tfLogin = new JTextField("ivan");
    private final JPasswordField tfPassword = new JPasswordField("123");
    private final JButton btnLogin = new JButton("Login");

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JButton btnDisconnect = new JButton("<html><b>Disconnect</b></html>");
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");

    private final JList<String> userList = new JList<>();

    private StringBuilder sb = new StringBuilder();
    private File logFile;


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientGUI();
            }
        });
    }

    private ClientGUI() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat Client");
        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        JScrollPane scrollUsers = new JScrollPane(userList);
        String[] users = {"user1", "user2", "user3", "user4", "user5", "User_with_a_very_long_name" };
        userList.setListData(users);
        scrollUsers.setPreferredSize(new Dimension(100, 0));

        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(cbAlwaysOnTop);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        panelBottom.add(btnDisconnect, BorderLayout.WEST);
        tfMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) updateLog(tfMessage.getText());
            }
        });
        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);

        cbAlwaysOnTop.addActionListener(this);
        btnSend.addActionListener(this);

        add(panelTop, BorderLayout.NORTH);
        add(panelBottom, BorderLayout.SOUTH);
        add(scrollLog, BorderLayout.CENTER);
        add(scrollUsers, BorderLayout.EAST);

//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                super.windowClosing(e);
//                saveFile(setChooser(e.getWindow()).getSelectedFile());
//            }
//        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                logFile = setChooser(e.getWindow()).getSelectedFile();
                loadFile(logFile);
            }
        });

        setVisible(true);
    }
    /*
        Отправлять сообщения в лог по нажатию кнопки или по нажатию клавиши Enter.
        Создать лог в файле (показать комментарием, где и как Вы планируете писать сообщение в файловый журнал).
        Прочитать методичку к следующему уроку

    * */
    @Override
    public void actionPerformed(ActionEvent e) {/*TODO*/
        Object src = e.getSource();
        if (src == cbAlwaysOnTop) {
            setAlwaysOnTop(cbAlwaysOnTop.isSelected());
        } else if(src == btnSend){
            String message = tfMessage.getText();
            updateLog(message);
        } else {
            throw new RuntimeException("Unknown source: " + src);
        }
    }

    private JFileChooser setChooser(Window window){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(window);
        return fileChooser;
    }

    private void saveMessage(File file, String mess){
        BufferedWriter writer = null;
        try{
            writer = new BufferedWriter(new FileWriter(file));
            sb.append('\n' + mess);
            writer.write(sb.toString());
            /*этот способ не очень эффективен, но в ДЗ говорилось, что нужно сохранять при отправке,
            * в общем, у меня получилось только так*/
//            writer.append(mess);
        } catch (IOException e){
            e.printStackTrace();
        }  finally {
        try{
            writer.close();
        } catch (IOException e){
            System.err.println("not able to close the writer");
            e.printStackTrace();
        }

    }
    }

    private void loadFile(File file){
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(file));
            while (true) {
                String string = reader.readLine();
                if (string == null) break;
                sb.append(string + '\n');
            }
            log.setText(sb.toString());
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                reader.close();
            } catch (IOException e){
                System.err.println("not able to close the reader");
                e.printStackTrace();
            }

        }
    }

    public void updateLog(String text){
        tfMessage.setText("");
        saveMessage(logFile, text);
        log.setText(sb.toString());
    }



    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        String msg;
        StackTraceElement[] ste = e.getStackTrace();
        if (ste.length == 0) {
            msg = "Empty Stacktrace";
        } else {
            msg = e.getClass().getCanonicalName() + ": " +
                    e.getMessage() + "\n\t at " + ste[0];
        }
        JOptionPane.showMessageDialog(this, msg, "Exception", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }


}

