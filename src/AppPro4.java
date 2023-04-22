
//Bill Calculation
public class AppPro4 {

    public int billcalculation(String bc, String dc, int addAC) {

        int km = 3;
        int fprice = 0;
        int bill;

        // Variables containing the distance between two cities [ Source : Google Maps]

        int AtR = 215;
        int AtS = 260;
        int AtB = 110;
        int AtD = 440;

        int RtA = 215;
        int RtS = 450;
        int RtB = 295;
        int RtD = 220;

        int StA = 260;
        int StR = 450;
        int StB = 155;
        int StD = 665;

        int BtA = 110;
        int BtR = 295;
        int BtS = 155;
        int BtD = 505;

        int DtR = 220;
        int DtA = 440;
        int DtS = 665;
        int DtB = 505;

        if (bc.equals("Ahmedabad")) {
            switch (dc) {
                case "Rajkot":
                    bill = AtR * km;
                    fprice = bill + addAC;
                    // System.out.println("Total Bill : " + bill);
                    break;
                case "Surat":
                    bill = AtS * km;
                    fprice = bill + addAC;
                    // System.out.println("Total Bill : " + bill);
                    break;
                case "Vadodara":
                    bill = AtB * km;
                    fprice = bill + addAC;
                    // System.out.println("Total Bill : " + bill);
                    break;
                case "Dwarka":
                    bill = AtD * km;
                    fprice = bill + addAC;
                    // System.out.println("Total Bill : " + bill);
                    break;

                default:
                    System.out.println("Ahmedabad ERROR");
                    break;
            }
        }

        if (bc.equals("Rajkot")) {
            switch (dc) {
                case "Ahmedabad":
                    bill = RtA * km;
                    fprice = bill + addAC;
                    // System.out.println("Total Bill : " + bill);
                    break;
                case "Surat":
                    bill = RtS * km;
                    fprice = bill + addAC;
                    // System.out.println("Total Bill : " + bill);
                    break;
                case "Vadodara":
                    bill = RtB * km;
                    fprice = bill + addAC;
                    // System.out.println("Total Bill : " + bill);
                    break;
                case "Dwarka":
                    bill = RtD * km;
                    fprice = bill + addAC;
                    // System.out.println("Total Bill : " + bill);
                    break;

                default:
                    System.out.println("Rajkot ERROR");
                    break;
            }
        }

        if (bc.equals("Surat")) {
            switch (dc) {
                case "Ahmedabad":
                    bill = StA * km;
                    fprice = bill + addAC;
                    // System.out.println("Total Bill : " + bill);
                    break;
                case "Rajkot":
                    bill = StR * km;
                    fprice = bill + addAC;
                    // System.out.println("Total Bill : " + bill);
                    break;
                case "Vadodara":
                    bill = StB * km;
                    fprice = bill + addAC;
                    // System.out.println("Total Bill : " + bill);
                    break;
                case "Dwarka":
                    bill = StD * km;
                    fprice = bill + addAC;
                    // System.out.println("Total Bill : " + bill);
                    break;

                default:
                    System.out.println("Surat ERROR");
                    break;
            }
        }

        if (bc.equals("Vadodara")) {
            switch (dc) {
                case "Ahmedabad":
                    bill = BtA * km;
                    fprice = bill + addAC;
                    // System.out.println("Total Bill : " + bill);
                    break;
                case "Rajkot":
                    bill = BtR * km;
                    fprice = bill + addAC;
                    // System.out.println("Total Bill : " + bill);
                    break;
                case "Surat":
                    bill = BtS * km;
                    fprice = bill + addAC;
                    // System.out.println("Total Bill : " + bill);
                    break;
                case "Dwarka":
                    bill = BtD * km;
                    fprice = bill + addAC;
                    // System.out.println("Total Bill : " + bill);
                    break;

                default:
                    System.out.println("Vadodara ERROR");
                    break;
            }
        }

        if (bc.equals("Dwarka")) {
            switch (dc) {
                case "Ahmedabad":
                    bill = DtA * km;
                    fprice = bill + addAC;
                    // System.out.println("Total Bill : " + bill);
                    break;
                case "Rajkot":
                    bill = DtR * km;
                    fprice = bill + addAC;
                    // System.out.println("Total Bill : " + bill);
                    break;
                case "Surat":
                    bill = DtS * km;
                    fprice = bill + addAC;
                    // System.out.println("Total Bill : " + bill);
                    break;
                case "Vadodara":
                    bill = DtB * km;
                    fprice = bill + addAC;
                    // System.out.println("Total Bill : " + bill);
                    break;

                default:
                    System.out.println("Dwarka ERROR");
                    break;
            }
        }
        return fprice;
    }

    public int distancecalculation(String bc, String dc) {

        int dist = 0;
        int AtR = 215;
        int AtS = 260;
        int AtB = 110;
        int AtD = 440;

        int RtA = 215;
        int RtS = 450;
        int RtB = 295;
        int RtD = 220;

        int StA = 260;
        int StR = 450;
        int StB = 155;
        int StD = 665;

        int BtA = 110;
        int BtR = 295;
        int BtS = 155;
        int BtD = 505;

        int DtR = 220;
        int DtA = 440;
        int DtS = 665;
        int DtB = 505;

        if (bc.equals("Ahmedabad")) {
            switch (dc) {
                case "Rajkot":
                    dist = AtR;
                    break;
                case "Surat":
                    dist = AtS;
                    break;
                case "Vadodara":
                    dist = AtB;
                    break;
                case "Dwarka":
                    dist = AtD;
                    break;

                default:
                    System.out.println("Ahmedabad ERROR");
                    break;
            }
        }

        if (bc.equals("Rajkot")) {
            switch (dc) {
                case "Ahmedabad":
                    dist = RtA;

                    break;
                case "Surat":
                    dist = RtS;

                    break;
                case "Vadodara":
                    dist = RtB;

                    break;
                case "Dwarka":
                    dist = RtD;
                    break;

                default:
                    System.out.println("Rajkot ERROR");
                    break;
            }
        }

        if (bc.equals("Surat")) {
            switch (dc) {
                case "Ahmedabad":
                    dist = StA;

                    break;
                case "Rajkot":
                    dist = StR;

                    break;
                case "Vadodara":
                    dist = StB;

                    break;
                case "Dwarka":
                    dist = StD;

                    break;

                default:
                    System.out.println("Surat ERROR");
                    break;
            }
        }

        if (bc.equals("Vadodara")) {
            switch (dc) {
                case "Ahmedabad":
                    dist = BtA;

                    break;
                case "Rajkot":
                    dist = BtR;

                    break;
                case "Surat":
                    dist = BtS;

                    break;
                case "Dwarka":
                    dist = BtD;

                    break;

                default:
                    System.out.println("Vadodara ERROR");
                    break;
            }
        }

        if (bc.equals("Dwarka")) {
            switch (dc) {
                case "Ahmedabad":
                    dist = DtA;

                    break;
                case "Rajkot":
                    dist = DtR;

                    break;
                case "Surat":
                    dist = DtS;

                    break;
                case "Vadodara":
                    dist = DtB;

                    break;

                default:
                    System.out.println("Dwarka ERROR");
                    break;
            }
        }
        return dist;
    }

    public String pickupplace(String bc) {
        String place = "";
        switch (bc) {
            case "Ahmedabad":
                place = "Ahmedabad Terminus";

                break;
            case "Rajkot":
                place = "Rajkot GCMT Terminus";

                break;
            case "Surat":
                place = "Surat GCMT Terminus";

                break;
            case "Vadodara":
                place = "Vadodara Terminus";

                break;
            case "Dwarka":
                place = "Dwarka GCMT Terminus";

                break;

            default:
                System.out.println("Terminus");
                break;
        }
        return place;
    }

    public static void main(String[] args) {

    }
}
