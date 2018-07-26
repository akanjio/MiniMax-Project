import java.util.*;
import java.io.*;

public interface IPriceCurve {
	// Get the $/mmBtu price for the given date from this curve
	double getPrice(Date date);
}
