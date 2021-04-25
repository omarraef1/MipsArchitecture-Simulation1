/* Simulates a physical device that performs (signed) subtraction on
 * a 32-bit input.
 *
 * Author: Omar R. Gebril
 */

public class Sim1_SUB
{
	public void execute()
	{
		// TODO: fill this in!
		//
		// REMEMBER: You may call execute() on sub-objects here, and
		//           copy values around - but you MUST NOT create
		//           objects while inside this function.
		// utilizes the twoscompliment class as well as the adition class
		twos.in=b;
		twos.execute();
		temp=twos.out;
		add.a=a;
		add.b=temp;
		add.execute();
		sum=add.sum;
	}



	// --------------------
	// Don't change the following standard variables...
	// --------------------

	// inputs
	public RussWire[] a,b;

	// output
	public RussWire[] sum;

	// --------------------
	// But you should add some *MORE* variables here.
	// --------------------
	// TODO: fill this in

	private Sim1_2sComplement twos;


	private RussWire[] temp;
	private Sim1_ADD add;


	public Sim1_SUB()
	{
		// TODO: fill this in!
		
		a   = new RussWire[32];
		b   = new RussWire[32];
		sum = new RussWire[32];
		twos = new Sim1_2sComplement();
		temp = new RussWire[32];
		add = new Sim1_ADD();
		
		for (int i=0; i<32; i++)
		{
			a  [i] = new RussWire();
			b  [i] = new RussWire();
			sum[i] = new RussWire();
			temp[i] = new RussWire();

		}
	}
}

