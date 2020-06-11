package com.sidiq.covid19.model;

import com.google.gson.annotations.SerializedName;

public class CovidData {

	@SerializedName("provinsi")
	private String provinsi;

	@SerializedName("covid_meninggal")
	private String covidMeninggal;

	@SerializedName("odp_dalam_pemantauan")
	private String odpDalamPemantauan;

	@SerializedName("pdp_masih_dirawat")
	private String pdpMasihDirawat;

	@SerializedName("covid_dirawat")
	private String covidDirawat;

	@SerializedName("covid_isolasi_dirumah")
	private String covidIsolasiDirumah;

	@SerializedName("odp_selesai_pemantauan")
	private String odpSelesaiPemantauan;

	@SerializedName("positif")
	private String positif;

	@SerializedName("kode")
	private String kode;

	@SerializedName("pdp_isolasidirumah")
	private String pdpIsolasidirumah;

	@SerializedName("waktu")
	private String waktu;

	@SerializedName("covid_sembuh")
	private String covidSembuh;

	@SerializedName("pdp_meninggal")
	private String pdpMeninggal;

	@SerializedName("id")
	private String id;

	@SerializedName("total_odp")
	private String totalOdp;

	@SerializedName("pdp")
	private String pdp;

	@SerializedName("pdp_pulangdan_sehat")
	private String pdpPulangdanSehat;



	public void setProvinsi(String provinsi){
		this.provinsi = provinsi;
	}

	public String getProvinsi(){
		return provinsi;
	}

	public void setCovidMeninggal(String covidMeninggal){
		this.covidMeninggal = covidMeninggal;
	}

	public String getCovidMeninggal(){
		return covidMeninggal;
	}

	public void setOdpDalamPemantauan(String odpDalamPemantauan){
		this.odpDalamPemantauan = odpDalamPemantauan;
	}

	public String getOdpDalamPemantauan(){
		return odpDalamPemantauan;
	}

	public void setPdpMasihDirawat(String pdpMasihDirawat){
		this.pdpMasihDirawat = pdpMasihDirawat;
	}

	public String getPdpMasihDirawat(){
		return pdpMasihDirawat;
	}

	public void setCovidDirawat(String covidDirawat){
		this.covidDirawat = covidDirawat;
	}

	public String getCovidDirawat(){
		return covidDirawat;
	}

	public void setCovidIsolasiDirumah(String covidIsolasiDirumah){
		this.covidIsolasiDirumah = covidIsolasiDirumah;
	}

	public String getCovidIsolasiDirumah(){
		return covidIsolasiDirumah;
	}

	public void setOdpSelesaiPemantauan(String odpSelesaiPemantauan){
		this.odpSelesaiPemantauan = odpSelesaiPemantauan;
	}

	public String getOdpSelesaiPemantauan(){
		return odpSelesaiPemantauan;
	}

	public void setPositif(String positif){
		this.positif = positif;
	}

	public String getPositif(){
		return positif;
	}

	public void setKode(String kode){
		this.kode = kode;
	}

	public String getKode(){
		return kode;
	}

	public void setPdpIsolasidirumah(String pdpIsolasidirumah){
		this.pdpIsolasidirumah = pdpIsolasidirumah;
	}

	public String getPdpIsolasidirumah(){
		return pdpIsolasidirumah;
	}

	public void setWaktu(String waktu){
		this.waktu = waktu;
	}

	public String getWaktu(){
		return waktu;
	}

	public void setCovidSembuh(String covidSembuh){
		this.covidSembuh = covidSembuh;
	}

	public String getCovidSembuh(){
		return covidSembuh;
	}

	public void setPdpMeninggal(String pdpMeninggal){
		this.pdpMeninggal = pdpMeninggal;
	}

	public String getPdpMeninggal(){
		return pdpMeninggal;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTotalOdp(String totalOdp){
		this.totalOdp = totalOdp;
	}

	public String getTotalOdp(){
		return totalOdp;
	}

	public void setPdp(String pdp){
		this.pdp = pdp;
	}

	public String getPdp(){
		return pdp;
	}

	public void setPdpPulangdanSehat(String pdpPulangdanSehat){
		this.pdpPulangdanSehat = pdpPulangdanSehat;
	}

	public String getPdpPulangdanSehat(){
		return pdpPulangdanSehat;
	}

	@Override
 	public String toString(){
		return 
			"Covi{" + 
			"provinsi = '" + provinsi + '\'' + 
			",covid_meninggal = '" + covidMeninggal + '\'' + 
			",odp_dalam_pemantauan = '" + odpDalamPemantauan + '\'' + 
			",pdp_masih_dirawat = '" + pdpMasihDirawat + '\'' + 
			",covid_dirawat = '" + covidDirawat + '\'' + 
			",covid_isolasi_dirumah = '" + covidIsolasiDirumah + '\'' + 
			",odp_selesai_pemantauan = '" + odpSelesaiPemantauan + '\'' + 
			",positif = '" + positif + '\'' + 
			",kode = '" + kode + '\'' + 
			",pdp_isolasidirumah = '" + pdpIsolasidirumah + '\'' + 
			",waktu = '" + waktu + '\'' + 
			",covid_sembuh = '" + covidSembuh + '\'' + 
			",pdp_meninggal = '" + pdpMeninggal + '\'' + 
			",id = '" + id + '\'' + 
			",total_odp = '" + totalOdp + '\'' + 
			",pdp = '" + pdp + '\'' + 
			",pdp_pulangdan_sehat = '" + pdpPulangdanSehat + '\'' + 
			"}";
		}


}