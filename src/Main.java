/**
 * @author Felix Misael Taperia
 * @since 3/17/2026
 * @version 1.0
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.out.println("Enter prefix (0 - 32):");
        Scanner scan = new Scanner(new File("prefixes.dat"));
        while (scan.hasNextInt()) {
            int prefix = scan.nextInt();
            Subnet subnet = new Subnet(prefix);
            subnet.printInfo();

        }
        scan.close();
    }
}