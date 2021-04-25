/* Simulates a physical device that performs 2's complement on a 32-bit input.
 *
 * Author: Omar R. Gebril
 */

public class Sim1_2sComplement
{
	public void execute()
	{
		// TODO: fill this in!
		//
		// REMEMBER: You may call execute() on sub-objects here, and
		//           copy values around - but you MUST NOT create
		//           objects while inside this function.

		// This for loop negates the binary digits
		// then stores it into temp array
		for (int i=0; i<32; i++) {
			not[i].in.set(in[i].get());
			not[i].execute();
			temp[i].set(not[i].out.get());
		}

		// This for loop creates a 32 bit array with only 1 in lsb
		// and 0's otherwise
		// to be used for addition later
		for (int i=0; i<32; i++) {
			add.a[i].set(temp[i].get());
			if (i>0) {
				add.b[i].set(false);
			}
		}
		add.b[0].set(true);
		add.execute();
		

		// This loop takes the output and puts it into the sum[] for output
		for (int i=0; i<32; i++) {
			out[i].set(add.sum[i].get());
		}
	}



	// you shouldn't change these standard variables...
	public RussWire[] in;
	public RussWire[] out;

	private RussWire[] temp;
	
	private Sim1_NOT[] not;
	private Sim1_ADD add;

	// TODO: add some more variables here.  You must create them
	//       during the constructor below.  REMEMBER: You're not
	//       allowed to create any object inside the execute()
	//       method above!


	public Sim1_2sComplement()
	{
		// TODO: this is where you create the objects that
		//       you declared up above.

		in = new RussWire[32];
		out = new RussWire[32];
		
		add = new Sim1_ADD();
		temp = new RussWire[32];
		not = new Sim1_NOT[32];
		
		for (int i = 0; i<32; i++) {
			in[i] = new RussWire();
			out[i] = new RussWire();
			
			not[i] = new Sim1_NOT();
			temp[i] = new RussWire();
		}
	}
}

