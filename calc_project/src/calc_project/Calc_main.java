package calc_project;

public class Calc_main {

    public static void main(String[] args) {

        GUI gui = new GUI();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { gui.createAndShowGUI(); }
        });
    }

}