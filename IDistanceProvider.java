import java.io.*;
//import Package.LNGTrading;

interface IDistanceProvider {
	// Returns distance in nautical miles between ports
	int getDistance(Port from, Port to);
}	
