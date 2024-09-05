class Aplicacao 
{
    public static void main(String args[])
    {
        Produto maca = new Produto("maçã", 2);
        Produto pera = new Produto("pera", 4);
        Produto banana = new Produto("banana", 6);

        Venda venda1 = new Venda(5);
        Venda venda2 = new Venda(5);

        venda1.adicionarProduto(banana);
        venda1.adicionarProduto(maca);

        venda2.adicionarProduto(pera);
        venda2.adicionarProduto(banana);

        Vendedor lucas = new Vendedor("Lucas", 5);

        lucas.registrarVenda(venda1);
        lucas.registrarVenda(venda2);

        System.out.println(lucas.calcularTotal());
    }
}
