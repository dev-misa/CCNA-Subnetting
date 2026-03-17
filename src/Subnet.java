import java.lang.*;

public class Subnet {
    private int prefix;
    public Subnet(int prefix){
        this.prefix = prefix;
    }
    public int getPrefix(){
        return prefix;
    }
    //calc for borrowed
    public int calcBits(){
        return 32-prefix;
    }
    //calc for number of hosts
    public long calcTotalHosts(){
       return (long)Math.pow(2,calcBits());
    }
    //calc for usable hosts
    public long calcUsableHosts(){
        if(calcTotalHosts() >= 4){
            return calcTotalHosts() -2;
        } else if(calcTotalHosts() <= 3){
            return 0;
        }
        return 0;
    }
    //calc subnet mask
    public String calcSubnetMask(){
        String subnetMask = "";
        int p = getPrefix();
        if(p >= 24 && p <= 32){
            subnetMask += "255.255.255." + Integer.toString(calcSuffix());
        } else if (p >= 16 && p <= 23){
            subnetMask += "255.255." + Integer.toString(calcSuffix()) + ".0";
        } else if (p >= 8 && p <= 15){
            subnetMask += "255." + Integer.toString(calcSuffix()) + ".0.0";
        } else if (p >= 1 && p <= 14){
            subnetMask +=  Integer.toString(calcSuffix()) + ".0.0.0";
        } else {
            subnetMask += "0.0.0.0";
        }
        return subnetMask;
    }
    //calc suffix
    public int calcSuffix(){
       int suffix = -1;
        switch(getPrefix()){
           case 32 -> suffix = 255;
           case 7, 15, 23, 31 -> suffix = 254;
           case 6, 14, 22, 30 -> suffix = 252;
           case 5, 13, 21, 29 -> suffix = 248;
           case 4, 12, 20, 28 -> suffix = 240;
           case 3, 11, 19, 27 -> suffix = 224;
           case 2, 10, 18, 26 -> suffix = 192;
           case 1, 9, 17, 25 -> suffix = 128;
           case 24,16,8,0 -> suffix = 0;
        }
        return suffix;
    }
    public void printInfo(){
        System.out.printf("Prefix: /%d%nSubnet Mask: %s%nTotal Hosts: %,d%nUsable Hosts: %,d%n",
                getPrefix(),calcSubnetMask(),calcTotalHosts(),calcUsableHosts());
    }
}