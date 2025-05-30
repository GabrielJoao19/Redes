public class IPAddress {
    private String bits; 

    public IPAddress(String input) {
        if (input.contains(".")) {
            String[] partes = input.split("\\.");
            if (partes.length != 4) throw new IllegalArgumentException("IP inválido.");
            StringBuilder sb = new StringBuilder();
            for (String parte : partes) {
                int val = Integer.parseInt(parte);
                if (val < 0 || val > 255) throw new IllegalArgumentException("Valor fora do intervalo 0-255.");
                sb.append(String.format("%8s", Integer.toBinaryString(val)).replace(" ", "0"));
            }
            this.bits = sb.toString();
        } else {
            if (input.length() != 32 || !input.matches("[01]+")) {
                throw new IllegalArgumentException("Bits inválidos.");
            }
            this.bits = input;
        }
    }

    public String toBits() {
        return bits;
    }

    public String toIPv4() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            String parte = bits.substring(i * 8, (i + 1) * 8);
            int val = Integer.parseInt(parte, 2);
            sb.append(val);
            if (i < 3) sb.append(".");
        }
        return sb.toString();
    }

    public boolean isMask() {
        int primeiroZero = bits.indexOf('0');
        int ultimoUm = bits.lastIndexOf('1');
        return primeiroZero == -1 || ultimoUm < primeiroZero;
    }

    public int maskBits() {
        if (!isMask()) return -1;
        int count = 0;
        for (char c : bits.toCharArray()) {
            if (c == '1') count++;
            else break;
        }
        return count;
    }
}
