import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class MainWindow extends JFrame implements ActionListener
{

    //Lista kont które znajdują się na Instagramie:
    //uzytkownik, haslo
    static Map<String, String> lista = new HashMap<>();

    JLabel zdj1 = new JLabel("");

    JLabel zdj2 = new JLabel("");

    //Image correct = new ImageIcon(this.getClass().getResource("correct.jpg")).getImage();

    ImageIcon correct = new ImageIcon("correct.png");

    ImageIcon incorrect = new ImageIcon("incorrect.png");
    JTextField uzytkownik = new JTextField();

    JLabel napisLabel = new JLabel("LOGOWANIE");

    JLabel poprawnie = new JLabel("ZALOGOWANO POPRAWNIE");

    JLabel niepop = new JLabel("POLA REJESTRACJI NIE MOGĄ BYĆ PUSTE");

    JLabel rej = new JLabel("REJESTRACJA");

    JLabel rejPop = new JLabel("ZAREJESTROWANO POPRAWNIE");

    JLabel log2 = new JLabel("TAKI UŻYTKOWNIK NIE ISTNIEJE!");

    JLabel log3 = new JLabel("NIEPOPRAWNE HASŁO");

    JLabel uzytkownikLabel = new JLabel("Użytkownik");

    JLabel hasloLabel = new JLabel("Hasło");

    JPasswordField haslo = new JPasswordField();

    JButton log = new JButton("ZALOGUJ");

    JButton reg = new JButton("ZAREJESTRUJ SIĘ");

    JButton back = new JButton("POWRÓT");
    JButton ok = new JButton("OK");

    public MainWindow() throws HeadlessException
    {
        this("undefined");
    }

    //Metoda która uzupełnia bazę użytkowników
    public void baza()
    {
        lista.put("kyliejenner","LoveStormi02");
        lista.put("slaskwroclaw","Handball88!");
        lista.put("gotuj_z_beata","Naleśniki<3");
        lista.put("swiatNews","NaBieżąco11");
        lista.put("makeupbyariel","LoveMyselfXoXo");
        lista.put("GIGAS", "Torirka123");
    }

    //Metoda pobiera wprowadzoną nazwę użytkownika
    public String getUzytkownik()
    {
        return uzytkownik.getText();
    }

    //Metoda pobiera wprowadzone hasło
    public String getHaslo()
    {
        String password = "";
        char[] pass = haslo.getPassword();
        for(int i=0; i<pass.length; i++)
        {
            password = password + pass[i];
        }
        return password;
    }

    public void usun()
    {
        this.remove(rej);
        this.remove(zdj1);
        this.remove(niepop);
        this.remove(rejPop);
        this.remove(zdj2);
        this.remove(poprawnie);
        this.remove(log2);
        this.remove(log3);
    }

    public void logowanie()
    {
        usun();
        napisLabel.setBounds(250,10, 500,200);
        this.add(napisLabel);

        //Jeżeli na liście znajduje się ta nazwa użytkownika
        if(lista.containsKey(getUzytkownik()))
        {
            //Sprawdź, czy hasło jest prawidłowe
            if(lista.containsValue(getHaslo()))
            {
                //Podane hasło jest prawidłowe - LOGOWANIE UDANE
                //JOptionPane.showMessageDialog(null, chuj);
                setSize(640,480);
                setResizable(false);
                //setLayout(null);
                //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                zdj1.setIcon(correct);
                zdj1.setBounds(30, 20, 64,64);
                this.add(zdj1);
                this.remove(napisLabel);
                poprawnie.setBounds(250,10, 500,200);
                this.add(poprawnie);

            }
            else
            {
                //Hasło nieprawidłowe - INFORMACJA O BŁĘDZIE
                setSize(640,480);
                setResizable(false);
                this.remove(napisLabel);
                log3.setBounds(250,10, 500,200);
                this.add(log3);
                zdj2.setIcon(incorrect);
                zdj2.setBounds(30, 20, 64,64);
                this.add(zdj2);
            }
        }
        else
        {
            //WYŚWIETLENIE INFORMACJI O BŁĘDZIE - NIE MA TAKIEGO UŻYTKOWNIKA
            setSize(640,480);
            setResizable(false);
            this.remove(napisLabel);
            log2.setBounds(250,10, 500,200);
            this.add(log2);
            zdj2.setIcon(incorrect);
            zdj2.setBounds(30, 20, 64,64);
            this.add(zdj2);
        }
    }

    public void rejestracja()
    {
        setSize(640,480);
        setResizable(false);
        usun();
        this.remove(napisLabel);
        this.remove(log);
        this.remove(reg);
        rej.setBounds(250,10, 500,200);
        this.add(rej);
        ok.setBounds(350,300,100,20);
        this.add(ok);
        ok.addActionListener(this);
        back.setBounds(470, 300, 100, 20);
        back.addActionListener(this);
        this.add(back);
    }

    public void powrot()
    {
        setSize(640,480);
        setResizable(false);
        usun();
        this.remove(back);
        this.remove(ok);
        newPanel();
    }

    public void dobrze()
    {
        lista.put(getUzytkownik(), getHaslo());
        setSize(640,480);
        setResizable(false);
        if(getUzytkownik() != null)
        {
            this.remove(rej);
            zdj1.setIcon(correct);
            zdj1.setBounds(30, 20, 64,64);
            this.add(zdj1);
            rejPop.setBounds(250,10, 500,200);
            this.add(rejPop);
        }
        else
        {
            this.remove(rej);
            zdj2.setIcon(incorrect);
            zdj2.setBounds(30, 20, 64,64);
            this.add(zdj2);
            niepop.setBounds(250,10, 500,200);
            this.add(niepop);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == log) //Jeżeli jest kliknięty guzik log
        {
            logowanie();
        }
        if(e.getSource() == reg) //Jeżeli jest kliknięty guzik rejestracji
        {
            rejestracja();
        }
        if(e.getSource() == back)
        {
            powrot();
        }
        if(e.getSource() == ok)
        {
            dobrze();
        }
    }

    public void newPanel()
    {
        setSize(640,480);
        setResizable(false);
        setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //program ma się zakończyć po zamknięciu tego okna

        //Metoda setBouds- metoda w ktorej podajemy wspołrzędne umieszczenia
        //na ekranie- ułożenie komponentu
        napisLabel.setBounds(250,10, 500,200);
        this.add(napisLabel);
        uzytkownikLabel.setBounds(150,150,200,20);
        hasloLabel.setBounds(150,200, 200,20);
        uzytkownik.setBounds(250,150,200,20);
        //uzytkownik.addActionListener(this);
        haslo.setBounds(250, 200, 200,20);
        log.setBounds(350,300, 100,20);
        log.addActionListener(this);
        reg.setBounds(150,300, 175 ,20);
        reg.addActionListener(this);
        this.add(uzytkownikLabel);
        this.add(hasloLabel);
        this.add(uzytkownik);
        this.add(haslo);
        this.add(log);
        this.add(reg);
    }

    //Kostruktor MainWindow - tworzenie nazwy okienka
    public MainWindow(String title) throws HeadlessException
    {
        super(title);
        baza();
        newPanel();
    }

    public static void main(String[] args)
    {

        try {
            MainWindow window = new MainWindow("INSTAGRAM");
            window.setVisible(true); //Funkcja która wyświetla okienko
            //window.pack();
            window.setIconImage(new ImageIcon("instagram.jpg").getImage());
        }
        catch (Exception e)
        {
            e.printStackTrace(System.err);
        }
    }
}