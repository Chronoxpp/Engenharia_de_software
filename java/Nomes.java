import javax.swing.*;

public class Nomes
{
    public static void main(String[] arsgs)
    {
        String nome = JOptionPane.showInputDialog(null,"Informe seu nome completo:");
        String mensagemFinal;

        mensagemFinal = "Seu nome é:   "+nome+"\n\n";
        mensagemFinal = mensagemFinal + "Seu nome grande é:   "+nome.toUpperCase()+"\n";
        mensagemFinal = mensagemFinal + "Seu nome pequeno é:   "+nome.toLowerCase()+"\n";
        mensagemFinal = mensagemFinal + "\"  \" > \"_\":   "+nome.replaceAll(" ", "_")+"\n";
        mensagemFinal = mensagemFinal + "Seu nome tem "+(nome.replaceAll(" ","")).length()+" letras"+"\n";
        mensagemFinal = mensagemFinal + "A primeira letra do seu nome é:   "+nome.replaceAll(" ","").charAt(0)+"\n";
        mensagemFinal = mensagemFinal + "A ultima letra do seu nome é:   "+nome.replaceAll(" ","").charAt((nome.replaceAll(" ","")).length() - 1)+"\n";
        mensagemFinal = mensagemFinal + "Seu primeiro nome é:   "



        JOptionPane.showMessageDialog(null,mensagemFinal);
        // 1- mostrar nome
        // 2- converter para upper
        // 3- converter para lower
        // 4- substituir espaco por _
        // 5- contatar quantidade de carateres
        // 6- falar primeira letra
        // 7- falar ultima letra
        // 8- falar primeiro nome
        // 9- falar ultimo sobrenome
        System.exit(0);
    }
}