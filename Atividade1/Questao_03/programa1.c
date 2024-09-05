#include<stdio.h>
#include<stdlib.h>

struct tipo {
    int qntMor, consumoTotal, consumopMor;
};

void troca(struct tipo* a, struct tipo* b) {
    struct tipo c;
    c = *a;
    *a = *b;
    *b = c;
}

void ordena(struct tipo a[], int b) {
    int c, d, e;
    double f;
    for (c = 0; c < b; c++) {
        f = a[c].consumopMor;
        e = c;
        for (d = 0; d < (b - 1); d++) {
            if (a[d].consumopMor > f) {
                f = a[d].consumopMor;
                e = d;
                troca(&a[c], &a[e]);
            }
        }
    }
}

int main() {
    struct tipo * v;
    struct tipo aux;
    int i, j, k, n, x = 1;
    double totalMor, totalConsumo, consumoMedio;
    scanf("%d", &n);
    while (n != 0) {
        totalMor = 0;
        totalConsumo = 0;
        consumoMedio = 0;
        v = (struct tipo * )malloc(sizeof(struct tipo) * n);
        if (v == 0) {
            exit(1);
        }
        for (i = 0; i < n; i++) {
            scanf("%d%d", &v[i].qntMor, &v[i].consumoTotal);
            v[i].consumopMor = v[i].consumoTotal / v[i].qntMor;
            totalMor += v[i].qntMor;
            totalConsumo += v[i].consumoTotal;
        }
        for (i = 0; i < n - 1; i++) {
            for (j = i + 1; j < n; j++) {
                if (v[i].consumopMor == v[j].consumopMor) {
                    v[i].qntMor += v[j].qntMor;
                    for (k = j; k < n; k++) {
                        v[k].consumopMor = v[k + 1].consumopMor;
                        v[k].consumoTotal = v[k + 1].consumoTotal;
                        v[k].qntMor = v[k + 1].qntMor;
                    }
                    n--;
                    j--;
                }
            }
        }
        consumoMedio = totalConsumo / totalMor;
        ordena(v, n);
        printf("\n");
        printf("Cidade# %d:\n", x);
        for (i = 0; i < n; i++) {
            printf("%d-%d ", v[i].qntMor, v[i].consumopMor);
        }
        printf("\nConsumo medio: %.2lf m3.\n", consumoMedio);
        x++;
        free(v);
        scanf("%d", &n);
    }
}