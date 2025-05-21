public class IPAdress {
    private String IPadress;

    public IPAdress(){
        this.IPadress = IPadress;
    }

    public String getIPadress(){
        return IPadress;
    }

    public String IPAdressToBits(){
        String [] partes = IPadress.split("\\.");
        int [] tratados = new int[partes.length];
        String [] binarios = new String[tratados.length];
        StringBuilder sb = new StringBuilder();
        StringBuilder formatado = new StringBuilder();
        for (int i = 0;i< partes.length;i++){
            tratados[i] = Integer.parseInt(partes[i]);
        }
        for (int i =0;i<tratados.length;i++){
            binarios[i] = String.format("%08s",Integer.toBinaryString(tratados[i]));
        }
        for (String i : binarios){
            sb.append(i);
        }
        String resultado = sb.toString();
        
        for (int i =0;i<resultado.length();i++){
            formatado.append(resultado.charAt(i));

            if (i == 7 || i == 15 || i ==23){
                formatado.append(".");
            }
        }

        return formatado.toString();
    }

    public String IPAdressToIpv4(){
        String [] partes = IPadress.split("\\.");
        int [] decimal = new int[partes.length];
        String [] tratar_para_string = new String[decimal.length];
        StringBuilder sb = new StringBuilder();
        StringBuilder formatado = new StringBuilder();
        for (int i = 0;i<partes.length;i++){
            decimal[i] = Integer.parseInt(partes[i],2);
        }
        for (int i =0;i<decimal.length;i++){
            tratar_para_string[i] = String.format("%03d",decimal[i]);
        }

        for (String i : tratar_para_string){
            sb.append(i);
        }

        String resultado = sb.toString();

        for (int i = 0; i<resultado.length();i++){
            formatado.append(resultado.charAt(i));

            if (i == 2 || i == 5 || i == 8){
                formatado.append(".");
            }
        }

        return formatado.toString();
    }

    public boolean IPAdressIsMask(){
        String [] partes = IPadress.split("\\.");
        StringBuilder binario = new StringBuilder();

        for (String i : partes){
            int val = Integer.parseInt(i);
            String bin = String.format("%8s", Integer.toBinaryString(val)).replace(" ","0");
            binario.append(bin);
        }

        String binstr = binario.toString();
        int primeiroZero = binstr.indexOf("0");
        int ultimoUm = binstr.lastIndexOf("1");

        if (primeiroZero == -1 || ultimoUm < primeiroZero){
            return true;
        }
        else{
            return false;
        }
    }
}
