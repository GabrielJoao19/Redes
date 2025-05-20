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
            binarios[i] = String.format("%8s",Integer.toBinaryString(tratados[i])).replace(" ", "0");
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
}
