
#include <iostream.h>

using namespace std;

char validarCodigo (int socio, int clave){
   
   int resto, num, posclave;
   char valido;
   
   valido = 'n';
	num = socio;
	posclave = 0;
	
   while (num>0) {
   	resto = num % 10;
      if (resto%2 != 0)
      	posclave = posclave + 8 * resto;
      else
      	posclave = posclave + 5 * resto;
      num = num/10;
   }
   
   if (posclave == clave)
      valido = 's';
   
   return(valido);
}
   

main() {
   
   int nsocio, nclave;
   
   cout << "Introduce tu número de socio ";
   cin >> nsocio;
   cout << "Introduce tu clave ";
   cin >> nclave;
   
   cout << "¿Puedes entrar ? ";
   if (validarCodigo(nsocio, nclave)=='s')
     cout << "SI" << endl;
   else cout << "NO" << endl;
  
}

