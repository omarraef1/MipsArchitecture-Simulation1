/* Simulates a physical device that performs (signed) addition on
 * a 32-bit input.
 *
 * Author: OMAR R. GEBRIL
 */

public class Sim1_ADD
{
	public void execute()
	{
		// TODO: fill this in!

		//these loops use two xor arrays
		// since each one executes once
		// and we need to do that for both a
		// and b
		// then it does case checkings for
		// carryouts
		// and keeps track of them
		// in the end calculates overflow
		boolean check = false;
		for (int i=0; i<32; i++) {
			xor[i].a.set(a[i].get());
			xor[i].b.set(b[i].get());
			xor[i].execute();
			
			xor2[i].a.set(xor[i].out.get());
			xor2[i].b.set(check);
			xor2[i].execute();
			
			sum[i].set(xor2[i].out.get());
			
			if(check==false) {
				if(a[i].get()==false || b[i].get()==false) {
					check = false;
				}
				else {
					check = true;
				}
			}
			else {
				if(a[i].get()==true || b[i].get()==true) {
					check = true;
				}
				else {
					check = false;
				}
			}
			
		}
		if (check == true) {
			overflow.set(true);
		}
		carryOut.set(check);
	}



	// ------ 
	// It should not be necessary to change anything below this line,
	// although I'm not making a formal requirement that you cannot.
	// ------ 

	// inputs
	public RussWire[] a,b;

	// outputs
	public RussWire[] sum;
	public RussWire   carryOut, overflow;

	private Sim1_XOR[] xor;
	private Sim1_XOR[] xor2;

	public Sim1_ADD()
	{
		/* Instructor's Note:
		 *
		 * In Java, to allocate an array of objects, you need two
		 * steps: you first allocate the array (which is full of null
		 * references), and then a loop which allocates a whole bunch
		 * of individual objects (one at a time), and stores those
		 * objects into the slots of the array.
		 */

		a   = new RussWire[32];
		b   = new RussWire[32];
		sum = new RussWire[32];

		xor = new Sim1_XOR[32];
		xor2 = new Sim1_XOR[32];
		
		for (int i=0; i<32; i++)
		{
			a  [i] = new RussWire();
			b  [i] = new RussWire();
			sum[i] = new RussWire();
			
			xor [i] = new Sim1_XOR();
			xor2 [i] = new Sim1_XOR();
			
		}

		carryOut = new RussWire();
		overflow = new RussWire();
	}
}

