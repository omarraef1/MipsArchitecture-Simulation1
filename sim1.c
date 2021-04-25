/* Implementation of a 32-bit adder in C.
 *
 * Author: Omar R. Gebril
 */


#include "sim1.h"



void execute_add(Sim1Data *obj)
{
	int x = obj->a;
	int y = obj->b;
	//obj->sum = x^y;
	while (y){
		int carry = x & y;
		x = x^y; //sum by XOR
		y = carry << 1;
	}
	int y2 = obj->b;
	int x2 = obj->a;
	//int z = 0;
	if(obj->isSubtraction == 1){

		while(y2 != 0){
			int borrow = (~x2) & y2;
			x2 = x2 ^ y2;
			y2 = borrow << 1;
		}
	}

	int carry = 0;
	if (obj->isSubtraction == 1){
		carry = 1;
	}
	if (obj->isSubtraction == 0){
		obj->sum = x;
	}
	else{
		obj->sum = x2;
	}
	int aa = (obj->a >> 31) & 0x1;
	int bb = (obj->b >> 31) & 0x1;
	if(aa==1){
		obj->aNonNeg = 0;
	}
	else {
		obj->aNonNeg = 1;
	}
	if(bb==1){
		obj->bNonNeg = 0;
	}
	else{
		obj->bNonNeg = 1;
	}

	//sumNonNeg
//	if(aa==0 && bb==0){
//		obj->sumNonNeg=0;
//	}


	//overflow
	int sumC = (obj->sum >> 31) & 0x1;
	if(sumC==0){
		obj->sumNonNeg = 1;
	}
	else{
		obj->sumNonNeg = 0;
	}

	if (obj->isSubtraction == 0){
		if(obj->aNonNeg == obj->bNonNeg && obj->sumNonNeg != obj->aNonNeg){
			obj->overflow = 1;
		}
		else{
			obj->overflow = 0;
		}
	}
	else{
		if(obj->aNonNeg != obj->bNonNeg && obj->sumNonNeg == obj->bNonNeg){
			obj->overflow = 1;
		}
		else{
			obj->overflow = 0;
		}
	}

	//carryOuts
	for (int i=1; i<32;i++){
		int a2 = (obj->a >> i) & 0x1;
		int b2 = (obj->b >> i) & 0x1;
		if (carry == 0){
			if(a2==0 || b2==0){
				carry = 0;
			}
			else{
				carry = 1;
			}
		}
		else {
			if (a2==1 || b2==1){
				carry = 1;
			}
			else{
				carry = 0;
			}
		}

	}

	// TODO: overflow

	obj->carryOut = carry;






	//hex for MSB: 80000000


}
