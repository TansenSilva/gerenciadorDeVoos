package com.desafio.gerenciadorDeVoos.services;

import com.desafio.gerenciadorDeVoos.models.VooModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalculadoraDataChegada {

    public Long calculadora(VooModel vooModel) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        Date horaIni = sdf.parse(vooModel.getHoraPartida());
        Date horaFim = sdf.parse(vooModel.getHoraChegada());

        Long horaI = horaIni.getTime();
        Long horaF = horaFim.getTime();

        Long diferencaHoras = horaF - horaI;

        Long horas = diferencaHoras/ 1000 / 60 / 60;

        return horas;
    }
}
