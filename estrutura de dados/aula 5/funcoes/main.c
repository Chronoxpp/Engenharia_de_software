#include <stdio.h>
#include <stdlib.h>

void troca(int *a, int*b)
{
	int aux;
	aux = *a;
	*a = *b;
	*b = aux;
}

void dobro(int *c)
{
	*c = 2 * *c;
}

int main()
{
	int x=7, y=8;
	troca(&x, &y);
	printf("novo valor de x = %d e novo valor de y = %d \n", x, y);
	dobro(&x);
	printf("novo valor de x dobrado = %d \n", x);
	return 0;
}