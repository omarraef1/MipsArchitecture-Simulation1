/* Simulates a physical OR gate.
 *
 * Author: Omar R. Gebril
 */

public class Sim1_OR
{
	public void execute()
	{
		// TODO: fill this in!
		if (a.get() || b.get()) {
			out.set(true);
		}
		else {
			out.set(false);
		}
	}



	public RussWire a,b;   // inputs
	public RussWire out;   // output

	public Sim1_OR()
	{
		// TODO: fill this in!
		a = new RussWire();
		b = new RussWire();
		
		out = new RussWire();
	}
}

