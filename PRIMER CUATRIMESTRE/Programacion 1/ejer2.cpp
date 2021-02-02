
#include <iostream>
#include <string.h>

using namespace std;

int buscapalabra (char palabra[], char matriz[][7]){
   int f, c, i, lon, encontrado;
   
   encontrado=-1;
   i=0;
   
   lon = strlen(palabra);
   cout << "longitud " << lon << endl;
   for (f=0; f<7 && (encontrado == -1 ); f++) {
      for (c=0; c<7; c++) {
         if ((palabra[i]==matriz[f][c]) && i<lon)
            i++;
         else if (lon!= i)
         			i=0;
      }
      if (i == lon)
         encontrado = f;
   }
   return(encontrado);
}

main() {
   
   char palabra[6]= {'h','o','l','a'};
   char matriz[7][7] = { 'a','l','c','o','y','s','t',
   						 'r','a','t','a','s','j','k',
   						 'e','l','e','f','a','n','t',
   						 'j','o','t','a','a','a','a', 
   						 'l','r','o','l','a','b','b', 
   						 'e','l','e','f','a','n','t', 
   						 'c','a','s','a','s','s','s'};
   
   int lugar;
   
   lugar = buscapalabra(palabra, matriz);
   cout << lugar << endl;
   
}

