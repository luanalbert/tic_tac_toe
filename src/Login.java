import javax.swing.*;

public class Login {
    public  void show(){
        JFrame frame = new JFrame("login");
        frame.setSize(300,160); // tamanho
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //conmportamento do botão de fechar
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null); // é o que me faz dizer onde cada componente do panel deve estar na tela

        JLabel usuarioLabel = new JLabel("Usuario");
        usuarioLabel.setBounds(10,20,80,25);

        JLabel senhaLabel = new JLabel("Senha");
        senhaLabel.setBounds(10,50,80,25);

        JTextField usuarioTextField = new JFormattedTextField("Senha");
        usuarioTextField.setBounds(80,20,160,25);

        JPasswordField senhaField = new JPasswordField();
        senhaField.setBounds(80,50,160,25);

        JButton entrarButton = new JButton("entrar");
        entrarButton.setBounds(80,80,100,25);
        entrarButton.addActionListener(e -> {
            String usuario = usuarioTextField.getText();
            String senha = String.valueOf( senhaField.getPassword());//getPassword vai retornar um array de caracteres e o que faço aqui é tranformar esse array em String por meio  do metodo valueOf()

            if(usuario.equals("admin") && senha.equals("admin")){
                Jogo jogo = new Jogo();
                jogo.show();
                frame.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Usuário ou senha iválidos!");
            }

        });

        panel.add(usuarioLabel);
        panel.add(senhaLabel);
        panel.add(usuarioTextField);
        panel.add(senhaField);
        panel.add(entrarButton);

        frame.add(panel);
        frame.getRootPane().setDefaultButton(entrarButton);
        frame.setVisible(true);
    }
}
