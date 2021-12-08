import javax.swing.*;
import java.awt.*;

public class Jogo {

    private String usuarioAtual = "X";
    private int jogadas = 0;
    private  JButton [] [] botoes = {
            { new JButton(), new JButton(),new JButton() },
            { new JButton(), new JButton(),new JButton() },
            { new JButton(), new JButton(),new JButton() }
    };


    public void show(){
        JFrame frame = new JFrame("Jogo da Velha");
        frame.setSize(500,500); // tamanho
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); //centralizando em tela

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        panel.setLayout(new GridLayout(3,3));
        panel.setPreferredSize(new Dimension(500,500));

        for(int i=0; i < 3; i++){
            for (int j=0; j < 3; j++){

                JButton botaoAtual =botoes[i][j];
                panel.add(botaoAtual);

               botaoAtual.addActionListener(e -> {
                    if(!botaoAtual.getText().equals("")) return;
                   botaoAtual.setText(usuarioAtual);
                   jogadas++;
                  boolean venceu = houveVencedor();
                  if(venceu){
                      JOptionPane.showMessageDialog(null, "O vencedor foi" + usuarioAtual);
                      reiniciarJogo();
                  }else{
                      if(jogadas == 9){
                          JOptionPane.showMessageDialog(null, "O jogo empatou");
                          reiniciarJogo();
                      }
                      usuarioAtual = (usuarioAtual.equals("X")) ? "O": "X";
                  }
                });


            }
        }

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private boolean houveVencedor(){
        String b00 = botoes[0][0].getText();
        String b01 = botoes[0][1].getText();
        String b02 = botoes[0][2].getText();

        String b10 = botoes[1][0].getText();
        String b11 = botoes[1][1].getText();
        String b12 = botoes[1][2].getText();

        String b20 = botoes[2][0].getText();
        String b21 = botoes[2][1].getText();
        String b22 = botoes[2][2].getText();

        //linha 1
        if(!b00.equals("") && b00.equals(b01) && b00.equals(b02)){
           return true;
        }
        //linha 2
        if(!b10.equals("") && b10.equals(b11) && b10.equals(b12)){
            return true;
        }
        //linha 3
        if(!b20.equals("") && b20.equals(b21) && b20.equals(b22)){
            return true;
        }

        //coluna 1
        if(!b00.equals("") && b00.equals(b10) && b00.equals(b20)){
            return true;
        }
        //coluna 2
        if(!b01.equals("") && b01.equals(b11) && b01.equals(b21)){
            return true;
        }
        //coluna 3
        if(!b02.equals("") && b02.equals(b12) && b02.equals(b22)){
            return true;
        }

        //diagonal 1
        if(!b00.equals("") && b00.equals(b11) && b00.equals(b22)){
            return true;
        }
        //diagonal 2
        if(!b02.equals("") && b02.equals(b11) && b02.equals(b20)){
            return true;
        }
        return false;
    }
    private void reiniciarJogo(){
        for(int i=0; i < 3; i++){
            for (int j=0; j < 3; j++){
            botoes[i][j].setText("");
            jogadas = 0;
            usuarioAtual = "X";
            }
        }
    }
}
