/* Simulates a physical AND gate.
 *
 * Author: Omar R. Gebril
 */

public class Sim1_AND
{
	public void execute()
	{
		// TODO: fill this in!
		if(a.get() && b.get()) {
			out.set(true);
		}
		else {
			out.set(false);
		}
	}



	public RussWire a,b;   // inputs
	public RussWire out;   // output

	public Sim1_AND()
	{
		// TODO: fill this in!
		a = new RussWire();
		b = new RussWire();
		
		out = new RussWire();
	}
}

