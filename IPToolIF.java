public class IPToolIF {

    public static boolean isValid(IPAddress ip) {
        String bits = ip.toBits();
        return bits.length() == 32 && bits.matches("[01]+");
    }

    public static boolean areSameNet(IPAddress ip1, IPAddress ip2, IPAddress mask) {
        String net1 = andBits(ip1.toBits(), mask.toBits());
        String net2 = andBits(ip2.toBits(), mask.toBits());
        return net1.equals(net2);
    }

    public static IPAddress broadcast(IPAddress ip, IPAddress mask) {
        String ipBits = ip.toBits();
        String maskBits = mask.toBits();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 32; i++) {
            char m = maskBits.charAt(i);
            char b = (m == '1') ? ipBits.charAt(i) : '1';
            result.append(b);
        }

        return new IPAddress(result.toString());
    }

    public static IPAddress network(IPAddress ip, IPAddress mask) {
        String ipBits = ip.toBits();
        String maskBits = mask.toBits();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 32; i++) {
            char b = (maskBits.charAt(i) == '1' && ipBits.charAt(i) == '1') ? '1' : '0';
            result.append(b);
        }

        return new IPAddress(result.toString());
    }

    // Método auxiliar para fazer o AND bit a bit entre dois strings binários
    private static String andBits(String a, String b) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            result.append((a.charAt(i) == '1' && b.charAt(i) == '1') ? '1' : '0');
        }
        return result.toString();
    }
}
