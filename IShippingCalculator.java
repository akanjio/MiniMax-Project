public interface IShippingCalculator {
	// Calculate the shipping costs for a cargo
	int getShippingCosts(Port from, Port to, Vessel vessel);
}
