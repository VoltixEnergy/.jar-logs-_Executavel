package school.sptech;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hardware {

    String nome;
    Integer metricaRisco;
    Integer metricaAtual;
    Integer metricaMaxima;
    String simboloUnidadeDeMedida;

    String[] verificar(){
        if (metricaAtual > metricaMaxima) {
            return null;
        }

        LocalDateTime dataHora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
        String dataHoraFormatada = dataHora.format(formatter);
        String[] mensagem = new String[2];

        if (metricaAtual.equals(metricaMaxima)) {
            mensagem[0] = "%s".formatted(dataHoraFormatada);
            mensagem[1] = "WARN";

        } else if (metricaAtual >= metricaRisco) {
            mensagem[0] = "%s".formatted(dataHoraFormatada);
            mensagem[1] = "ERROR";
        } else {
            mensagem[0] = "%s".formatted(dataHoraFormatada);
            mensagem[1] = "INFO";
        }
        return mensagem;
    }

    String[] pegarInformacoes(){
        String localizacao = Hardware.class.getName();
        String nomeThread = Thread.currentThread().getName();
        String[] mensagem = new String[2];
        mensagem[0] = "%s".formatted(localizacao);
        mensagem[1] = "%s".formatted(nomeThread);
        return mensagem;
    }
}
