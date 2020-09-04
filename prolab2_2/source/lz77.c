#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>


#define OFFSETBITS 5
#define LENGTHBITS (8 - OFFSETBITS)

#define OFFSETMASK ((1 << (OFFSETBITS))-1)
#define LENGTHMASK ((1 << (LENGTHBITS))-1)

#define GETOFFSET(x) (x >> LENGTHBITS)
#define GETLENGTH(x) (x & LENGTHMASK)

#define OFFSETLENGTH(x,y) (x << LENGTHBITS | y)

struct token {
    uint8_t offset_len;
    char c;
};

int eslesenUzunluk(char *s1, char *s2, int boyut)
{
    int boy = 0;

    while (*s1++ == *s2++ && boy<boyut)
        boy++;

    return boy;
}


struct token *LZ77(char *metin, int boyut, int *tokenSayisi)
{

    int yer = 1 << 3;

    int _tokenSayisi = 0;

    struct token t;

    char *ileri, *ara;

    struct token *sifrele = malloc(yer * sizeof(struct token));

    for (ileri = metin; ileri < metin + boyut; ileri++)
    {

        ara = ileri - OFFSETMASK;

        if (ara < metin)
            ara = metin;

        int max_len = 0;

        char *max_match = ileri;

        for (; ara < ileri; ara++)
        {
            int len = eslesenUzunluk(ara, ileri,LENGTHMASK);

            if (len > max_len)
            {
                max_len = len;
                max_match = ara;
            }
        }

        if (ileri + max_len >= metin + boyut)
        {
            max_len = metin + boyut - ileri - 1;
        }

        t.offset_len = OFFSETLENGTH(ileri - max_match, max_len);
        ileri += max_len;
        t.c = *ileri;

        if (_tokenSayisi + 1 > yer)
        {
            yer = yer << 1;
            sifrele = realloc(sifrele, yer * sizeof(struct token));
        }

        sifrele[_tokenSayisi++] = t;
    }

    if (tokenSayisi)
        *tokenSayisi = _tokenSayisi;

    return sifrele;
}


char *file_read(FILE *f, int *size)
{
    char *content;
    fseek(f, 0, SEEK_END);
    *size = ftell(f);
    content = malloc(*size);
    fseek(f, 0, SEEK_SET);
    fread(content, 1, *size, f);
    return content;
}

void ekranaYaz(int tokenSayisi, struct token *sifrele){
    for(int i=0; i<tokenSayisi;i++){
            int offset = GETOFFSET(sifrele[i].offset_len);
            int len = GETLENGTH(sifrele[i].offset_len);
            char c = sifrele[i].c;
            printf("<%d,%d,%c> \n",offset,len,c);
        }
}

void lz77_Main(char *okunacakDosya){

    FILE *f;
    char ch;
    int metin_boyutu, token_sayisi, decode_boyutu;
    char *kaynak_metin = "";
    struct token *sifrele_metin;

    if (f = fopen(okunacakDosya, "rb"))
    {
        kaynak_metin = file_read(f, &metin_boyutu);
        fclose(f);
    }

    sifrele_metin = LZ77(kaynak_metin, metin_boyutu, &token_sayisi);
    if(strcmp(okunacakDosya, "kaynak.txt") == 0)
        ekranaYaz(token_sayisi,sifrele_metin);

    if (strcmp(okunacakDosya, "kaynak.txt") == 0){
        if (f = fopen("lz77.txt", "wb"))
        {
            fwrite(sifrele_metin, sizeof(struct token), token_sayisi, f);
            fclose(f);
        }
    }



    if (strcmp(okunacakDosya, "trash.txt") == 0){
        if (f = fopen("deflate.txt", "wb"))
        {
            fwrite(sifrele_metin, sizeof(struct token), token_sayisi, f);
            fclose(f);
        }
        remove("trash.txt");
    }



}


