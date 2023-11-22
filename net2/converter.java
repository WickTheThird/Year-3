import java.util.Scanner;



public class converter {

    public void binConv(int addr) {
        StringBuilder bin = new StringBuilder();

        while (addr > 0) {
            int remainder = addr % 2;
            bin.insert(0, remainder);
            addr /= 2;
        }

        System.out.println("Binary representation is : " + bin.toString());
        System.out.println("\n");
        System.out.println("\n");
    }


    public void addrBinConv(String addr) {
        StringBuilder bin = new StringBuilder();

        String[] newAddr = addr.split("\\.");

        for (String part : newAddr) {
            int ipPart = Integer.parseInt(part);
            StringBuilder binPart = new StringBuilder();

            while (ipPart > 0) {
                int remainder = ipPart % 2;
                binPart.insert(0, remainder);
                ipPart /= 2;
            }

            while (binPart.length() < 8) {
                binPart.insert(0, '0');
            }

            bin.append(binPart).append(" ");
        }


        bin.deleteCharAt(bin.length() - 1);

        System.out.println("Binary representation is : " + bin.toString());
        System.out.println("\n");
        System.out.println("\n");
    }



    public void hexConv(int addr) {
        StringBuilder hex = new StringBuilder();
        char[] hexChars = "0123456789ABCDEF".toCharArray();

        while (addr != 0) {
            int remainder = addr % 16;
            hex.insert(0, hexChars[remainder]);
            addr /= 16;
        }

        System.out.println("hex representation is : " + hex.toString());
        System.out.println("\n");
        System.out.println("\n");
    }


    public void hexAddr(String addr) {
        StringBuilder hex = new StringBuilder();
        char[] hexChars = "0123456789ABCDEF".toCharArray();

        String[] newAddr = addr.split("\\.");

        for (String part : newAddr) {
            int ipPart = Integer.parseInt(part);
            StringBuilder hexPart = new StringBuilder();

            while (ipPart != 0) {
                int remainder = ipPart % 16;
                hexPart.insert(0, hexChars[remainder]);
                ipPart /= 16;
            }

            while (hexPart.length() < 2) {
                hexPart.insert(0, '0');
            }

            hex.append(hexPart).append(".");
        }

        hex.deleteCharAt(hex.length() - 1);

        System.out.println("hex representation is : " + hex.toString());
        System.out.println("\n");
        System.out.println("\n");
    }



    public int binToDec(String bin) {

        int dec = 0;
        int pow = 0;

        for (int i = bin.length() - 1; i >= 0; i--) {
            if (bin.charAt(i) == '1') {
                dec += Math.pow(2, pow);
            }
            pow++;
        }

        System.out.println("Decimal representation is : " + dec);
        System.out.println("\n");
        System.out.println("\n");

        return dec;
    }


    public int hexToDec(String hex) {

        String tokens = "0123456789ABCDEF";
        hex = hex.toUpperCase();
        int result = 0;

        for (int i = 0; i < hex.length(); i++) {
            int n = tokens.indexOf(hex.charAt(i));
            result = result * 16 + n;
        }

        System.out.println("Decimal representation is : " + result);
        System.out.println("\n");
        System.out.println("\n");

        return result;
    }


    public void binToHex(String bin) {
        int dec = this.binToDec(bin);
        this.hexConv(dec);
    }

    public void hexToBin(String hex) {
        int dec = this.hexToDec(hex);
        this.binConv(dec);
    }


    public static void main(String[] args){

        converter conv = new converter();

        Scanner sc = new Scanner(System.in);

        int solution = -1;

        while (solution != 0) {

            System.out.println("What do you want to convert? ");
            System.out.println("\n");
            System.out.println("0. Quit");
            System.out.println("1. Number to Binary");
            System.out.println("2. Address to Binary");
            System.out.println("3. Number to hex");
            System.out.println("4. Address to hex");
            System.out.println("5. Binary to Decimal");
            System.out.println("6. hex to Decimal");
            System.out.println("7. Binary to Hexadecimal");
            System.out.println("8. Hexadecimal to Binary");
            System.out.println("\n");

            solution = sc.nextInt();
            sc.nextLine();

            if (solution == 1) 
            {
                System.out.println("Enter the number: ");
                System.out.println("\n");
                int addr = sc.nextInt();

                conv.binConv(addr);

            } else if (solution == 2) {
                System.out.println("Enter the address: ");
                System.out.println("\n");
                String addr = sc.nextLine();

                conv.addrBinConv(addr);
            } else if (solution == 3) {
                System.out.println("Enter the number: ");
                System.out.println("\n");
                int addr = sc.nextInt();

                conv.hexConv(addr);
            } else if (solution == 4) {
                System.out.println("Enter the address: ");
                System.out.println("\n");
                String addr = sc.nextLine();

                conv.hexAddr(addr);
            } else if (solution == 5 ) {
                System.out.println("Enter the binary number: ");
                System.out.println("\n");
                String addr = sc.nextLine();

                conv.binToDec(addr);
            } else if (solution == 6) {
                System.out.println("Enter the hex number: ");
                System.out.println("\n");
                String addr = sc.nextLine();

                conv.hexToDec(addr);
            } else if (solution == 0) {
                sc.close();
                System.out.println("Goodbye!");

                break;
            } else if (solution == 7) {
                System.out.println("Enter the binary number: ");
                System.out.println("\n");
                String addr = sc.nextLine();

                conv.binToHex(addr);
            } else if (solution == 8) {
                System.out.println("Enter the hex number: ");
                System.out.println("\n");
                String addr = sc.nextLine();

                conv.hexToBin(addr);
            }else {
                System.out.println("Invalid input!");
                System.out.println("\n");
                System.out.println("\n");
            }

        }

    }

}

