import com.sun.org.apache.bcel.internal.generic.AALOAD;

public class LNGTrading {
    public static void main(String[] args) {

        //Create a LNG product
        //LNG NaijaLNG = new LNG("Nigeria", 115, 9000);
        LNG NaijaLNG = new LNG("Nigeria", "NAI127", 115);

        //Get the price of LNG for a specific date using IpriceCurve interface
        IPriceCurve priceCurve1 = new PriceCurve();
        double buyPrice = priceCurve1.getPrice("25/07/2018");

        //Get the price of LNG for a specific date
        IPriceCurve priceCurve2 = new PriceCurve();
        double sellPrice = priceCurve2.getPrice("31/07/2018");

        //create new clients and assign roles as either buyer or seller
        Client shell1 = new Client("Shell", "SH5677LL", "seller");
        Client oilMer1 = new Client("Oil Merchant Ltd", "OM2227", "buyer");

        //create from and to ports
        Port portNigeria1 = new Port("PortN", "Naija127", "Nigeria", true, true, false);
        Port portMalay1 = new Port("PortM", "MALAY671", "Malaysia", true, false, true);

        //create vessel
        //Vessel mightyBoat1 = new Vessel("migthy1", "MP111", 10000, NaijaLNG.volume, 340);
        Vessel mightyBoat1 = new Vessel("migthy1", "MP111", 10000, 340);

        //create contract between seller and buyer
        Contract contract1 = new Contract("A991", mightyBoat1.vesselID, NaijaLNG.originCountry, oilMer1.clientID, shell1.clientID, portNigeria11.portID, portMalay1.portID, NaijaLNG.volume);
        contract1.setContractdate("25/07/2018");
        contract1.setPurchaseDate("26/07/2018");
        contract1.setPurchasePrice(buyPrice);
        contract1.setLoadVolume(1000);
        contract1.setSellDate("25/08/2018");
        contract1.setDischargeVolume(700);
        contract1.setSellPrice(sellPrice);
      
        //calculate shipping cost using IShippingCalculator interface
        IShippingCalculator shippingCalculator = new ShippingCalculator();
        double costOfShipping = shippingCalculator.getShippingCosts(portNigeria1, portMalay1, mightyBoat1);
        contract1.setShippingCost(costOfShipping);
             
        // calculate the P&L ($) = Σ(Sales Revenue - Purchase Cost - Shipping Cost)
        double pandl = (contract1.sellPrice * contract1.getDischargeVolume()) - (contract1.purchasePrice * contract1.getLoadVolume()) - (contract1.shippingCost);       
    }

}

public class LNG {
    String lngID;
    String originCountry;
    float calorificValue;
    //float volume;

    //public LNG (String origin, float cv, float vol){
    public LNG (String origin, String lngID, float cv){
        this.originCountry = origin;
        this.calorificValue = cv;
        this.volume = vol;
    }
}

public class Vessel {
    String vesselName;
    String vesselID;
    //String owner;
    float capacity;
    float volumeofLNGLoaded;
    float volumeofLNGDischarged;
    String originOfLNG;
    String lngID;
    String portFrom;
    String portTo;
    int nauticalSpeed;

    //public Vessel (String name, String id, float cap, float volLoaded, int speed) {
    public Vessel (String name, String id, float cap, int speed) {
        this.vesselName = name;
        this.vesselID = id;
        this.capacity = cap;
        this.nauticalSpeed = speed;
       // this.volumeofLNGLoaded = volLoaded;
    }
    //public float heel() {}
}

public class Port {
    String portName;
    String portID;
    String portLocation;
    String vesselID;
    int portCapacity;
    boolean coolDownGasAvailable;
    float averageLoadingTime;
    float averageDischargingTime;
    boolean loadingPort; 
    boolean dischargingPort;
    float volumeLoadedOntoVessel;
    float volumeDischargedOffVessel;

    public Port(String name, String id, String locale, boolean coolDown, boolean load, boolean discharge){
         // Store arguments as fields.
         this.portName = name;
         this.portID = id;
         this.location = local;
         this.coolDownGasAvailable = coolDown;
         this.loading = load;
         this.discharging = discharge;
        // this.volumeLoaded = loadedVolume;
    }

    public Vessel loadLNG(Vessel vessel, LNG lng, float vol){
        vessel.volumeofLNGLoaded = vol;
        vessel.lngID = lng.lngID;
        return vessel;
    }

    public float dischargeLNG(Vessel vessel, LNG lng, float vol){
        vessel.volumeofLNGDischarged = vol;
        vessel.lngId = lng.lngID;
        return vessel;
    }

    // public float averageDischargeTime(){}   
    // public float averageLoadTime(){}   
}

public class Contract {
    String contractID;
    String vesselID;
    String lngID;
    String buyerID;
    String sellerID;
    String loadingPort;
    String dischargePort;
    float loadVolume;
    float dischargeVolume;
    double purchasePrice;
    double sellPrice;
    double shippingCost;
    Date contractDate;
    Date purchaseDate;
    Date sellDate;
    //String contractType;
    //int contractLength;

    public Contract(String id, String vesID, String lngID, String buyer, String seller, String loadPort, String offLoadPort) {
        this.contractID = id;
        this.vesselID = vesID;
        this.lngID = lngID;
        this.buyerID = buyer;   
        this.sellerID = seller;
        this.loadingPort = loadPort;
        this.dischargePort = offLoadPort;
        //this.loadVolume = vol;      
    }

    public void setContractDate(Date date){
        this.contractDate = date;
    }

    public Date getContractDate(){
        return this.contractDate;
    }

    public void setPurchaseDate(Date date){
        this.purchaseDate = date;
    }

    public Date getPurchaseDate(){
        return this.purchaseDate;
    }

    public void setSellDate(Date date){
        this.sellDate = date;
    }

    public Date getSellDate(){
        return this.SellDate;
    }

    public void setPurchasePrice(double price){
        this.purchasePrice = price;
    }

    public double getPurchasePrice() {
        return this.purchasePrice;
    } 

    public void setSellPrice(double price){
        this.SellPrice = price;
    }

    public double getSellPrice() {
        return this.sellPrice;
    } 

    public void setShippingCost(double cost){
        this.shippingCost = cost;
    }

    public double getShippingCost() {
        return this.shippingCost;
    } 

    public void setLoadVolume(float volume){
        this.loadVolume = volume;
    }

    public double getLoadVolume() {
        return this.loadVolume;
    } 

    public void setDischargeVolume(float volume){
        this.dischargeVolume = volume;
    }

    public double getDischargeVolume() {
        return this.dischargeVolume;
    } 

    //public globalPandL(){
       // P&L ($) = Σ(Sales Revenue - Purchase Cost - Shipping Cost);
    //}

    // public spotPricing(float gasIndex, ){
    //     //i.e. single trade, mid-term (1 or 2 years), longterm (>2 and up to 20 years )

    // }
}

public class Client {
    String clientName;
    String clientID;
    //is it a buyer, seller
    String clientRole; 

    public Client(String name, String id, String role){
        this.clientName = name;
        this.clientID = id;
        this.clientRole = role;
    }
}