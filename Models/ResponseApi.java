package ConversorDeMoedas.Documentacao.Models;

import com.google.gson.annotations.SerializedName;

public class ResponseApi {
    @SerializedName("conversion_rate")
    private double cotacao;
    @SerializedName("time_last_update_utc")
    private String dataCotacao;

    public ResponseApi(ConvercaoApi convercaoApi) {
        this.cotacao = convercaoApi.conversion_rate();
        this.dataCotacao = convercaoApi.time_last_update_utc();
    }

    public double getCotacao() {
        return cotacao;
    }

    public String getDataCotacao() {
        return dataCotacao;
    }

    public double getValorCotado(double valor){
        return this.cotacao * valor;
    }
}
