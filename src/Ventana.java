import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JComboBox cboMarca;
    private JTextField txtAnio;
    private JButton btnEncolar;
    private JButton btnDesencolar;
    private JTextArea txtListaAutos;
    private JLabel lblAutoAtendido;
    private ColaAutos listaAutos = new ColaAutos();

    public Ventana() {
        btnEncolar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //para coger el texto de un combox
                String marca = cboMarca.getSelectedItem().toString();
                int anio = Integer.parseInt(txtAnio.getText());
                listaAutos.encolar(new Auto(marca, anio));
                txtListaAutos.setText(listaAutos.listarTodos());
            }
        });
        btnDesencolar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Auto atendido = listaAutos.desencolar();
                    lblAutoAtendido.setText(atendido.toString() + "pagar $50");
                    txtListaAutos.setText(listaAutos.listarTodos());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setSize(600,500);
        frame.setVisible(true);
    }

}
