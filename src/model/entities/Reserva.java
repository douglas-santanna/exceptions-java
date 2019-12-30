package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {
	
	private Integer numeroDoQuarto;
	private Date dataCheckIn;
	private Date dataCheckOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Reserva(Integer numeroDoQuarto, Date dataCheckIn, Date dataCheckOut) {
		if(!dataCheckOut.after(dataCheckIn)){
			throw new DomainException("Data de saída é maior que data de entrada.");
		}
		this.numeroDoQuarto = numeroDoQuarto;
		this.dataCheckIn = dataCheckIn;
		this.dataCheckOut = dataCheckOut;
	}
	
	public Integer getNumeroDoQuarto() {
		return numeroDoQuarto;
	}
	
	public void setNumeroDoQuarto(Integer numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}
	
	public Date getDataCheckIn() {
		return dataCheckIn;
	}
	
	public Date getDataCheckOut() {
		return dataCheckOut;
	}
	
	public long duracao() {
		long diferenca = dataCheckOut.getTime() - dataCheckIn.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public void alterarData(Date dataCheckIn, Date dataCheckOut) {
		Date dataAtual = new Date();
		if(dataCheckIn.before(dataAtual) || dataCheckOut.before(dataAtual)) {
			throw new DomainException("As datas de reserva para atualização devem ser apartir de hoje.");
		}else if(!dataCheckOut.after(dataCheckIn)){
			throw new DomainException("Data de saída é maior que data de entrada.");
		}
		this.dataCheckIn = dataCheckIn;
		this.dataCheckOut = dataCheckOut;
	}
	
	@Override
	public String toString() {
		return "Quarto nº"+ getNumeroDoQuarto() +", "
			  +"Data entrada: "+ sdf.format(dataCheckIn) +", "
			  +"Data saída: "+ sdf.format(dataCheckOut) +", "
			  + duracao() +" noite(s)";
	}
	
}
