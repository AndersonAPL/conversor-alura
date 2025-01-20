package org.oracleone.model;

import com.google.gson.annotations.SerializedName;

public record ExchangeRecord(
    @SerializedName("base_code") String baseCurrency,
    @SerializedName("target_code") String targetCurrency,
    @SerializedName("conversion_rate") Double exchangeRate
) {
    @Override
    public String toString() {
        return "ExchangeRecord{" +
                "baseCurrency=" + baseCurrency +
                ", targetCurrency=" + targetCurrency +
                ", exchangeRate=" + exchangeRate +" "+ targetCurrency + "/" + baseCurrency  +
                '}';
    }

    @Override
    public String baseCurrency() {
        return baseCurrency;
    }

    @Override
    public String targetCurrency() {
        return targetCurrency;
    }

    @Override
    public Double exchangeRate() {
        return exchangeRate;
    }

    public String exchangeRateToString(){
        return exchangeRate + " " + targetCurrency + "/" + baseCurrency;
    }
}
