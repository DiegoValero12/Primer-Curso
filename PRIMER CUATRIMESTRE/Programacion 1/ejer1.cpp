#include <iostream>
using namespace std;

int pares (int num, int pos) {
	int result;
	
	result=0;
	if (num > 0){
		if ((pos%2 == 0) && ((num%10)%2 == 0))
			result = 1 + pares (num/10, pos+1);
		else result = 0 + pares (num/10, pos+1);
	}
	return(result);
}

int main() {
	int num, pos;
	
	do {
		cout << "Introduce un numero : ";
		cin >> num;
	} while (num<=0);
	cout << "numeros pares en posicion par : " << pares(num,1) << endl;
	
} 
	
		
	
