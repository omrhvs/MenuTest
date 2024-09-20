import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaConPaneles extends JFrame {
    private JPanel headerPanel;
    private JPanel sidebarPanel;
    private JPanel mainPanel;

    private CardLayout cardLayout;
    private JPanel inicio;
    private JPanel inventario;

    public VentanaConPaneles() {
        // Crear paneles
        headerPanel = new JPanel();
        sidebarPanel = new JPanel();
        mainPanel = new JPanel();

        // Configurar colores para cada panel
        headerPanel.setBackground(Color.BLUE);
        sidebarPanel.setBackground(Color.GREEN);
        mainPanel.setBackground(Color.LIGHT_GRAY);

        // Configurar layout del JFrame
        setLayout(new BorderLayout());

        // Añadir paneles al JFrame
        add(headerPanel, BorderLayout.NORTH);
        add(sidebarPanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);

        // Configurar layout del panel principal
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        // Crear paneles para los diferentes menús
        inicio = new JPanel();
        inicio.setBackground(Color.YELLOW);
        inicio.add(new JLabel("Inicio"));

        inventario = new JPanel();
        inventario.setBackground(Color.ORANGE);
        inventario.add(new JLabel("Inventario"));

        // Añadir menús al panel principal
        mainPanel.add(inicio, "Inicio");
        mainPanel.add(inventario, "Inventario");

        // Configurar botones en la barra lateral (verticalmente)
        JButton mostrarInicio = new JButton("Inicio");
        JButton mostrarInventario = new JButton("Inventario");

        // Configurar layout de la barra lateral
        sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));

        // Agregar ActionListener para cambiar entre menús
        mostrarInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Menu1");
            }
        });

        mostrarInventario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Menu2");
            }
        });

        // Añadir botones a la barra lateral
        sidebarPanel.add(mostrarInicio);
        sidebarPanel.add(mostrarInventario);

        // Panel adicional a la derecha del encabezado
        JPanel extraPanel = new JPanel();
        extraPanel.setBackground(Color.RED);
        extraPanel.setLayout(new BorderLayout());

        // Botón de cerrar a la derecha del panel adicional
        JButton closeButton = new JButton("Cerrar");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Cierra la aplicación
            }
        });

        // Agregar JLabel al panel adicional
        JLabel extraLabel = new JLabel("Extra");
        extraPanel.add(extraLabel, BorderLayout.WEST);

        extraPanel.add(closeButton, BorderLayout.EAST);

        // Agregar panel adicional al encabezado
        headerPanel.setLayout(new BorderLayout());
        headerPanel.add(extraPanel, BorderLayout.EAST);

        // Agregar JLabel al encabezado
        JLabel headerLabel = new JLabel("Encabezado");
        headerPanel.add(headerLabel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaConPaneles ventana = new VentanaConPaneles();
                ventana.setVisible(true);
            }
        });
    }
}
