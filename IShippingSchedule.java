import java.util.*;
import java.io.*;

interface IShippingSchedule {
	// A sequenced list of cargoes representing the schedule of a vessel
	List<Cargo> getCargoes(Vessel vessel);
}

