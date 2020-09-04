#include <stdio.h>

long int findSize(char *dosyaAdi)
{
    // opening the file in read mode
    FILE* fp = fopen(dosyaAdi, "r");

    // checking if the file exist or not
    if (fp == NULL) {
        printf("Dosya yok!\n");
        return -1;
    }

    fseek(fp, 0L, SEEK_END);

    // calculating the size of the file
    long int boy = ftell(fp);

    // closing the file
    fclose(fp);

    return boy;
}

int main(){

	int x;

	while(1){
		printf("lz77 icin 1, deflate icin 2, programi sonlandirmak icin 3 girin.\n");
		scanf("%d",&x);
			if(x==1){

				lz77_Main("kaynak.txt");


			}
			if(x==2){

				huffman_Main();
			}
			if(x==3){

				break;
			}
	}

	long int lzBoy = findSize("lz77.txt");
	long int defBoy = findSize("deflate.txt");

	printf("lz77 ile þifrelenen dosyanin boyutu: %ld \n deflate ile þifrelenen dosyanin boyutu: %ld \n ",lzBoy, defBoy );

    getch();
	return 0;
}
