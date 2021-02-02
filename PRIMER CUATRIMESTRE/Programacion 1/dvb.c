#include <stdio.h>
#include <string.h>

#define MAX_NINO 50
#define MAX_NOMBRE 30
#define MAX_PUNTOS 5

// declaracion del registro Tnino
typedef struct {
	char nombre[MAX_NOMBRE];
	char ninyo;
	int puntuacion[MAX_PUNTOS];	
}Tnino;

//modulo de registro de un nuevpo niño

void nuevoNino (Tnino nino[], int *pos){
	printf("------------------------------------------------------------------------------\n");
	printf("Introduce el nombre del niño: ");
	scanf(" %[^\n]%*c", nino[*pos].nombre);
	do{
		printf("Introduce 'o' si es niño o 'a' si es niña: ");
		scanf(" %c", &nino[*pos].ninyo);
		if (nino[*pos].ninyo!='a' && nino[*pos].ninyo!='o')
			printf("Letra erronea.\n");
	}while(nino[*pos].ninyo!='a' && nino[*pos].ninyo!='o');
	(*pos)++;
}

//modulo de puntuacion de un niño

void puntuarNino (Tnino nino[], int pos, int num_puntuacion[]){
	char nombre[MAX_NOMBRE];
	int i;

	printf("------------------------------------------------------------------------------\n");
	printf("Introduce el nombre del niño: ");
	scanf(" %[^\n]%*c", nombre);
	for(i=0;i<pos;i++){
			if (strcmp(nombre, nino[i].nombre)!=0 && i!=pos)
				printf("Nombre no reconocido.\n");
			else
				if (strcmp(nombre, nino[i].nombre)==0){
					do{
						printf("Puntuacion %i (entre 1 y 10): ", (num_puntuacion[i])+1);
						scanf("%i", &nino[i].puntuacion[num_puntuacion[i]]);
						if (nino[i].puntuacion[num_puntuacion[i]]<1 || nino[i].puntuacion[num_puntuacion[i]]>10)
							printf("La puntuacion debe estar entre 1 y 10\n");
					}while(nino[i].puntuacion[num_puntuacion[i]]<1 || nino[i].puntuacion[num_puntuacion[i]]>10);
						num_puntuacion[i]++;
				}
	}
}



// modulo de listado de los niños

void listarNino (Tnino nino[], int pos, int num_puntuacion[]){
	int i, j, s;
	float promedio[MAX_NINO];

	for(s=0;s<MAX_NINO;s++){ 
		promedio[s]=0; // inicializar todas las puntuaciones promedias en 0
	}

	for(i=0;i<pos;i++){
		for(j=0;j<num_puntuacion[i];j++){
			promedio[i]=promedio[i]+nino[i].puntuacion[j];
		}
		if (num_puntuacion[i]>0)
			promedio[i]=promedio[i]/num_puntuacion[i];
		printf("------------------------------------------------------------------------------\n");
		printf("Niño numero %i. \n", i+1);
		printf("Nombre: %s\n", nino[i].nombre);
		switch (nino[i].ninyo){
			case 'a': printf("Sexo: Niña\n");
				break;
			case 'o': printf("Sexo: Niño\n");
				break;
		}
		printf("Puntuacion promedia: %f\n", promedio[i]); // cuando se introduce un niño sin puntuaciones, la puntuacion promedia sera 0
		if (promedio[i]>=5)
			printf("TRAER REGALOS.\n");
		else
			printf("CARBÓN.\n"); 
	}

}

int main (){
	int i;
	Tnino ninyo[MAX_NINO];
	int num_nino=0;
	int num_puntuacion[MAX_NINO];
	int opcion;

	for(i=0;i<MAX_NINO;i++){
		num_puntuacion[i]=0;
	}

	do{
		printf("------------------------------------------------------------------------------\n");
		printf("1. Introducir los datos de un niño. \n");
		printf("2. Puntuar a un niño. \n");
		printf("3. Listar a los niños. \n");
		printf("4. Salir. \n");
		printf("Opcion: ");
		scanf("%i", &opcion);
		switch (opcion){
			case 1: nuevoNino(ninyo, &num_nino);
				break;
			case 2: puntuarNino(ninyo, num_nino, num_puntuacion);
				break;
			case 3: listarNino(ninyo, num_nino, num_puntuacion);
				break;
			case 4:	printf("Saliendo...\n");
				break;
		}
	}while(opcion!=4);





}
