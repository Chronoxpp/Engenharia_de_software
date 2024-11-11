#include <stdio.h>
#include <stdlib.h>
#define pi 31.14

int main()
{
    int x,y;
    double z;

    char c[50] = "Dev: Lucas Dourado Rodrigues";
    printf("%s %s", c, "\n\n");

    printf("Digite o valor de x ");
    scanf("%d", &x);
    printf("%d \n", x);

    printf("Digite o valor de z ");
    scanf("%f", &z);
    printf("%f \n", z);

    printf("Digite o valor de x e z ");
    scanf("%d%f", &x, &z);
    printf("%d%f \n",x,z);

    printf("Digite o valor de x e Y ");
    scanf("%d%d", &x, &y);
    printf("%d%d \n", x,y);

    printf("Digite o valor de x e Y (com espaco) ");
    scanf("%d%d", &x, &y);
    printf("%d%d \n",x,y);

    //comentario

    system("pause");
    return 0;
}
