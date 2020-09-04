#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define len(x) ((int)log10(x)+1)


struct node{
    int deger;
    char karakter;
    struct node *sol,*sag;
};

typedef struct node Node;


int alfabeTekrar [27] = {81, 15, 28, 43, 128, 23, 20, 61, 71, 2, 1, 40, 24, 69, 76, 20, 1, 61, 64, 91, 28, 10, 24, 1, 20, 1, 130};


int kucukBul (Node *dizi[], int naber){
    int kucuk;
    int i = 0;

    while (dizi[i]->deger==-1)
        i++;
    kucuk=i;
    if (i==naber){
        i++;
        while (dizi[i]->deger==-1)
            i++;
        kucuk=i;
    }

    for (i=1;i<27;i++){
        if (dizi[i]->deger==-1)
            continue;
        if (i==naber)
            continue;
        if (dizi[i]->deger<dizi[kucuk]->deger)
            kucuk = i;
    }

    return kucuk;
}


void huffmanAgaci(Node **agac){
    Node *temp;
    Node *dizi[27];
    int i, altAgac = 27;
    int ufak1,ufak2;

    for (i=0;i<27;i++){
        dizi[i] = malloc(sizeof(Node));
        dizi[i]->deger = alfabeTekrar[i];
        dizi[i]->karakter = i;
        dizi[i]->sol = NULL;
        dizi[i]->sag = NULL;
    }

    while (altAgac>1){
        ufak1=kucukBul(dizi,-1);
        ufak2=kucukBul(dizi,ufak1);
        temp = dizi[ufak1];
        dizi[ufak1] = malloc(sizeof(Node));
        dizi[ufak1]->deger=temp->deger+dizi[ufak2]->deger;
        dizi[ufak1]->karakter=127;
        dizi[ufak1]->sol=dizi[ufak2];
        dizi[ufak1]->sag=temp;
        dizi[ufak2]->deger=-1;
        altAgac--;
    }

    *agac = dizi[ufak1];

return;
}


void kodlaDoldur(int kodla[], Node *agac, int Code){
    if (agac->karakter<27)
        kodla[(int)agac->karakter] = Code;
    else{
        kodlaDoldur(kodla, agac->sol, Code*10+1);
        kodlaDoldur(kodla, agac->sag, Code*10+2);
    }

    return;
}


void sifrele(FILE *input, FILE *output, int kodla[]){
    char bit, c, x = 0;
    int n,uzunluk,bitSol = 8;
    int originalBits = 0, sifrelenen = 0;

    while ((c=fgetc(input))!=10){
        originalBits++;
        if (c==32){
            uzunluk = len(kodla[26]);
            n = kodla[26];
        }
        else{
            uzunluk=len(kodla[c-97]);
            n = kodla[c-97];
        }

        while (uzunluk>0){
            sifrelenen++;
            bit = n % 10 - 1;
            n /= 10;
            x = x | bit;
            bitSol--;
            uzunluk--;
            if (bitSol==0){
                fputc(x,output);
                x = 0;
                bitSol = 8;
            }
            x = x << 1;
        }
    }

    if (bitSol!=8){
        x = x << (bitSol-1);
        fputc(x,output);
    }

    return;
}

void degistir(int kodla[],int kodla2[]){
    int i, n, kopya;

    for (i=0;i<27;i++){
        n = kodla[i];
        kopya = 0;
        while (n>0){
            kopya = kopya * 10 + n %10;
            n /= 10;
        }
        kodla2[i]=kopya;
    }

return;
}

void huffman_Main(){
                    Node *agac;
                int kodla[27], kodla2[27];

                FILE *input, *output;

                huffmanAgaci(&agac);

                kodlaDoldur(kodla, agac, 0);

                degistir(kodla,kodla2);

                input = fopen("kaynak.txt", "r");
                output = fopen("trash.txt","w");

                sifrele(input,output,kodla2);
                fclose(input);
                fclose(output);

                lz77_Main("trash.txt");

}
