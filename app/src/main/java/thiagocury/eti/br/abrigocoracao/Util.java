package thiagocury.eti.br.abrigocoracao;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by thiagocury on 02/12/15.
 */
public class Util {

    public static String buscarDataHora(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss");
        // OU
        //SimpleDateFormat dateFormat_hora = new SimpleDateFormat("HH:mm:ss");

        Date data = new Date();

        Calendar cal = Calendar.getInstance();
        cal.setTime(data);

        Date data_atual = cal.getTime();

        String data_completa = dateFormat.format(data_atual);

        //String hora_atual = dateFormat_hora.format(data_atual);
        return data_completa;
    }

    public static Date retornarDate(String date){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataConvertida = new Date();

        try{
            dataConvertida = formato.parse(date);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return dataConvertida;
    }

    public static Date retornarDataBrasil(String date){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataConvertida = new Date();

        try{
            dataConvertida = formato.parse(date);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return dataConvertida;
    }

    public static Date retornarHora(String hora){
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
        Date horaConvertida = new Date();

        try{
            horaConvertida = formato.parse(hora);
        }catch(ParseException e){
            e.printStackTrace();
        }

        return horaConvertida;
    }

    public static int buscarAnoAtual(){
        Calendar cal = Calendar.getInstance();
        int ano = cal.get(Calendar.YEAR);
        return ano;
    }

    public static String converterDataBrasil(String dataEntrada) {

        //Data de entrada - 9999-00-88
        String novaData =
                dataEntrada.substring(8, 10) + "/" +
                        dataEntrada.substring(5, 7) + "/" +
                        dataEntrada.substring(0, 4);

        //Data de saída - 88/00/9999
        return novaData;

        //OLD
        //Data de entrada - 9999-00-99
        //String novaData =
        //eventosAux.get(i).getData().substring(8,10)+"/"+
        //eventosAux.get(i).getData().substring(5,7)+"/"+
        //eventosAux.get(i).getData().substring(0,4);
    }

    public static String converterHoraMinuto(String horaEntrada) {

        //Hora de entrada 09:00:00
        String novaHora = horaEntrada.substring(0, 2) + ":" + horaEntrada.substring(3, 5);

        //Hora de saída - 09:00
        return novaHora;
    }
}