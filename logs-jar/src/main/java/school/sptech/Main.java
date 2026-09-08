package school.sptech;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Hardware cpu = new Hardware();
        cpu.nome = "CPU";
        cpu.metricaAtual = 70;
        cpu.metricaMaxima = 100;
        cpu.metricaRisco = 80;
        cpu.simboloUnidadeDeMedida = "%";

        Hardware ram = new Hardware();
        ram.nome = "Memória RAM";
        ram.metricaAtual = 70;
        ram.metricaMaxima = 100;
        ram.metricaRisco = 80;
        ram.simboloUnidadeDeMedida = "%";

        Hardware disco = new Hardware();
        disco.nome = "Disco";
        disco.metricaAtual = 70;
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

                if (verificarCpu[1] != "INFO" && verificarDisco[1] != "INFO" && verificarRam[1] != "INFO") {
                    String[] informacoesCpu = cpu.pegarInformacoes();
                    if (verificarCpu[1].equals("WARN") || verificarDisco[1].equals("WARN") || verificarRam[1].equals("WARN")) {
                        mensagem = ("%s [%s] %s -- [Leitura #%02d] Estado Crítico: Sobrecarga em múltiplos componentes - " +
                                "CPU: %d%s | RAM: %d%s | Disco: %d%s -- %s").formatted(verificarCpu[1], informacoesCpu[1],
                                informacoesCpu[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida, verificarCpu[0]);
                    } else {
                        mensagem = ("%s [%s] %s -- [Leitura #%02d] Instabilidade detectada: Múltiplos componentes - " +
                                "CPU: %d%s | RAM: %d%s | Disco: %d%s -- %s").formatted(verificarCpu[1], informacoesCpu[1],
                                informacoesCpu[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida, verificarCpu[0]);
                    }

                } else if (verificarCpu[1] != "INFO" && verificarDisco[1] != "INFO") {
                    String[] informacoesCpu = cpu.pegarInformacoes();
                    if (verificarCpu[1].equals("WARN") || verificarDisco[1].equals("WARN")) {
                        mensagem = ("%s [%s] %s -- [Leitura #%02d] Estado Crítico: Sobrecarga na CPU e Disco - " +
                                "CPU: %d%s | RAM: %d%s | Disco: %d%s -- %s").formatted(verificarCpu[1], informacoesCpu[1],
                                informacoesCpu[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida, verificarCpu[0]);
                    } else {
                        mensagem = ("%s [%s] %s -- [Leitura #%02d] Instabilidade detectada: CPU e Disco - " +
                                "CPU: %d%s | RAM: %d%s | Disco: %d%s -- %s").formatted(verificarCpu[1], informacoesCpu[1],
                                informacoesCpu[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida, verificarCpu[0]);
                    }

                } else if (verificarCpu[1] != "INFO" && verificarRam[1] != "INFO") {
                    String[] informacoesCpu = cpu.pegarInformacoes();
                    if (verificarCpu[1].equals("WARN") || verificarRam[1].equals("WARN")) {
                        mensagem = ("%s [%s] %s -- [Leitura #%02d] Estado Crítico: Sobrecarga na CPU e Memória RAM - " +
                                "CPU: %d%s | RAM: %d%s | Disco: %d%s -- %s").formatted(verificarCpu[1], informacoesCpu[1],
                                informacoesCpu[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida, verificarCpu[0]);
                    } else {
                        mensagem = ("%s [%s] %s -- [Leitura #%02d] Instabilidade detectada: CPU e Memória RAM - " +
                                "CPU: %d%s | RAM: %d%s | Disco: %d%s -- %s").formatted(verificarCpu[1], informacoesCpu[1],
                                informacoesCpu[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida, verificarCpu[0]);
                    }

                } else if (verificarRam[1] != "INFO" && verificarDisco[1] != "INFO") {
                    String[] informacoesCpu = cpu.pegarInformacoes();
                    if (verificarDisco[1].equals("WARN") || verificarRam[1].equals("WARN")) {
                        mensagem = ("%s [%s] %s -- [Leitura #%02d] Estado Crítico: Sobrecarga na Memória RAM e Disco - " +
                                "CPU: %d%s | RAM: %d%s | Disco: %d%s -- %s").formatted(verificarCpu[1], informacoesCpu[1],
                                informacoesCpu[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida, verificarCpu[0]);
                    } else {
                        mensagem = ("%s [%s] %s -- [Leitura #%02d] Instabilidade detectada: Memória RAM e Disco - " +
                                "CPU: %d%s | RAM: %d%s | Disco: %d%s -- %s").formatted(verificarCpu[1], informacoesCpu[1],
                                informacoesCpu[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida, verificarCpu[0]);
                    }

                } else if (verificarCpu[1] != "INFO") {
                    String[] informacoesCpu = cpu.pegarInformacoes();
                    if (verificarCpu[1].equals("WARN")) {
                        mensagem = ("%s [%s] %s -- [Leitura #%02d] Estado Crítico: Sobrecarga na CPU - " +
                                "CPU: %d%s | RAM: %d%s | Disco: %d%s -- %s").formatted(verificarCpu[1], informacoesCpu[1],
                                informacoesCpu[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida, verificarCpu[0]);
                    } else {
                        mensagem = ("%s [%s] %s -- [Leitura #%02d] Instabilidade detectada: CPU - " +
                                "CPU: %d%s | RAM: %d%s | Disco: %d%s -- %s").formatted(verificarCpu[1], informacoesCpu[1],
                                informacoesCpu[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida, verificarCpu[0]);
                    }

                } else if (verificarDisco[1] != "INFO") {
                    String[] informacoesDisco = disco.pegarInformacoes();
                    if (verificarDisco[1].equals("WARN")) {
                        mensagem = ("%s [%s] %s -- [Leitura #%02d] Estado Crítico: Sobrecarga no Disco - " +
                                "CPU: %d%s | RAM: %d%s | Disco: %d%s -- %s").formatted(verificarDisco[1], informacoesDisco[1],
                                informacoesDisco[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida, verificarDisco[0]);
                    } else {
                        mensagem = ("%s [%s] %s -- [Leitura #%02d] Instabilidade detectada: Disco - " +
                                "CPU: %d%s | RAM: %d%s | Disco: %d%s -- %s").formatted(verificarDisco[1], informacoesDisco[1],
                                informacoesDisco[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida, verificarDisco[0]);
                    }

                } else if (verificarRam[1] != "INFO") {
                    String[] informacoesRam = ram.pegarInformacoes();
                    if (verificarRam[1].equals("WARN")) {
                        mensagem = ("%s [%s] %s -- [Leitura #%02d] Estado Crítico: Sobrecarga na Memória RAM - " +
                                "CPU: %d%s | RAM: %d%s | Disco: %d%s -- %s").formatted(verificarRam[1], informacoesRam[1],
                                informacoesRam[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida, verificarRam[0]);
                    } else {
                        mensagem = ("%s [%s] %s -- [Leitura #%02d] Instabilidade detectada: Memória RAM - " +
                                "CPU: %d%s | RAM: %d%s | Disco: %d%s -- %s").formatted(verificarRam[1], informacoesRam[1],
                                informacoesRam[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                                ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida, verificarRam[0]);
                    }
                } else {
                    String[] informacoesRam = ram.pegarInformacoes();
                    mensagem = ("%s [%s] %s -- [Leitura #%02d] Monitoramento normal. Componentes estáveis - " +
                            "CPU: %d%s | RAM: %d%s | Disco: %d%s -- %s").formatted(verificarRam[1], informacoesRam[1],
                            informacoesRam[0], i, cpu.metricaAtual, cpu.simboloUnidadeDeMedida, ram.metricaAtual,
                            ram.simboloUnidadeDeMedida, disco.metricaAtual, disco.simboloUnidadeDeMedida, verificarRam[0]);
                }
            
                if (mensagem != null) {
                    System.out.println(mensagem);
                }
                cpu.metricaAtual += 10;
                disco.metricaAtual += 10;
                Thread.sleep(10000);
            }
            // Tratamento de erros
        } catch (InterruptedException e) {
            System.out.println("Erro no esperar 10 segundos.");
        } catch (NullPointerException e) {
            LocalDateTime dataHora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
            String dataHoraFormatada = dataHora.format(formatter);
            System.out.println("WARN [" + Thread.currentThread().getName() + "] "+ Hardware.class.getName() +" -- Leituras " +
                    "mais altas que o normal! - CPU: %d%s | RAM: %d%s | Disco: %d%s -- %s".formatted(cpu.metricaAtual,
                            cpu.simboloUnidadeDeMedida, ram.metricaAtual, ram.simboloUnidadeDeMedida, disco.metricaAtual,
                            disco.simboloUnidadeDeMedida, dataHoraFormatada));
        }

    }
}
