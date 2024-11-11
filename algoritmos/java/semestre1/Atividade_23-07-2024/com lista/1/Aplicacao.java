import javax.swing.JOptionPane;

public class Aplicacao 
{
    public static void main(String[] args)
    {
        JOptionPane.showMessageDialog(null, "Empresa, departamentos e funcionarios");

        Empresa empresa = new Empresa(JOptionPane.showInputDialog("Insira o nome da sua empresa:"));


        Departamento depa1 = new Departamento(JOptionPane.showInputDialog("Insira um nome para o departamento 1:"));
        empresa.adicionarDepartamento(depa1);

        Funcionario func1 = new Funcionario(JOptionPane.showInputDialog("Insira o nome do funcionario 1:"), 1);
        depa1.adicionarFuncionario(func1);
        Funcionario func2 = new Funcionario(JOptionPane.showInputDialog("Insira o nome do funcionario 2:"), 2);
        depa1.adicionarFuncionario(func2);
        

        Departamento depa2 = new Departamento(JOptionPane.showInputDialog("Insira o nome do departamento 2:"));
        empresa.adicionarDepartamento(depa2);
        
        Funcionario func3 = new Funcionario(JOptionPane.showInputDialog("Insira o nome do funcionario 3:"), 3);
        depa2.adicionarFuncionario(func3);


        String msg;
        for (Departamento departamento : empresa.getDepartamentos()) 
        {
            msg = "Departamento: " + departamento.getNome() + "\n";
            msg = msg + "Funcionarios: \n";

            for(Funcionario funcionario : departamento.getfuncionarios())
            {
                msg = msg + funcionario.getNome() + "\n";
            }
            JOptionPane.showMessageDialog(null, msg);
        }
    }
}
