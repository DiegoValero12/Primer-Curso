#include <iostream>
using namespace std;

const int kmax=2;
const int kver=3;

typedef char Tcadena [20];

typedef struct{
  int dia, mes, anyo;
}Tfecha;

typedef struct{
	int fabricante;
	char material; //material R o P
	Tfecha fechaFab;
	float precio;
	int codigoVersion;
}Tversion;

typedef struct {
	Tcadena modelo;
	int anyo;
	int codigoModelo;
	char tipo;  //tipo maqueta M, F o C
	Tversion version[kver];
} Tmaqueta;

typedef Tmaqueta Tcoleccion[kmax];

void antiguo (Tcoleccion col) {
	int menor, i, j, modelo, version;
	
	menor=2013;
	for (i=0; i<kmax; i++)
		for (j=0; j<kver; j++)
			if (col[i].version[j].fechaFab.anyo < menor){
				modelo=i;
				version=j;
				menor=col[i].version[j].fechaFab.anyo;
			}
cout << "El modelo más antiguo fabricado es : " << col[modelo].modelo << endl;
cout << "Se fabricó en el año : " << col[modelo].version[version].fechaFab.anyo << endl;
cout << "Su precio fue de : " << col[modelo].version[version].precio << endl;
}

void versiones (Tcadena modelo, Tcoleccion col) {
	int i, j, tipo;
	
	i=0;
	while (i<kmax && strcmp(col[i].modelo,modelo)==0 )
		i++;
   tipo = col[i].tipo;
	   
	for (i=0; i<kmax; i++)
	  if (col[i].tipo == tipo) 
	  		for (j=0; j<kver; j++)
				cout << col[i].version[j].codigoVersion << endl;;	 
}

int main() {

	Tcoleccion coleccion;
	Tcadena modelo;
	
	strcpy(coleccion[0].modelo, "tanque");
	coleccion[0].anyo= 1994;
	coleccion[0].codigoModelo= 12345;
	coleccion[0].tipo='M';
	coleccion[0].version[0].fabricante=12;
	coleccion[0].version[0].material= 'R';
	coleccion[0].version[0].fechaFab.dia= 12;
	coleccion[0].version[0].fechaFab.mes=2;
	coleccion[0].version[0].fechaFab.anyo=1996;
	coleccion[0].version[0].precio= 145.23;
	coleccion[0].version[0].codigoVersion=21;
	coleccion[0].version[1].fabricante=13;
	coleccion[0].version[1].material= 'R';
	coleccion[0].version[1].fechaFab.dia= 13;
	coleccion[0].version[1].fechaFab.mes=3;
	coleccion[0].version[1].fechaFab.anyo=1997;
	coleccion[0].version[1].precio= 185.23;
	coleccion[0].version[1].codigoVersion=22;
	coleccion[0].version[2].fabricante=14;
	coleccion[0].version[2].material= 'R';
	coleccion[0].version[2].fechaFab.dia= 14;
	coleccion[0].version[2].fechaFab.mes=4;
	coleccion[0].version[2].fechaFab.anyo=1998;
	coleccion[0].version[2].precio= 180.23;
	coleccion[0].version[2].codigoVersion=23;
	
	strcpy(coleccion[0].modelo, "carro");
	coleccion[1].anyo= 1964;
	coleccion[1].codigoModelo= 19875;
	coleccion[1].tipo='F';
	coleccion[1].version[0].fabricante=22;
	coleccion[1].version[0].material= 'R';
	coleccion[1].version[0].fechaFab.dia= 22;
	coleccion[1].version[0].fechaFab.mes=2;
	coleccion[1].version[0].fechaFab.anyo=1966;
	coleccion[1].version[0].precio= 145.23;
	coleccion[1].version[0].codigoVersion=31;
	coleccion[1].version[1].fabricante=23;
	coleccion[1].version[1].material= 'R';
	coleccion[1].version[1].fechaFab.dia= 23;
	coleccion[1].version[1].fechaFab.mes=3;
	coleccion[1].version[1].fechaFab.anyo=1967;
	coleccion[1].version[1].precio= 185.23;
	coleccion[1].version[1].codigoVersion=32;
	coleccion[1].version[2].fabricante=24;
	coleccion[1].version[2].material= 'R';
	coleccion[1].version[2].fechaFab.dia= 24;
	coleccion[1].version[2].fechaFab.mes=4;
	coleccion[1].version[2].fechaFab.anyo=1968;
	coleccion[1].version[2].precio= 180.23;
	coleccion[1].version[2].codigoVersion=33;
	/*coleccion[0].version[1]={12, 'R', {12, 2, 1993}, 145, 22};
	coleccion[0].version[0]={12, 'R', {12, 2, 1998}, 145, 23};
	coleccion[1]={"trailer", 1994, 12345, 'M', 12, 'R', 12, 2, 1982, 32, 13, 12, 'R', 12, 2, 1999, 25, 14, 12, 'R', 12, 2, 1995, 45, 15};
	*/
	//coleccion[0]={"tanque", 1994, 12345, 'M', {12, 'R', {12, 2, 1996}, 145, 21}, {12, 'R', {12, 2, 1993}, 145, 22}, 12, 'R', {12, 2, 1998}, 145, 23}};
	//coleccion[1]={"trailer", 1994, 12345, 'M', {12, 'R', {12, 2, 1982}, 32, 13}, {12, 'R', {12, 2, 1999}, 25, 14}, {12, 'R', {12, 2, 1995}, 45, 15}};
	
	antiguo (coleccion);
	
	cout << "Introduce un código de modelo : ";
	cin >> modelo;
	versiones (modelo, coleccion);
	
} 
	
		
	