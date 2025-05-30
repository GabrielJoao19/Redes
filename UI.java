import java.util.Scanner;

public class IPToolUI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IPAddress ip1 = null, ip2 = null, mask = null;

        while (true) {
            System.out.println("\n=== IP Tool Menu ===");
            System.out.println("1 - Informar IP principal");
            System.out.println("2 - Informar segundo IP");
            System.out.println("3 - Informar máscara");
            System.out.println("4 - Mostrar IP em bits");
            System.out.println("5 - Mostrar IP em IPv4");
            System.out.println("6 - Verificar se IP é válido");
            System.out.println("7 - Verificar se é máscara");
            System.out.println("8 - Ver quantos bits tem a máscara");
            System.out.println("9 - Ver endereço de rede");
            System.out.println("10 - Ver endereço de broadcast");
            System.out.println("11 - Ver se dois IPs estão na mesma rede");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine(); // limpa o buffer

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o IP (ex: 192.168.0.1 ou bits): ");
                        ip1 = new IPAddress(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Digite o segundo IP: ");
                        ip2 = new IPAddress(sc.nextLine());
                        break;
                    case 3:
                        System.out.print("Digite a máscara de rede: ");
                        mask = new IPAddress(sc.nextLine());
                        break;
                    case 4:
                        if (ip1 != null)
                            System.out.println("Bits: " + ip1.toBits());
                        else System.out.println("Informe o IP primeiro.");
                        break;
                    case 5:
                        if (ip1 != null)
                            System.out.println("IPv4: " + ip1.toIPv4());
                        else System.out.println("Informe o IP primeiro.");
                        break;
                    case 6:
                        if (ip1 != null)
                            System.out.println("IP válido? " + IPToolIF.isValid(ip1));
                        else System.out.println("Informe o IP primeiro.");
                        break;
                    case 7:
                        if (ip1 != null)
                            System.out.println("É máscara? " + ip1.isMask());
                        else System.out.println("Informe o IP primeiro.");
                        break;
                    case 8:
                        if (ip1 != null)
                            System.out.println("Bits da máscara: " + ip1.maskBits());
                        else System.out.println("Informe o IP primeiro.");
                        break;
                    case 9:
                        if (ip1 != null && mask != null)
                            System.out.println("Endereço de rede: " + IPToolIF.network(ip1, mask).toIPv4());
                        else System.out.println("Informe o IP e a máscara.");
                        break;
                    case 10:
                        if (ip1 != null && mask != null)
                            System.out.println("Broadcast: " + IPToolIF.broadcast(ip1, mask).toIPv4());
                        else System.out.println("Informe o IP e a máscara.");
                        break;
                    case 11:
                        if (ip1 != null && ip2 != null && mask != null)
                            System.out.println("Mesma rede? " + IPToolIF.areSameNet(ip1, ip2, mask));
                        else System.out.println("Informe os dois IPs e a máscara.");
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        sc.close();
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}
