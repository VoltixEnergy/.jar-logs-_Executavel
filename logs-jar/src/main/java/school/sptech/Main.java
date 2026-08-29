package school.sptech;

public class Main {

    public static void main(String[] args) {
        Hardware cpu = new Hardware();
        cpu.nome = "CPU";
        cpu.metricaAtual = 10;
        cpu.metricaMaxima = 100;
        cpu.metricaRisco = 80;
        cpu.simboloUnidadeDeMedida = "%";

        Hardware ram = new Hardware();
        ram.nome = "Memória RAM";
        ram.metricaAtual = 10;
        ram.metricaMaxima = 100;
        ram.metricaRisco = 80;
        ram.simboloUnidadeDeMedida = "%";

        Hardware disco = new Hardware();
        disco.nome = "Disco";
        disco.metricaAtual = 10;
        disco.metricaMaxima = 100;
        disco.metricaRisco = 80;
        disco.simboloUnidadeDeMedida = "%";

        String[] verificarCpu = new String[2];
        String[] verificarRam = new String[2];
        String[] verificarDisco = new String[2];
        String mensagem = null;

        try {
            for (int i = 1; i <= 10; i++) {
                verificarCpu = cpu.verificar();
                verificarRam = ram.verificar();
                verificarDisco = disco.verificar();

                if (verificarCpu[0] != null && verificarDisco[0] != null && verificarRam[0] != null) {
                    String[] informacoesCpu = cpu.pegarInformacoes();
                    if (verificarCpu[1].equals("WARN") || verificarDisco[1].equals("WARN") || verificarRam[1].equals("WARN")) {
                        mensagem = ("%s [%s] %s %s -- [Leitura #%d] Atenção! Alerta de hardware em estado crítico - " +
                                "CPU: %d%s| RAM: %d%s| Disco: %d%s").formatted(verificarCpu[0], informacoesCpu[1], verificarCpu[1],
                                informacoesCpu[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida);
                    } else {
                        mensagem = ("%s [%s] %s %s -- [Leitura #%d] Alerta! Hardware instável - " +
                                "CPU: %d%s| RAM: %d%s| Disco: %d%s").formatted(verificarCpu[0], informacoesCpu[1], verificarCpu[1],
                                informacoesCpu[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida);
                    }

                } else if (verificarCpu[0] != null && verificarDisco[0] != null) {
                    String[] informacoesCpu = cpu.pegarInformacoes();
                    if (verificarCpu[1].equals("WARN") || verificarDisco[1].equals("WARN")) {
                        mensagem = ("%s [%s] %s %s -- [Leitura #%d] Atenção! Alerta de CPU e Disco em estado crítico - " +
                                "CPU: %d%s| RAM: %d%s| Disco: %d%s").formatted(verificarCpu[0], informacoesCpu[1], verificarCpu[1],
                                informacoesCpu[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida);
                    } else {
                        mensagem = ("%s [%s] %s %s -- [Leitura #%d] Alerta! CPU e Disco instáveis - " +
                                "CPU: %d%s| RAM: %d%s| Disco: %d%s").formatted(verificarCpu[0], informacoesCpu[1], verificarCpu[1],
                                informacoesCpu[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida);
                    }

                } else if (verificarCpu[0] != null && verificarRam[0] != null) {
                    String[] informacoesCpu = cpu.pegarInformacoes();
                    if (verificarCpu[1].equals("WARN") || verificarRam[1].equals("WARN")) {
                        mensagem = ("%s [%s] %s %s -- [Leitura #%d] Atenção! Alerta de CPU e memória RAM em estado crítico - " +
                                "CPU: %d%s| RAM: %d%s| Disco: %d%s").formatted(verificarCpu[0], informacoesCpu[1], verificarCpu[1],
                                informacoesCpu[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida);
                    } else {
                        mensagem = ("%s [%s] %s %s -- [Leitura #%d] Alerta! CPU e memória RAM instáveis - " +
                                "CPU: %d%s| RAM: %d%s| Disco: %d%s").formatted(verificarCpu[0], informacoesCpu[1], verificarCpu[1],
                                informacoesCpu[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida);
                    }

                } else if (verificarRam[0] != null && verificarDisco[0] != null) {
                    String[] informacoesCpu = cpu.pegarInformacoes();
                    if (verificarDisco[1].equals("WARN") || verificarRam[1].equals("WARN")) {
                        mensagem = ("%s [%s] %s %s -- [Leitura #%d] Atenção! Alerta de memória RAM e Disco em estado crítico - " +
                                "CPU: %d%s| RAM: %d%s| Disco: %d%s").formatted(verificarCpu[0], informacoesCpu[1], verificarCpu[1],
                                informacoesCpu[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida);
                    } else {
                        mensagem = ("%s [%s] %s %s -- [Leitura #%d] Alerta! Memória RAM e Disco instáveis - " +
                                "CPU: %d%s| RAM: %d%s| Disco: %d%s").formatted(verificarCpu[0], informacoesCpu[1], verificarCpu[1],
                                informacoesCpu[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida);
                    }

                } else if (verificarCpu[0] != null) {
                    String[] informacoesCpu = cpu.pegarInformacoes();
                    if (verificarCpu[1].equals("WARN")) {
                        mensagem = ("%s [%s] %s %s -- [Leitura #%d] Atenção! Alerta de CPU em estado crítico - " +
                                "CPU: %d%s| RAM: %d%s| Disco: %d%s").formatted(verificarCpu[0], informacoesCpu[1], verificarCpu[1],
                                informacoesCpu[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida);
                    } else {
                        mensagem = ("%s [%s] %s %s -- [Leitura #%d] Alerta! CPU instável - " +
                                "CPU: %d%s| RAM: %d%s| Disco: %d%s").formatted(verificarCpu[0], informacoesCpu[1], verificarCpu[1],
                                informacoesCpu[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida);
                    }

                } else if (verificarDisco[0] != null) {
                    String[] informacoesDisco = disco.pegarInformacoes();
                    if (verificarCpu[1].equals("WARN")) {
                        mensagem = ("%s [%s] %s %s -- [Leitura #%d] Atenção! Alerta de Disco em estado crítico - " +
                                "CPU: %d%s| RAM: %d%s| Disco: %d%s").formatted(verificarDisco[0], informacoesDisco[1], verificarDisco[1],
                                informacoesDisco[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida);
                    } else {
                        mensagem = ("%s [%s] %s %s -- [Leitura #%d] Alerta! Disco instável - " +
                                "CPU: %d%s| RAM: %d%s| Disco: %d%s").formatted(verificarDisco[0], informacoesDisco[1], verificarDisco[1],
                                informacoesDisco[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida);
                    }

                } else if (verificarRam[0] != null) {
                    String[] informacoesRam = ram.pegarInformacoes();
                    if (verificarCpu[1].equals("WARN")) {
                        mensagem = ("%s [%s] %s %s -- [Leitura #%d] Atenção! Alerta de CPU em estado crítico - " +
                                "CPU: %d%s| RAM: %d%s| Disco: %d%s").formatted(verificarRam[0], informacoesRam[1], verificarRam[1],
                                        informacoesRam[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida);
                    } else {
                        mensagem = ("%s [%s] %s %s -- [Leitura #%d] Alerta! CPU instável - " +
                                "CPU: %d%s| RAM: %d%s| Disco: %d%s").formatted(verificarRam[0], informacoesRam[1], verificarRam[1],
                                        informacoesRam[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida);
                    }
                }

                if (mensagem != null) {
                    System.out.println(mensagem);
                }
                cpu.metricaAtual += 10;
                Thread.sleep(10000);
            }
        } catch (InterruptedException e) {
            System.out.println("Erro no esperar 10 segundos.");
        } catch (NullPointerException e) {
            System.out.println("Erro na leitura, números mais altos do que o possível.");
        }

    }
}
