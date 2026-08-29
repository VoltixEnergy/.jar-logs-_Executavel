package school.sptech;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GeracaoDeLogs {

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
        String tipoAviso = "";
        String[] mensagem = new String[2];

        if (metricaAtual.equals(metricaMaxima)) {
            tipoAviso = "WARN";
            mensagem[0] = "%s".formatted(dataHoraFormatada);
            mensagem[1] = "%s".formatted(tipoAviso);

        } else if (metricaAtual >= metricaRisco) {
            tipoAviso = "ERROR";
            mensagem[0] = "%s".formatted(dataHoraFormatada);
            mensagem[1] = "%s".formatted(tipoAviso);
        }
        return mensagem;
    }

    String[] pegarInformacoes(){
        String localizacao = GeracaoDeLogs.class.getName();
        String nomeThread = Thread.currentThread().getName();
        String[] mensagem = new String[2];
        mensagem[0] = "%s".formatted(localizacao);
        mensagem[1] = "%s".formatted(nomeThread);
        return mensagem;
    }
}
