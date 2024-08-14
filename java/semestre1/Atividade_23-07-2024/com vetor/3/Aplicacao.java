class Aplicacao {
    public static void main(String args[])
    {
        Cliente cliente1 = new Cliente("Lucas");
        Cliente cliente2 = new Cliente("Geovana");
        Cliente cliente3 = new Cliente("Eduarda");

        Produto maca = new Produto("Maçã", 2);
        Produto leite = new Produto("Leite", 4);
        Produto banana = new Produto("Banana", 3);

        Pedido meuPedido = new Pedido(cliente1, 10);

        ItemPedido itemA = new ItemPedido(maca, 2);
        ItemPedido itemB = new ItemPedido(banana, 4);

        meuPedido.adicionarItem(itemA);
        meuPedido.adicionarItem(itemB);

        System.out.println("Itens atuais: ");
        for(ItemPedido item : meuPedido.getItens())
        {
            if(item != null)
            {
                System.out.println(item.getProduto().getNome());
            }
        }
        System.out.println();
        
        System.out.println("O total atual é: " + meuPedido.calcularTotal());

        meuPedido.removerItem(itemB);
        System.out.println();
        System.out.println("A banana foi removida, o novo total é: " + meuPedido.calcularTotal());
    }
}
